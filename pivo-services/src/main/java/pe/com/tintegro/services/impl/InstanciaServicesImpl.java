package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.InstanciaDAO;
import pe.com.tintegro.dao.UsuarioDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dominio.Usuario;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioPorCodigoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.CargaEstadoConfigInstanciaResponse;
import pe.com.tintegro.dto.response.EvaluarInstanciaResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioPorCodigoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxCasoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@Service("instanciaServices")
@Transactional
public class InstanciaServicesImpl implements InstanciaServices {
	@Resource(name = "instanciaDAO")
	InstanciaDAO instanciaDao;
	@Resource(name = "usuarioDAO")
	protected UsuarioDAO usuarioDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;
	@Override
	public InsertarInstanciaResponse insertarInstancia(String codUsuario,
			InsertarInstanciaRequest obj) throws Exception {
		InsertarInstanciaResponse rpta = new InsertarInstanciaResponse();
		rpta = instanciaDao.insertarInstancia(obj);
		return rpta;
	}

	public String determinarIp(String idInstancia) throws Exception {
		ListaInstanciaRequest request = new ListaInstanciaRequest();
		request.setpIdInstanciaxDesc(desincriptarIdInstancia(idInstancia));
		ListaInstanciaResponse response = listaInstancia(null, request);
		String ip = response.getInstancias().get(0).getIpAsterisk();
		return ip;
		// return "127.0.0.1";
	}

	public InstanciaServerAsterisk buscarInstancia(String codUsuario,
			String idInstancia) throws Exception {
		ListaInstanciaRequest request = new ListaInstanciaRequest();
		request.setpIdInstanciaxDesc(desincriptarIdInstancia(idInstancia));
		ListaInstanciaResponse response = listaInstancia(null, request);
		return response.getInstancias().get(0);
	}

	@Override
	public ListaInstanciaxIdResponse listarIntanciaxIdInstancia(
			String codUsuario, ListaInstanciaxIdRequest request)
			throws Exception {
		ListaInstanciaxIdResponse response = new ListaInstanciaxIdResponse();
		if (request.getIdInstanciaDesc() != null) {
			Integer insta = request.getIdInstanciaDesc();
			request.setIdInstanciaDesc(insta);
		} else if (request.getIdInstancia() != null) {
			request.setIdInstanciaDesc(desincriptarIdInstancia(request
					.getIdInstancia()));
		}
		response = instanciaDao.listarInstanciaxId(request);
		return response;
	}

	@Override
	public ListarInstanciaxIdClienteResponse listarIntanciaxIdCliente(
			String codUsuario, ListarInstanciaxIdClienteRequest obj)
			throws Exception {
		ListarInstanciaxIdClienteResponse response = new ListarInstanciaxIdClienteResponse();
		response = instanciaDao.listarInstanciaxIdCliente(obj);
		return response;
	}

	@Override
	public ListarInstanciaxCasoResponse listarIntanciaxCaso(String codUsuario,
			ListarInstanciaxCasoRequest obj) throws Exception {
		ListarInstanciaxCasoResponse respuesta = new ListarInstanciaxCasoResponse();
		respuesta = instanciaDao.listarInstanciaxCaso(obj);
		return respuesta;
	}

	@Override
	public ListaInstanciaResponse listaInstancia(String codUsuario,
			ListaInstanciaRequest request) throws Exception {
		ListaInstanciaResponse response = new ListaInstanciaResponse();
		request.setpNoLogin(codUsuario);
		// request.setpIdInstanciaxDesc(desincriptarIdInstancia(request.getpIdInstanciaxDesc()));
		response = instanciaDao.listarInstancia(request);
		List<InstanciaServerAsterisk> instaciaList = new ArrayList<InstanciaServerAsterisk>();
		for (InstanciaServerAsterisk instancia : response.getInstancias()) {
			instancia.setIdInstanciaEncryp(encriptarIdInstancia(instancia
					.getIdInstancia()));
			instancia.setIdInstancia(null);
			instaciaList.add(instancia);
		}
		response.setInstancias(instaciaList);
		return response;
	}

	@Override
	public String encriptarIdInstancia(int idInstancia) {
		String idInstanciaEncryp = "";
		try {
			idInstanciaEncryp = EncriptaUtils.encriptar(String
					.valueOf(idInstancia));
		} catch (Exception ex) {

		}
		return idInstanciaEncryp;
	}

	@Override
	public int desincriptarIdInstancia(String idInstancia) {
		String idInstanciaEncryp = "";
		try {
			idInstanciaEncryp = EncriptaUtils.desencriptar(idInstancia);
			return Integer.valueOf(idInstanciaEncryp);
		} catch (Exception ex) {

		}
		return 0;
	}

