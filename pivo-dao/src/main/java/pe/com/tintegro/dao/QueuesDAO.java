package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarQueuesRequest;
import pe.com.tintegro.dto.request.BuscarQueuesRequest;
import pe.com.tintegro.dto.request.EliminarQueuesRequest;
import pe.com.tintegro.dto.request.InsertarQueuesRequest;
import pe.com.tintegro.dto.request.ListarAgenteDisponiblesRequest;
import pe.com.tintegro.dto.request.ListarQueuesRequest;
import pe.com.tintegro.dto.response.ActualizarQueuesResponse;
import pe.com.tintegro.dto.response.BuscarQueuesResponse;
import pe.com.tintegro.dto.response.EliminarQueuesResponse;
import pe.com.tintegro.dto.response.InsertarQueuesResponse;
import pe.com.tintegro.dto.response.ListarAgenteDisponiblesResponse;
import pe.com.tintegro.dto.response.ListarQueuesResponse;

public interface QueuesDAO
{
	public ListarQueuesResponse listarQueues(String ip,ListarQueuesRequest request)throws Exception;
	
	public InsertarQueuesResponse insertarQueues(String ip,InsertarQueuesRequest request) throws Exception;
	
	public ActualizarQueuesResponse actualizarQueues(String ip,ActualizarQueuesRequest request) throws Exception;
	
	public EliminarQueuesResponse eliminarQueues(String ip, EliminarQueuesRequest request) throws Exception;
	
	public BuscarQueuesResponse buscarQueues(String ip, BuscarQueuesRequest request) throws Exception;
	
	public ListarAgenteDisponiblesResponse listarAgenteDisponible(String ip,ListarAgenteDisponiblesRequest request)throws Exception;
}
