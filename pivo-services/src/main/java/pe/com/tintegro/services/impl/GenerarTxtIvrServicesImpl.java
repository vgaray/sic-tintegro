package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.tintegro.dao.GenerarTxtIvrDAO;
import pe.com.tintegro.dominio.GenerarTxtIvr;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.IvrOpcion;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.GenerarTxtIvrReques;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.GenerarTxtIvrResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;
import pe.com.tintegro.services.GenerarTxtIvrServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.IvrOpcionServices;
import pe.com.tintegro.services.util.IVRUtil;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@Service("generarTxtIvrServices")
public class GenerarTxtIvrServicesImpl implements GenerarTxtIvrServices {

	@Autowired
	private GenerarTxtIvrDAO generarTxtIvrDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private IvrOpcionServices ivrOptionServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Override
	public String generarSeccionIVR(String codUsuario, List<IvrOpcion> lsIvrOptions) throws Exception {
		return IVRUtil.generateStringSectorIVR(lsIvrOptions);
	}

	String hoIni, hoFIn, diIni, diFin, nuDiIni, nuDiFin, meIni, meFin, noAudio, ilEstado;

	private void variables(GenerarTxtIvr objHo) {

		hoIni = objHo.getHoInicio();
		if (hoIni.equals("*")) {
			hoIni = "";
		}
		hoFIn = objHo.getHoFin();

		if (!hoFIn.equals("*")) {
			hoFIn = "-" + hoFIn;
		}

		// Dia Letras
		diIni = objHo.getNoDiaSemanaInicio();
		diFin = objHo.getNoDiaSemanaFin();
		if (!diIni.equals(diFin)) {
			if (diIni.equals("*")) {
				diIni = "";
			}
			if (!diFin.equals("*")) {
				diFin = "-" + diFin;
			}
		} else {
			diIni = "";
		}

		// Dia en Numeros
		nuDiIni = objHo.getNoDiaMesInicio();
		nuDiFin = objHo.getNoDiaMesFin();
		if (!nuDiIni.equals(nuDiFin)) {
			if (nuDiIni.equals("*")) {
				nuDiIni = "";
			}
			if (!nuDiFin.equals("*")) {
				nuDiFin = "-" + nuDiFin;
			}
		} else {
			nuDiIni = "";
		}

		// Mes
		meIni = objHo.getNoMesInicio();
		meFin = objHo.getNoMesFin();
		if (!meIni.equals(meFin)) {
			if (meIni.equals("*")) {
				meIni = "";
			}
			if (!meFin.equals("*")) {
				meFin = "-" + meFin;
			}
		} else {
			meIni = "";
		}

		// Audio si es cerrado
		noAudio = objHo.getNoAudio();
		if (objHo.getTiHorario() == 1) { // 1 = abierto 2 = cerrado
			ilEstado = "abierto" + objHo.getIdHorario();
		} else {
			ilEstado = "cerrado" + objHo.getIdHorario();
		}
	}

