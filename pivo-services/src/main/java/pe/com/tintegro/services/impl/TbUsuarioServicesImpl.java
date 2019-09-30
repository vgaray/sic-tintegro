package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.TbUsuarioDAO;
import pe.com.tintegro.dto.request.ActualizarUsuarioRequest;
import pe.com.tintegro.dto.request.BuscarTbUsuarioRequest;
import pe.com.tintegro.dto.request.EliminarUsuarioRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioPaginadoRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioxNombreRequest;
import pe.com.tintegro.dto.request.ListarUsuarioxIdRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioResponse;
import pe.com.tintegro.dto.response.BuscarTbUsuarioResponse;
import pe.com.tintegro.dto.response.EliminarUsuarioResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioPaginadoResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.dto.response.ListarTbUsuarioxNombreResponse;
import pe.com.tintegro.dto.response.ListarUsuarioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioxIdResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.TbUsuarioServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@Service("tbUsuarioServices")
@Transactional
public class TbUsuarioServicesImpl implements TbUsuarioServices {

	@Resource(name = "tbUsuarioDAO")
	protected TbUsuarioDAO tbUsuarioDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaTbUsuarioResponse ListarTbUsuario(String codUsuario, String idInstancia) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.listarTbUsuario(ip);
	}

	@Override
	public ListarTbUsuarioxNombreResponse ListarTbUsuarioxNombre(String codUsuario, String idInstancia, ListaTbUsuarioxNombreRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.listarTbUsuarioxNombre(ip, request);
	}

	@Override
	public InsertarUsuarioResponse insertarUsuario(String codUsuario, String idInstancia, InsertarUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
//		request.setNuPin(EncriptaUtils.encriptar(request.getNuPin()));
		return tbUsuarioDAO.insertarUsuario(ip, request);
	}

	@Override
	public ActualizarUsuarioResponse ActualizarUsuario(String codUsuario, String idInstancia, ActualizarUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
//		request.setNuPin(EncriptaUtils.encriptar(request.getNuPin()));
		return tbUsuarioDAO.ActualizarUsuario(ip, request);
	}

	@Override
	public FlagUsuarioResponse modificarFlagTbUsuario(String codUsuario, String idInstancia, FlagTbUsuarioRequest request) throws Exception {
		FlagUsuarioResponse response = null;
		String ip = instanciaServices.determinarIp(idInstancia);
		response = tbUsuarioDAO.modificarFlagTbUsuario(ip, request);
		return response;
	}

	@Override
	public ListarUsuarioxIdResponse ListarUsuarioxId(String codUsuario, String idInstancia, ListarUsuarioxIdRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		ListarUsuarioxIdResponse response = tbUsuarioDAO.ListarUsuarioxId(ip, request);
//		for (int i = 0; i < response.getTbUsuarioListaxId().size(); i++) {
//			response.getTbUsuarioListaxId().get(i).setNuPin(EncriptaUtils.desencriptar(response.getTbUsuarioListaxId().get(i).getNuPin()));
//		}
		return response;
	}

	@Override
	public EliminarUsuarioResponse EliminarUsuario(String codUsuario, String idInstancia, EliminarUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.EliminarUsuario(ip, request);
	}

	@Override
	public ListaTbUsuarioPaginadoResponse listaTbUsuarioPaginado(String codUsuario, String idInstancia, ListaTbUsuarioPaginadoRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.listaTbUsuarioPaginado(ip, request);
	}

	@Override
	public BuscarTbUsuarioResponse buscarTbUsuario(String codUsuario, String idInstancia, BuscarTbUsuarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.buscarTbUsuario(ip, request);
	}

	@Override
	public ListarUsuarioResponse listaUsuario(String codUsuario, String idInstancia) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbUsuarioDAO.listaUsuario(ip);
	}
}