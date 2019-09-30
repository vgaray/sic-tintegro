package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.PlanPrincipal;
import pe.com.tintegro.dominio.PlanSaliente;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.ListarContextoPorPlanRequest;
import pe.com.tintegro.dto.request.ListarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ListarContextoPorPlanResponse;
import pe.com.tintegro.dto.response.ListarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;
import pe.com.tintegro.services.GenerarPlanMarcacionServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PlanPrincipalServices;
import pe.com.tintegro.services.PlanSalienteServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.UtilFile;

@Service("generarPlanMarcacionServices")
@Transactional
public class GenerarPlanMarcacionServicesImpl implements GenerarPlanMarcacionServices {
	@Resource(name = "planPrincipalServices")
	protected PlanPrincipalServices planPrincipalServices;

	@Resource(name = "planSalienteServices")
	protected PlanSalienteServices planSalienteServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public String generarTxtPlanMarcacion(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);

		ListarPlanSalienteRequest request = new ListarPlanSalienteRequest();
		ListarPlanSalienteResponse lstPlanResponse = planSalienteServices.listarPlanSaliente(codUsuario, idInstancia, request);

		ListarPlanPrincipalRequest requestPrincipal = new ListarPlanPrincipalRequest();
		ListarPlanPrincipalResponse lstPlanPrincipalResponse = planPrincipalServices.listarPlanPrincipal(codUsuario, idInstancia, requestPrincipal);

		String contenido = writePlanMarcacion(codUsuario, idInstancia, lstPlanResponse.getListado(), lstPlanPrincipalResponse.getListado());

