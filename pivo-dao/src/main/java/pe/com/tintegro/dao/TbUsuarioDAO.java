package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarUsuarioRequest;
import pe.com.tintegro.dto.request.BuscarTbUsuarioRequest;
import pe.com.tintegro.dto.request.EliminarUsuarioRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioPaginadoRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioxNombreRequest;
import pe.com.tintegro.dto.request.ListarUsuarioxIdRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioResponse;
import pe.com.tintegro.dto.response.BuscarTbUsuarioResponse;
import pe.com.tintegro.dto.response.EliminarUsuarioResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioPaginadoResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.dto.response.ListarTbUsuarioxNombreResponse;
import pe.com.tintegro.dto.response.ListarUsuarioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioxIdResponse;

public interface TbUsuarioDAO
{

	public ListaTbUsuarioResponse listarTbUsuario(String ip) throws Exception;

	public ListarUsuarioxIdResponse ListarUsuarioxId(String ip, ListarUsuarioxIdRequest request) throws Exception;

	public FlagUsuarioResponse modificarFlagTbUsuario(String ip, FlagTbUsuarioRequest request) throws Exception;

	public ListarTbUsuarioxNombreResponse listarTbUsuarioxNombre(String ip, ListaTbUsuarioxNombreRequest request) throws Exception;

	public InsertarUsuarioResponse insertarUsuario(String ip, InsertarUsuarioRequest request) throws Exception;

	public ActualizarUsuarioResponse ActualizarUsuario(String ip, ActualizarUsuarioRequest request) throws Exception;

	public EliminarUsuarioResponse EliminarUsuario(String ip, EliminarUsuarioRequest request) throws Exception;

	public ListaLlamadaUsuarioResponse ListaLlamadaUsuario(String ip, ListaLlamadaUsuarioRequest request) throws Exception;

	public ListaLlamadaUsuarioResponse ListaReporteLlamadaUsuario(String ip, ListaLlamadaUsuarioRequest request) throws Exception;

	public ListaTbUsuarioPaginadoResponse listaTbUsuarioPaginado(String ip, ListaTbUsuarioPaginadoRequest request) throws Exception;
	
	public BuscarTbUsuarioResponse buscarTbUsuario (String ip, BuscarTbUsuarioRequest request) throws Exception;
	
	//Servicio para listar Usuario al descargar plantilla excel
	public ListarUsuarioResponse listaUsuario (String ip) throws Exception;
}
