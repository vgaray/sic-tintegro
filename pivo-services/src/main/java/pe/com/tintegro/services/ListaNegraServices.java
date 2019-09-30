package pe.com.tintegro.services;

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

public interface ListaNegraServices
{
	public InsertarListaNegraResponse insertarListaServices(String codUsuario, String idInstancia, InsertarListaNegraRequest request) throws Exception;

	public ListarListaNegraResponse listarListaNegraServices(String codUsuario, String idInstancia, ListarListaNegraRequest request) throws Exception;

	public ActualizarListaNegraResponse actualizarListaServices(String codUsuario, String idInstancia, ActualizarListaNegraRequest request) throws Exception;

	public EliminarListaNegraResponse eliminarListaNegraServices(String codUsuario, String idInstancia, EliminarListaNegraRequest request) throws Exception;

	public CambiaEstadoListaNegraResponse cambiaEstadoListaNegra(String codUsuario, String idInstancia, CambiaEstadoListaNegraRequest request) throws Exception;
	
	public BuscarListaNegraResponse buscarListaNegraServices (String codUsuario, String idInstancia, BuscarListaNegraRequest request) throws Exception;
}