		File file = UtilFile.writeFile(contenido, servicesProperties.getFileNamePlanPrincipal());
		String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), servicesProperties.getPathFilePlanPrincipal());
		file.delete();
		System.out.println(fileExport);
		try {
			LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "asterisk -rx 'dialplan reload'");
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo Plan");
		}
		return contenido;
	}

	@Override
	public String writePlanMarcacion(String codUsuario, String idInstancia, List<PlanSaliente> listadoSaliente, List<PlanPrincipal> listadoPrincipal) throws Exception {
		String contenido = "";
		String nomPlan = "";
		try {
			for (PlanPrincipal principal : listadoPrincipal) {
				ListarContextoPorPlanRequest requestContexto = new ListarContextoPorPlanRequest();
				requestContexto.setIdPlanPrincipal(principal.getIdPlanPrincipal());
				ListarContextoPorPlanResponse lstContexto = planPrincipalServices.listarContextoPorPlan(codUsuario, idInstancia, requestContexto);

				nomPlan = principal.getNoNombre();
				contenido += "[context-out-from-" + nomPlan.trim().replace(" ", "-") + "]" + System.getProperty("line.separator");

				// contenido += "include => to-anexos"+
				// System.getProperty("line.separator");
				// contenido += "include => to-funciones-central"+
				// System.getProperty("line.separator");
				for (String contexto : lstContexto.getListado()) {
					contenido += "include => to-" + contexto.substring(contexto.indexOf("_") + 1, contexto.length() - 2) + System.getProperty("line.separator");
				}
				contenido += System.getProperty("line.separator");
			}

			contenido += System.getProperty("line.separator");

			for (PlanSaliente saliente : listadoSaliente) {
				nomPlan = saliente.getNoNombre();
				contenido += "[to-" + nomPlan.trim().replace(" ", "-") + "]" + System.getProperty("line.separator");

				String exten = "EXTEN";
				if (saliente.getNuQuitarPrefijo() != null) {
					if (saliente.getNuQuitarPrefijo() != 0) {
						exten = "EXTEN:" + saliente.getNuQuitarPrefijo();
					}
				}

				String sufijo = "";
				System.out.println(saliente.getNoNombre() + " " + saliente.getNoSufijo());
				if (saliente.getNoSufijo() != null) {
					if (!saliente.getNoSufijo().equals(0)) {
						sufijo = saliente.getNoSufijo();
					}
				}

				System.out.println(saliente.getNoNombre() + " " + saliente.getNoPrefijo());
				String prefijo = "";
				if (saliente.getNoPrefijo() != null) {
					if (!saliente.getNoPrefijo().equals(0)) {
						prefijo = saliente.getNoPrefijo();
					}
				}
				if (saliente.getNuQuitarSufijo() == null || saliente.getNuQuitarSufijo() == 0) {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",1,Set(NUMBER=" + prefijo + "${" + exten + "}" + sufijo + ")" + System.getProperty("line.separator");
				} else {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",1,Set(NUMBER=" + prefijo + "${" + exten + ":-" + saliente.getNuQuitarSufijo() + "}" + sufijo + ")" + System.getProperty("line.separator");
				}
				if (saliente.getIltemporizado() != null && saliente.getIltemporizado() != 0) {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Set(TEMPO=" + Integer.parseInt(saliente.getHoTemporizado()) * 60000 + ")" + System.getProperty("line.separator");
				}
				if (saliente.getIlListaNegra() != null && saliente.getIlListaNegra() != 0) {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Macro(blackout,${NUMBER})" + System.getProperty("line.separator");
				}
				if (saliente.getIlHorarioLlamada() != null && saliente.getIlHorarioLlamada() != 0) {
					String diaInicio = "";
					String diaFinal = "";
					if (saliente.getFeInicio().equals("0")) {
						diaInicio = "mon";
					} else if (saliente.getFeInicio().equals("1")) {
						diaInicio = "tue";
					} else if (saliente.getFeInicio().equals("2")) {
						diaInicio = "wed";
					} else if (saliente.getFeInicio().equals("3")) {
						diaInicio = "thu";
					} else if (saliente.getFeInicio().equals("4")) {
						diaInicio = "fri";
					} else if (saliente.getFeInicio().equals("5")) {
						diaInicio = "sat";
					} else if (saliente.getFeInicio().equals("6")) {
						diaInicio = "sun";
					}

					if (saliente.getFeFin().equals("0")) {
						diaFinal = "mon";
					} else if (saliente.getFeFin().equals("1")) {
						diaFinal = "tue";
					} else if (saliente.getFeFin().equals("2")) {
						diaFinal = "wed";
					} else if (saliente.getFeFin().equals("3")) {
						diaFinal = "thu";
					} else if (saliente.getFeFin().equals("4")) {
						diaFinal = "fri";
					} else if (saliente.getFeFin().equals("5")) {
						diaFinal = "sat";
					} else if (saliente.getFeFin().equals("6")) {
						diaFinal = "sun";
					}
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,GotoIfTime(" + saliente.getHoInicio().substring(0, saliente.getHoInicio().length() - 3) + "-" + saliente.getHoFin().substring(0, saliente.getHoInicio().length() - 3) + "," + diaInicio + "-" + diaFinal
							+ ",*,*?context-val:context-inval)" + System.getProperty("line.separator");
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n(context-val),NoOP(Ingreso de horario validado)" + System.getProperty("line.separator");
				}
				if (saliente.getIlClaveUsuario() != null && saliente.getIlClaveUsuario() != 0) {
					String nomClave = "";
					if (saliente.getNuTipo() == 0) {
						nomClave = "Fijo-Local";
					} else if (saliente.getNuTipo() == 1) {
						nomClave = "Fijo-Nacional";
					} else if (saliente.getNuTipo() == 2) {
						nomClave = "Fijo-Internacional";
					} else if (saliente.getNuTipo() == 3) {
						nomClave = "Celular-Nacional";
					} else if (saliente.getNuTipo() == 4) {
						nomClave = "Celular-Internacional";
					} else if (saliente.getNuTipo() == 5) {
						nomClave = "RPM";
					}
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Macro(" + nomClave + ",${CALLERID(NUM)},${NUMBER})" + System.getProperty("line.separator");
				}
				if (saliente.getIltemporizado() != null && saliente.getIltemporizado() != 0) {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Dial(SIP/${NUMBER}@" + saliente.getNoTroncal() + ",30,${DIALOPTS}L(${TEMPO}:30000))" + System.getProperty("line.separator");
				} else {
					contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Dial(SIP/${NUMBER}@" + saliente.getNoTroncal() + ",30,${DIALOPTS})" + System.getProperty("line.separator");
				}
				contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Hangup()" + System.getProperty("line.separator");
				contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n(context-inval),Playback(llamada-no-permitida)" + System.getProperty("line.separator");
				contenido += "exten => _" + saliente.getNoPatron().toUpperCase() + ",n,Hangup()" + System.getProperty("line.separator");

				contenido += System.getProperty("line.separator");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contenido;
	}
}
