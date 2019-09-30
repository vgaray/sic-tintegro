package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.RolDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.EliminaRolRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.response.EliminaRolResponse;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.RolServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@Service("rolServices")
@Transactional
public class RolServicesImpl implements RolServices {
	
	@Resource(name = "rolDAO")
	protected RolDAO rolDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListarRolPorTipoRolResponse listarRolesServices(ListarRolPorTipoRolRequest request) throws Exception {
		ListarRolPorTipoRolResponse response = new ListarRolPorTipoRolResponse();
		response = rolDAO.listarRolPorTipo(request);
		return response;
	}

	@Override
	public ListaRolPorInstanciaResponse listarRolPorPaginaServices(ListaRolPorInstanciaRequest request) throws Exception {
		ListaRolPorInstanciaResponse response = new ListaRolPorInstanciaResponse();
		request.setIdInstanciaDeco(instanciaServices.desincriptarIdInstancia(request.getIdInstancia()));
		response = rolDAO.listarRolPorPagina(request);
		return response;
	}

	@Override
	public ListaRolSinInstanciaResponse listarRolSinInstanciaServices(ListaRolSinInstanciaRequest request) throws Exception {
		ListaRolSinInstanciaResponse response = new ListaRolSinInstanciaResponse();
		response = rolDAO.listaRolSinInstancia(request);
		return response;
	}

	@Override
	public RolResponse crearRol(String codUsuario, String idInstancia, RolRequest request) throws Exception {
		RolResponse response = new RolResponse();
		Integer idInst = 0;
		idInst = instanciaServices.desincriptarIdInstancia(idInstancia);
		request.setIdInstancia(idInst);
		response = rolDAO.crearRol(request);
		return response;
	}

	@Override
	public RolResponse asignarPaginaPorRol(String codUsuario, String idInstancia, AsignarPaginaRolRequest request) throws Exception {
		RolResponse response = new RolResponse();
		response = rolDAO.AsignarPaginaPorRol(request);
		return response;
	}

	@Override
	public RolResponse asignarPaginaPorRolTotal(String codUsuario, String idInstancia, RolRequest request) throws Exception {
		RolResponse rolResponse = new RolResponse();
		rolResponse = crearRol(codUsuario, idInstancia, request);

		if (rolResponse.getIdRol() != 0) {
			List<AsignarPaginaRolRequest> listaRol = new ArrayList<AsignarPaginaRolRequest>();
			listaRol = request.getListPaginaRol();
			AsignarPaginaRolRequest requesAsg = new AsignarPaginaRolRequest();
			requesAsg.setIdRol(rolResponse.getIdRol());

			for (int i = 0; i < listaRol.size(); i++) {
				requesAsg.setIdPagina(listaRol.get(i).getIdPagina());
				asignarPaginaPorRol(codUsuario, idInstancia, requesAsg);
			}
		}
		return rolResponse;
	}

	@Override
	public RolResponse actualizarRol(String codUsuario, String idInstancia, ActualizarRolRequest request) throws Exception {
		RolResponse response = new RolResponse();
		Integer idInstanciaInteger = EncriptaUtils.esEcriptacionValida(idInstancia) ? Integer.parseInt(EncriptaUtils.desencriptar(idInstancia)) : null;
		request.setIdInstancia(idInstanciaInteger);
		response = rolDAO.actualizarRol(request);
		return response;
	}

	@Override
	public RolResponse actualizarRolTotal(String codUsuario, String idInstancia, ActualizarRolRequest request) throws Exception {
		RolResponse rolResponse = new RolResponse();
		rolResponse = actualizarRol(codUsuario, idInstancia, request);

		AsignarPaginaRolRequest requestRol = new AsignarPaginaRolRequest();
		requestRol.setIdRol(request.getIdRol());
		eliminarPaginaPorRol(codUsuario, idInstancia, requestRol);

		if (rolResponse.getIdRol() != 0) {
			List<AsignarPaginaRolRequest> listaRol = new ArrayList<AsignarPaginaRolRequest>();
			listaRol = request.getListPaginaRol();
			AsignarPaginaRolRequest requesAsg = new AsignarPaginaRolRequest();
			requesAsg.setIdRol(request.getIdRol());

			for (int i = 0; i < listaRol.size(); i++) {
				requesAsg.setIdPagina(listaRol.get(i).getIdPagina());
				asignarPaginaPorRol(codUsuario, idInstancia, requesAsg);
			}
		}
		return rolResponse;
	}

	@Override
	public RolResponse eliminarPaginaPorRol(String codUsuario, String idInstancia, AsignarPaginaRolRequest request) throws Exception {
		RolResponse response = new RolResponse();
		response = rolDAO.eliminarPaginaPorRol(request);
		return response;
	}

	public ListaPaginasResponse listaPaginasPorRolServices(ListaPaginasRequest request) throws Exception {
		ListaPaginasResponse response = new ListaPaginasResponse();
		response = rolDAO.listaPaginasPorRol(request);
		return response;
	}

	@Override
	public RolResponse eliminarRol(AsignarPaginaRolRequest request) throws Exception {
		RolResponse response = new RolResponse();
		response = rolDAO.eliminarRol(request);
		return response;
	}

	@Override
	public EliminaRolResponse eliminarRol(String idInstancia, EliminaRolRequest request) throws Exception {
		EliminaRolResponse response = new EliminaRolResponse();
		List<Confirmacion> confirmacionList = rolDAO.eliminarRol(Integer.parseInt(EncriptaUtils.desencriptar(idInstancia)), request.getIdRol());
		Confirmacion confirmacion = confirmacionList.get(0);

		if (confirmacion.getID() == Constantes.ESTADO_TRAMA_OK) {
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("OK");
		} else {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			response.setMensaje("Imcumplimiento de reglas de negocio");
		}

		response.setConfirmacionList(confirmacionList);
		return response;
	}
}