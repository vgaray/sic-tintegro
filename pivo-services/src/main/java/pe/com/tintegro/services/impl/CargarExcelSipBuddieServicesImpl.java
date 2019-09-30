package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.SipTelefonoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.CargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.DescargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.GeneraClaveAnexoSipRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.CargaExcelSipBuddieResponse;
import pe.com.tintegro.dto.response.DescargaSipTelefonoResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaExcelResponse;
import pe.com.tintegro.services.CargarExcelSipBuddieServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.MarcaTelefonoServices;
import pe.com.tintegro.services.ModeloTelefonoServices;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.CompareCallback;
import pe.com.tintegro.services.util.ExcelUtil;
import pe.com.tintegro.services.util.UtilList;

@Service("cargarExcelSipBuddieServices")
@Transactional
public class CargarExcelSipBuddieServicesImpl implements CargarExcelSipBuddieServices {
	// private static final String UNCHECKED = "unchecked";

	@Autowired
	InstanciaServices instanciaServices;

	@Autowired
	SipTelefonoDAO sipTelefonoDAO;

	@Autowired
	private MarcaTelefonoServices marcaTelefonoServices;

	@Autowired
	private ModeloTelefonoServices modeloTelefonoServices;

	@Autowired
	private SipBuddieServices sipBuddieServices;

	@Value(value = "classpath:csvExcel/editausuarioSip.csv")
	private org.springframework.core.io.Resource csvResource;

	@Value(value = "classpath:csvExcel/listaUsuarioSip.csv")
	private org.springframework.core.io.Resource csvUsuarioSip;

	@Override
	public InsertaSipBuddieResponse cargarSipBuddieList(String codUsuario, String idInstancia, List<InsertaSipBuddieRequest> ListSipBuddie) throws Exception {
		InsertaSipBuddieRequest request = new InsertaSipBuddieRequest();
		List<InsertaSipBuddieRequest> lista = new ArrayList<InsertaSipBuddieRequest>();
		InsertaSipBuddieResponse response = new InsertaSipBuddieResponse();
		List<MarcaTelefono> listaMarca = marcaTelefonoServices.listaMarcaTelefono(codUsuario, idInstancia).getMarcaTelefonoList();
		GeneraClaveAnexoSipRequest requestGenerar = new GeneraClaveAnexoSipRequest();
		String clave = "";
		lista = ListSipBuddie;

		for (int i = 0; i < lista.size(); i++) {
			request.setNomUsuario(lista.get(i).getNomUsuario());
			clave = sipBuddieServices.generateAnnexID(codUsuario, idInstancia, requestGenerar);
			request.setClaveUsuario(clave);
			request.setCallerId(lista.get(i).getCallerId());
			request.setBuzonBox(lista.get(i).getNomUsuario());
			request.setCorreoBox(lista.get(i).getCorreoBox());
			request.setRuta(null);
			if (lista.get(i).getNomMarca() != null) {
				if (!lista.get(i).getNomMarca().equals("")) {
					for (int j = 0; j < listaMarca.size(); j++) {
						if (lista.get(i).getNomMarca().equals(listaMarca.get(j).getNomMarca())) {
							request.setMarcaId(listaMarca.get(j).getMarcaId());
							ListaModeloTelefonoPorMarcaRequest modelorequest = new ListaModeloTelefonoPorMarcaRequest();
							modelorequest.setMarcaId(request.getMarcaId());
							List<ModeloTelefono> listaModelo = modeloTelefonoServices.listaModeloTelefonoPorMarca(codUsuario, idInstancia, modelorequest).getModeloTelefonoList();
							for (int j2 = 0; j2 < listaModelo.size(); j2++) {
								if (lista.get(i).getNomMarca().equals(listaModelo.get(j2).getNomModelo())) {
									request.setModeloId(listaModelo.get(j2).getModeloId());
									break;
								} else {
									request.setMarcaId(0);
									request.setModeloId(0);
									request.setMac("");
								}
							}
						} else {
							request.setMarcaId(0);
							request.setModeloId(0);
							request.setMac("");
						}
					}
				}
			} else {
				request.setMarcaId(0);
				request.setModeloId(0);
				request.setMac("");
			}
			request.setNomMarca(lista.get(i).getNomMarca());
			request.setNomModelo(lista.get(i).getNomModelo());
			response = sipBuddieServices.insertarSipBuddie(codUsuario, idInstancia, request);
		}
		return response;
	}

