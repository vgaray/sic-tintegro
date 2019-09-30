package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.dao.UsuarioDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.Usuario;
import pe.com.tintegro.dto.request.ActualizarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.EliminaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ActualizarPasswordRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioPorCodigoRequest;
import pe.com.tintegro.dto.request.ValidarLoginUsuarioRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.EliminaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ActualizarPasswordResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioPorCodigoResponse;
import pe.com.tintegro.dto.response.ValidarLoginUsuarioResponse;
import pe.com.tintegro.mapper.UsuarioMapper;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends DAOTintegroImpl implements UsuarioDAO {
	@Override
	public ValidarLoginUsuarioResponse validarUsuario(
			ValidarLoginUsuarioRequest request) throws Exception {
		ValidarLoginUsuarioResponse response = new ValidarLoginUsuarioResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> validaUsuarioList = new ArrayList<Usuario>();
		validaUsuarioList = (List<Usuario>) mapper.validarUsuarioLogin(request
				.getNologin());
		response.setEstado(validaUsuarioList.get(0).getResult());
		response.setMensaje(validaUsuarioList.get(0).getMensaje());
		return response;
	}

	@Override
	public InsertarUsuarioEstandarResponse insertarUsuarioEstandar(
			InsertarUsuarioEstandarRequest request) throws Exception {
		InsertarUsuarioEstandarResponse response = new InsertarUsuarioEstandarResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> usuarioInsertar = new ArrayList<Usuario>();
		usuarioInsertar = (List<Usuario>) mapper.insertarUsuarioEstandar(
				request.getNoLogin(), request.getNoPasswo(),
				request.getNoNombre(), request.getNoApelli(),
				request.getEmail(), request.getNoProfe(), request.getIdRol(),
				request.getNoLoginCreador(), request.getIdInstanciadesc());
		response.setEstado(usuarioInsertar.get(0).getResult());
		response.setMensaje(usuarioInsertar.get(0).getMensaje());
		return response;
	}

	@Override
	public ListaUsuarioEstandarResponse listaUsuarioEstandar(
			ListaUsuarioEstandarRequest request) throws Exception {
		ListaUsuarioEstandarResponse response = new ListaUsuarioEstandarResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		usuarioList = (List<Usuario>) mapper.listarUsuarioEstandar(
				request.getNologin(), request.getIdInstanciadesenc(),
				request.getIdUsuario(), request.getTiOpera());
		response.setEstado(Constantes.ESTADO_TRAMA_OK);
		response.setMensaje("Usuario Listado Correctamente");
		response.setUsuarioList(usuarioList);
		return response;
	}

	@Override
	public EliminaUsuarioEstandarResponse eliminarUsuarioEstandar(
			EliminaUsuarioEstandarRequest request) throws Exception {
		EliminaUsuarioEstandarResponse response = new EliminaUsuarioEstandarResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = (List<Usuario>) mapper.eliminarUsuarioEstandar(
				request.getIdUsuario(), request.getNoLoginCreador(),
				request.getIdInstanciadesc());
		response.setEstado(usuarios.get(0).getResult());
		response.setMensaje(usuarios.get(0).getMensaje());
		return response;
	}

	@Override
	public ActualizarUsuarioEstandarResponse actualizarUsuarioEstandar(
			ActualizarUsuarioEstandarRequest request) throws Exception {
		ActualizarUsuarioEstandarResponse response = new ActualizarUsuarioEstandarResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> usuariosActualizar = new ArrayList<Usuario>();
		usuariosActualizar = (List<Usuario>) mapper.actualizarUsuarioEstandar(
				request.getIdUsuario(), request.getNoPasswo(),
				request.getNoNombre(), request.getNoApellido(),
				request.getEmail(), request.getNoProfe(), request.getIdRol(),
				request.getNoLoginCreador(), request.getIdInstanciadesenc());
		response.setEstado(usuariosActualizar.get(0).getResult());
		response.setMensaje(usuariosActualizar.get(0).getMensaje());
		return response;
	}

	@Override
	public ActualizarPasswordResponse actualizarPassword(ActualizarPasswordRequest request)throws Exception {
		ActualizarPasswordResponse response= new ActualizarPasswordResponse();
		UsuarioMapper mapper=this.getSqlSessionSic().getMapper(UsuarioMapper.class);
		List<Usuario>passInsertar=new ArrayList<Usuario>();
		passInsertar=(List<Usuario>)mapper.actualizarPassword(request.getpNewPassword(),
														   request.getpCodUsuario(),
														   request.ispConfirmacion(),
														   request.getpToken());
		response.setEstado(passInsertar.get(0).getResult());
		response.setMensaje(passInsertar.get(0).getMensaje());
		return response;
	}

	@Override
	public ListaUsuarioPorCodigoResponse listarUsuarioPorCodigo(
			ListaUsuarioPorCodigoRequest request) {
		ListaUsuarioPorCodigoResponse response = new ListaUsuarioPorCodigoResponse();
		UsuarioMapper mapper = this.getSqlSessionSic().getMapper(
				UsuarioMapper.class);
		List<Usuario> usuarioList = new ArrayList<Usuario>();
		usuarioList = (List<Usuario>) mapper.listarUsuarioPorCodigo(request
				.getpCodUsuario(),request.getpIdUsuario());
		response.setEstado(Constantes.ESTADO_TRAMA_OK);
		response.setMensaje("Usuario Listado Correctamente");
		response.setUsuarioList(usuarioList);
		return response;
	}
}