	@Override
	public EvaluarInstanciaResponse evaluarInstancia(String codUsuario)
			throws Exception {
		EvaluarInstanciaResponse response = new EvaluarInstanciaResponse();
		ListaInstanciaRequest requestInstancia = new ListaInstanciaRequest();
		requestInstancia.setpNoLogin(codUsuario);
		ListaInstanciaResponse instanciaListResponse = listaInstancia(codUsuario, requestInstancia);
		response.setCantidad(instanciaListResponse.getInstancias().size());
		ListaUsuarioPorCodigoRequest requestUsuarioNew=new ListaUsuarioPorCodigoRequest();
		requestUsuarioNew.setpCodUsuario(codUsuario);
		ListaUsuarioPorCodigoResponse responseUsuNew = new ListaUsuarioPorCodigoResponse();
		responseUsuNew=usuarioDAO.listarUsuarioPorCodigo(requestUsuarioNew);
		/*ListaUsuarioEstandarResponse responseUsu=new ListaUsuarioEstandarResponse();
		responseUsu=usuarioDAO.listaUsuarioEstandar(requestUsuario);*/
		response.setTipoRol(responseUsuNew.getUsuarioList().get(0).getIdTipoRol());
		System.out.println("");
		if (instanciaListResponse.getInstancias().size() == 1) {
			response.setIdInstancia(instanciaListResponse.getInstancias()
					.get(0).getIdInstanciaEncryp());
		}
		return response;
	}
	@Override
	public Boolean createFolderByInstanceInFileServer(String codUser,
			String idInstance) {
		Boolean folderCreated = false;
		return folderCreated;
	}

	public ActualizarInstanciaResponse actualizarInstancia(String CodUsuario,
			ActualizarInstanciaRequest request) throws Exception {
		ActualizarInstanciaResponse response = new ActualizarInstanciaResponse();
		request.setIdInstanciaDesc(desincriptarIdInstancia(request
				.getIdInstancia()));
		response = instanciaDao.actualizarInstancia(request);
		return response;
	}

	@Override
	public CRUDResponse notifyExecuteBashConfigInitial(String codUsuario,
			int idBash, String idInstance, Integer typeNotification)
			throws Exception {
		CRUDResponse response = null;
		int idInstanceNumeric = desincriptarIdInstancia(idInstance);
		response = instanciaDao.notifyExecuteBashConfigInitial(codUsuario,
				idBash, idInstanceNumeric, typeNotification);
		return response;
	}

	@Override
	public CargaEstadoConfigInstanciaResponse loadStatusConfigInitialInstance(
			String codUser, String idInstance) throws Exception {
		CargaEstadoConfigInstanciaResponse response = new CargaEstadoConfigInstanciaResponse();
		int idInstanceInt = desincriptarIdInstancia(idInstance);
		List<StatusBash> lsStatusBash = instanciaDao
				.loadStatusConfigInitialInstance(codUser, idInstanceInt);
		response.setLsStatusBash(lsStatusBash);
		return response;
	}

	@Override
	public CRUDResponse updateInstanceStatus(Integer idEstadoInstancia,
			String codUser, String idInstance) throws Exception {
		CRUDResponse response = null;
		int idInstanceInt = desincriptarIdInstancia(idInstance);
		response = instanciaDao.updateInstanceStatus(idEstadoInstancia,
				codUser, idInstanceInt);
		return response;
	}

	@Override
	public ListaInstanciasPorEmpresaResponse listaInstanciasPorEmpresa(
			String codUsuario, ListaInstanciasPorEmpresaRequest request)
			throws Exception {
		ListaInstanciasPorEmpresaResponse response = new ListaInstanciasPorEmpresaResponse();

		if (request.getIdInstanciaDesc() != null) {
			Integer insta = request.getIdInstanciaDesc();
			request.setIdInstanciaDesc(insta);
		} else if (request.getIdInstancia() != null) {
			request.setIdInstanciaDesc(desincriptarIdInstancia(request
					.getIdInstancia()));
		}

		response = instanciaDao.listaInstanciasPorEmpresa(request);

		List<InstanciaServerAsterisk> instaciaList = new ArrayList<InstanciaServerAsterisk>();
		for (InstanciaServerAsterisk instancia : response
				.getListaInstanciaEmpresa()) {
			instancia.setIdInstanciaEncryp(encriptarIdInstancia(instancia
					.getIdInstancia()));
			instancia.setIdInstancia(null);
			instaciaList.add(instancia);
		}
		response.setListaInstanciaEmpresa(instaciaList);
		return response;
	}

	@Override
	public InsertarInstanciaNResponse insertarInstanciaN(String codUsuario,
			InsertarInstanciaNRequest request) throws Exception {
		InsertarInstanciaNResponse response = new InsertarInstanciaNResponse();
		response = instanciaDao.insertarInstanciaN(request);
		return response;
	}

}