	@SuppressWarnings("unchecked")
	public CargaExcelSipBuddieResponse cargarExcelSipBuddie(String codUsuario, String idInstancia, CargaExcelSipBuddieRequest request) throws Exception {
		CargaExcelSipBuddieResponse response = new CargaExcelSipBuddieResponse();
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		List<SipTelefono> lsSIPTelefonoActual = sipTelefonoDAO.listaSipTelefono(vm.getIpAsterisk()).getSipTelefonoList();
		List<?> sipBuddieList = null;
		try {
			ValidaExcelResponse res = validarExcelSipTelefono(request.getExcelBase64());

			if (res.getListaErrores().size() > 0) {
				response.setEstado(res.getEstado());
				response.setListaErrores(res.getListaErrores());
			} else {
				try {
					sipBuddieList = ExcelUtil.listarObjectos("pe.com.tintegro.dto.request.InsertaSipBuddieRequest", csvResource, request.getExcelBase64());
					ValidaExcelResponse respo = validaCantidadAnexos(lsSIPTelefonoActual, (List<InsertaSipBuddieRequest>) sipBuddieList, codUsuario, idInstancia);

					if (respo.getListaErrores().size() > 0) {
						response.setEstado(respo.getEstado());
						response.setListaErrores(respo.getListaErrores());
					} else {
						try {
							cargarSipBuddieList(codUsuario, idInstancia, (List<InsertaSipBuddieRequest>) sipBuddieList);
							response.setEstado(Constantes.ESTADO_TRAMA_OK);
							response.setListaErrores(respo.getListaErrores());
							response.setMensaje("Ok");
						} catch (Exception ex) {
							System.out.print("No entra al metodo cargar cargarSipBuddieList");
							throw new Exception("No entra al metodo cargar cargarSipBuddieList");
						}
					}
				} catch (Exception ex) {
					System.out.print("No se esta validando el contenido");
					throw new Exception("No se esta validando el contenido");
				}
			}
		} catch (Exception ex) {
			System.out.print("No se esta validando las cabeceras");
			throw new Exception("No se esta validando las cabeceras");
		}
		return response;
	}

	@Override
	public DescargaSipTelefonoResponse descargaSipTelefono(String codUsuario, String idInstancia, DescargaExcelSipBuddieRequest request) throws Exception {
		DescargaSipTelefonoResponse response = new DescargaSipTelefonoResponse();
		ListaSipTelefonoResponse responseT = new ListaSipTelefonoResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		responseT.setSipTelefonoList(sipTelefonoDAO.listaSipTelefono(ip).getSipTelefonoList());

		List<SipTelefono> sipTelefonoList = responseT.getSipTelefonoList();
		for (int i = 0; i < sipTelefonoList.size(); i++) {
			if (sipTelefonoList.get(i).getNomMarca() != null && sipTelefonoList.get(i).getNomMarca().equals("NO-APROV")) {
				sipTelefonoList.get(i).setNomMarca("");
				sipTelefonoList.get(i).setNomModelo("");
				sipTelefonoList.get(i).setNomMac("");
			}
		}
		String fileString = ExcelUtil.generarExcel(csvUsuarioSip, sipTelefonoList);
		response.setReporteFile(fileString);
		return response;
	}

	@Override
	public ValidaExcelResponse validarExcelSipTelefono(String fileStringBase64) throws Exception {
		ValidaExcelResponse validaExcelresponse = ExcelUtil.compararCSVconExcel(csvResource, fileStringBase64);
		return validaExcelresponse;

	}

	@Override
	public ValidaExcelResponse validaCantidadAnexos(final List<SipTelefono> lsSIPTelefonoActual, List<InsertaSipBuddieRequest> listaSip, String codUsuario, String idInstancia) throws Exception {
		ValidaExcelResponse response = new ValidaExcelResponse();
		List<String> listaErrores = new ArrayList<String>();
		listaErrores.clear();
		if (listaSip.size() == 0) {
			listaErrores.add("No se ha encontrado relacion de anexos a llenar");
		}
		else {
			/**
			 * Se verifica el número de repeticiones de un item de la lista
			 * actual de anexos en en la nueva lista que viene desde el
			 * documento excel.
			 */
			int numeroRepeticiones;
			for (SipTelefono itemSIPActual : lsSIPTelefonoActual) {
				if (itemSIPActual.getNomUsuario() == null || itemSIPActual.getNomUsuario().equals("")) { // Si el numero de anexo es vacío o nulo
					System.out.println(itemSIPActual.getNomUsuario());
					listaErrores.add("No se permiten números de anexo vacíos.");
				} else {
					numeroRepeticiones = UtilList.frecuencyValue(itemSIPActual, listaSip, new CompareCallback<SipTelefono, InsertaSipBuddieRequest>() {
						@Override
						public boolean compare(SipTelefono sipTelefono, InsertaSipBuddieRequest sipBuddieRequest) {
							return sipBuddieRequest.getNomUsuario().equals(sipTelefono.getNomUsuario());
						}
					});
					if (numeroRepeticiones > 1)
						listaErrores.add(String.format("No se permiten números de anexos repetidos: (%s)", itemSIPActual.getNomUsuario()));
				}
			}
		}
		if (listaErrores.size() > 0) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setListaErrores(listaErrores);
		} else {
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setListaErrores(listaErrores);
		}
		return response;
	}

}
