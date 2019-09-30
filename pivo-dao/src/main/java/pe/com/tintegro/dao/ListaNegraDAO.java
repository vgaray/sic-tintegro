package pe.com.tintegro.dao;

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

public interface ListaNegraDAO
{
	public InsertarListaNegraResponse insertarLista(String ip, InsertarListaNegraRequest request) throws Exception;
	
	public ActualizarListaNegraResponse actualizarLista(String ip, ActualizarListaNegraRequest request) throws Exception;
	
	public EliminarListaNegraResponse eliminarListaNegra(String ip, EliminarListaNegraRequest request)throws Exception;
	
	public ListarListaNegraResponse listarListaNegra(String ip, ListarListaNegraRequest request)throws Exception;
	
	public CambiaEstadoListaNegraResponse cambiaEstadoListaNegra(String ip,CambiaEstadoListaNegraRequest request)throws Exception;
	
	public BuscarListaNegraResponse buscarListaNegra (String ip, BuscarListaNegraRequest request) throws Exception;
}