	@Override
	public String generarHorarioIVR(String codUsuario, List<GenerarTxtIvr> listaH) throws Exception {
		String resulHorario = "";

		List<Integer> idsGruposDeHorarios = new ArrayList<Integer>();
		Map<Integer, String> mapGruposHorarios = new HashMap<Integer, String>();

		for (GenerarTxtIvr generarTxtIvr : listaH) {
			for (GenerarTxtIvr generarTxtIvrAux : listaH) {
				if (generarTxtIvr.getIdGrupoHor() == generarTxtIvrAux.getIdGrupoHor()) {
					if (!idsGruposDeHorarios.contains(generarTxtIvr.getIdGrupoHor())) {
						idsGruposDeHorarios.add(generarTxtIvr.getIdGrupoHor());
						mapGruposHorarios.put(generarTxtIvr.getIdGrupoHor(), generarTxtIvr.getNoGurpoHor());
					}
				}
			}
		}

		for (Integer idGrupoHorario : idsGruposDeHorarios) {
			resulHorario += "[" + mapGruposHorarios.get(idGrupoHorario) + "]" + System.getProperty("line.separator");
			resulHorario += "exten => s,1,Answer()" + System.getProperty("line.separator");

			GenerarTxtIvr hor = null;
			for (int i = 0; i < listaH.size(); i++) {
				hor = listaH.get(i);

				boolean flag = idGrupoHorario.toString().equals(hor.getIdGrupoHor().toString());

				if (flag) {
					resulHorario += "same => n,GotoIfTime(" + hor.getHoInicio() + "-" + hor.getHoFin() + "," + (hor.getNoDiaSemanaInicio().equals("*") && hor.getNoDiaSemanaFin().equals("*") ? "*" : hor.getNoDiaSemanaInicio() + "-" + hor.getNoDiaSemanaFin()) + ","
							+ (hor.getNoDiaMesInicio().equals("*") && hor.getNoDiaMesFin().equals("*") ? "*" : hor.getNoDiaMesInicio() + "-" + hor.getNoDiaMesFin()) + "," + (hor.getNoMesInicio().equals("*") && hor.getNoMesFin().equals("*") ? "*" : hor.getNoMesInicio() + "-" + hor.getNoMesFin())
							+ "?" + (hor.getTiHorario() == 1 ? "abierto" : "cerrado") + hor.getIdHorario() + ")" + System.getProperty("line.separator");
				}
			}

			// for ( GenerarTxtIvr hor : listaH )
			// {
			// if( idGrupoHorario == hor.getIdGrupoHor() )
			// {
			// resulHorario += "same => n,GotoIfTime(" + hor.getHoInicio() + "-"
			// + hor.getHoFin()
			// + "," + hor.getNoDiaSemanaInicio() + "-"
			// + hor.getNoDiaSemanaFin()
			// + "," + hor.getNoDiaMesInicio() + "-"
			// + hor.getNoDiaMesFin()
			// + "," + hor.getNoMesInicio() + "-"
			// + hor.getNoMesFin() + ",*?"
			// + ( hor.getTiHorario() == 1 ? "abierto" : "cerrado" ) +
			// hor.getIdHorario() + ")" + System.getProperty( "line.separator"
			// );
			// }
			// }

			resulHorario += "same => n,Hangup()" + System.getProperty("line.separator");

			for (int i = 0; i < listaH.size(); i++) {
				hor = listaH.get(i);
				if (idGrupoHorario.toString().equals(hor.getIdGrupoHor().toString())) {
					if (hor.getTiHorario().equals(Util.ABIERTO)) {
						resulHorario += "same => n(abierto" + hor.getIdHorario() + "),Goto(" + hor.getNoIVR() + ",s,1)" + System.getProperty("line.separator");
					} else if (hor.getTiHorario().equals(Util.CERRADO)) {
						resulHorario += "same => n(cerrado" + hor.getIdHorario() + "),Playback(ivr/" + Util.eliminarExtensionDeNombreDeArchivo(hor.getNoAudio()) + ")" + System.getProperty("line.separator");
					}

					resulHorario += "same => n,Hangup()" + System.getProperty("line.separator");
				}
			}

			// for ( GenerarTxtIvr hor : listaH )
			// {
			// if( idGrupoHorario == hor.getIdGrupoHor() )
			// {
			// resulHorario += "same => n(" + ( hor.getTiHorario() == 1 ?
			// "abierto" : "cerrado" ) + hor.getIdHorario() + "),Goto(" +
			// hor.getNoIVR() + ",s,1)" + System.getProperty( "line.separator"
			// );
			// resulHorario += "same => n,Hangup()" + System.getProperty(
			// "line.separator" );
			// }
			// }
		}

		// for ( GenerarTxtIvr generarTxtIvr : listaH )
		// {
		// resulHorario += "same => n(" + ( generarTxtIvr.getTiHorario() == 1 ?
		// "abierto" : "cerrado" ) + generarTxtIvr.getIdHorario() + "),Goto(" +
		// generarTxtIvr.getNoIVR() + ",s,1)" + System.getProperty(
		// "line.separator" );
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		// }
		//
		//
		// int auxidHo = 0;
		//
		// for ( int k = 0; k < listaH.size(); k++ )
		// {
		// int idHo = listaH.get( k ).getIdGrupoHor();
		// if ( idHo != auxidHo )
		// {
		// if ( idHo != auxidHo )
		// {
		// resulHorario += System.getProperty( "line.separator" );
		// resulHorario += "[" + listaH.get( k ).getNoGurpoHor() + "]" +
		// System.getProperty( "line.separator" );
		// resulHorario += "exten => s,1,Answer" + System.getProperty(
		// "line.separator" );
		//
		// }
		//
		// for ( int i = 0; i < listaH.size(); i++ )
		// {
		// if ( idHo == listaH.get( i ).getIdGrupoHor() )
		// {
		// variables( listaH.get( i ) );
		// // same => n,GotoIfTime(hoIni-hoFin, diIni-diFin,
		// // nuDiIn-nuDiFi, meIni-meFin, año(*)?abierto);
		// resulHorario += "same => n,GotoIfTime(" + hoIni + hoFIn + "," + diIni
		// + diFin + "," + nuDiIni + nuDiFin + "," + meIni + meFin + ",*?" +
		// ilEstado + ")" + System.getProperty( "line.separator" );
		// }
		// }
		//
		// if ( idHo != auxidHo )
		// {
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		// for ( GenerarTxtIvr generarTxtIvr : listaH )
		// {
		// resulHorario += "same => n(" + ( generarTxtIvr.getTiHorario() == 1 ?
		// "abierto" : "cerrado" ) + generarTxtIvr.getIdHorario() + "),Goto(" +
		// generarTxtIvr.getNoIVR() + ",s,1)" + System.getProperty(
		// "line.separator" );
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		// }
		//
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		// resulHorario += "same => n(" + ilEstado + "),Goto(" + listaH.get( k
		// ).getNoIVR() + ",s,1)" + System.getProperty( "line.separator" );
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		//
		// for ( int n = 0; n < listaH.size(); n++ )
		// {
		// if ( idHo == listaH.get( n ).getIdGrupoHor() )
		// {
		// variables( listaH.get( n ) );
		// if ( listaH.get( n ).getTiHorario() == 2 )
		// {
		//
		// resulHorario += "same => n(" + ilEstado + "),Playback(" + noAudio +
		// ")" + System.getProperty( "line.separator" );
		// resulHorario += "same => n,Hangup()" + System.getProperty(
		// "line.separator" );
		// }
		// auxidHo = listaH.get( n ).getIdGrupoHor();
		// }
		// }
		// }
		// }
		// }

		return resulHorario;
	}

	@Override
	public String generarArchivoIVREnServidorAsterisk(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);

		ListarIvrOpcionResponse lsIvrOptionsResponse = ivrOptionServices.listarIvrResponse(codUsuario, idInstancia, new ListarIvrOpcionRequest());
		GenerarTxtIvrResponse listHorario = generarTxtIvrDAO.listarGenerarTxtIvr(vm.getIpAsterisk(), new GenerarTxtIvrReques());

		String ivrOptions = generarSeccionIVR(codUsuario, lsIvrOptionsResponse.getListaIvrOpcion());
		String ivrHorarios = generarHorarioIVR(codUsuario, listHorario.getListGenerarTxtIvr());

		String strFinalFileIVR = ivrHorarios + ivrOptions;

		File fileIVR = UtilFile.writeFile(strFinalFileIVR, servicesProperties.getFileNameAsteriskIVR());

		String strFileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), fileIVR.getPath(), servicesProperties.getPathFileAsteriskIVR());

		fileIVR.delete();

		System.out.println(strFileExport);

		try {
			LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "asterisk -rx 'dialplan reload'");
		} catch (Exception e) {
			throw new Exception("Fallo en la actualización de cambios recientes en IVR.");
		}
		return strFinalFileIVR;
	}
}
