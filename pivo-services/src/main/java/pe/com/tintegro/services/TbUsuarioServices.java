package pe.com.tintegro.services;

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

public interface TbUsuarioServices
{
	public ListaTbUsuarioResponse ListarTbUsuario(String codUsuario, String idInstancia) throws Exception;

	public ListarTbUsuarioxNombreResponse ListarTbUsuarioxNombre(String codUsuario, String idInstancia, ListaTbUsuarioxNombreRequest request) throws Exception;

	public ListarUsuarioxIdResponse ListarUsuarioxId(String codUsuario, String idInstancia, ListarUsuarioxIdRequest request) throws Exception;

	public FlagUsuarioResponse modificarFlagTbUsuario(String codUsuario, String idInstancia, FlagTbUsuarioRequest request) throws Exception;

	public InsertarUsuarioResponse insertarUsuario(String codUsuario, String idInstancia, InsertarUsuarioRequest request) throws Exception;

	public ActualizarUsuarioResponse ActualizarUsuario(String codUsuario, String idInstancia, ActualizarUsuarioRequest request) throws Exception;

	public EliminarUsuarioResponse EliminarUsuario(String codUsuario, String idInstancia, EliminarUsuarioRequest request) throws Exception;

	public ListaTbUsuarioPaginadoResponse listaTbUsuarioPaginado(String codUsuario, String idInstancia, ListaTbUsuarioPaginadoRequest request) throws Exception;
	
	public BuscarTbUsuarioResponse buscarTbUsuario (String codUsuario, String idInstancia, BuscarTbUsuarioRequest request) throws Exception;
	
	public ListarUsuarioResponse listaUsuario(String codUsuario, String idInstancia) throws Exception;
}
