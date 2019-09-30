package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ListaNegraDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dto.request.BuscarListaNegraRequest;
import pe.com.tintegro.dto.request.CambiaEstadoListaNegraRequest;
import pe.com.tintegro.dto.request.EliminarListaNegraRequest;
import pe.com.tintegro.dto.request.ActualizarListaNegraRequest;
import pe.com.tintegro.dto.request.InsertarListaNegraRequest;
import pe.com.tintegro.dto.request.ListarListaNegraRequest;
import pe.com.tintegro.dto.response.BuscarListaNegraResponse;
import pe.com.tintegro.dto.response.CambiaEstadoListaNegraResponse;
import pe.com.tintegro.dto.response.EliminarListaNegraResponse;
import pe.com.tintegro.dto.response.ActualizarListaNegraResponse;
import pe.com.tintegro.dto.response.InsertarListaNegraResponse;
import pe.com.tintegro.dto.response.ListarListaNegraResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.ListaNegraServices;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.Validadores;


@Service("listaNegraServices")
@Transactional
public class ListaNegraServicesImpl implements ListaNegraServices {

	@Resource(name = "listaNegraDAO")
	protected ListaNegraDAO listaNegraDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public InsertarListaNegraResponse insertarListaServices(String codUsuario, String idInstancia, InsertarListaNegraRequest request) throws Exception {
		request.setCoTipllamSig(Util.devoverCodTipoLlamada(request.getCoTipllam()));
		InsertarListaNegraResponse response = new InsertarListaNegraResponse();
		if (request.getNuTelefo().isEmpty()) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("Ingrese Número Telefónico");
		} else if (!(Validadores.esNumeroTelefonico(request.getNuTelefo()))) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("El numero telefonico ingresado no es permitido");
		}
		else if (request.getNuTelefo().length() > 20) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("El numero telefonico ingresado sobrepasa la cantidad de dígitos");
		} else if (request.getNoDescri().length() > 150) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("La cantidad de caracteres ingresada sobrepasa lo permitido");
		}
		else {
			String ip = instanciaServices.determinarIp(idInstancia);
			response = listaNegraDAO.insertarLista(ip, request);
		}
		return response;
	}

	@Override
	public ListarListaNegraResponse listarListaNegraServices(String codUsuario, String idInstancia, ListarListaNegraRequest request) throws Exception {
		ListarListaNegraResponse response = new ListarListaNegraResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = listaNegraDAO.listarListaNegra(ip, request);
		return response;
	}

	@Override
	public ActualizarListaNegraResponse actualizarListaServices(String codUsuario, String idInstancia, ActualizarListaNegraRequest request) throws Exception {
		request.setCoTipllamSig(Util.devoverCodTipoLlamada(request.getCoTipllam()));
		ActualizarListaNegraResponse response = new ActualizarListaNegraResponse();
		if (request.getNoDescri().length() > 150) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("La cantidad de caracteres ingresada sobrepasa lo permitido");
		} else {
			String ip = instanciaServices.determinarIp(idInstancia);
			response = listaNegraDAO.actualizarLista(ip, request);
		}
		return response;
	}

	@Override
	public EliminarListaNegraResponse eliminarListaNegraServices(String codUsuario, String idInstancia, EliminarListaNegraRequest request) throws Exception {
		EliminarListaNegraResponse response = new EliminarListaNegraResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = listaNegraDAO.eliminarListaNegra(ip, request);
		return response;
	}

	@Override
	public CambiaEstadoListaNegraResponse cambiaEstadoListaNegra(String codUsuario, String idInstancia, CambiaEstadoListaNegraRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return listaNegraDAO.cambiaEstadoListaNegra(ip, request);
	}

	@Override
	public BuscarListaNegraResponse buscarListaNegraServices(String codUsuario, String idInstancia, BuscarListaNegraRequest request) throws Exception {
		BuscarListaNegraResponse response = new BuscarListaNegraResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = listaNegraDAO.buscarListaNegra(ip, request);
		return response;
	}

}
