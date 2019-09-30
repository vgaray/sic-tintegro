package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.Queues;
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

public interface QueuesServices
{
	public ListarQueuesResponse listarQueues(String codUsuario,String idInstancia,ListarQueuesRequest request) throws Exception;
	
	public InsertarQueuesResponse insertarQueues(String codUsuario,String idInstancia,InsertarQueuesRequest request) throws Exception;
	
	public ActualizarQueuesResponse actualizarQueues(String codUsuario,String idInstancia,ActualizarQueuesRequest request)throws Exception;
	
	public EliminarQueuesResponse eliminarQueues(String codUsuario,String idInstancia,EliminarQueuesRequest request) throws Exception;
	
	public BuscarQueuesResponse buscarQueues(String codUsuario,String idInstancia, BuscarQueuesRequest request) throws Exception;
	
	public ListarAgenteDisponiblesResponse listarAgenteDisponible(String codUsuario,String idInstancia,ListarAgenteDisponiblesRequest request)throws Exception;

  public String mantenimientoColasEnAsterisk(String codUsuario,String idInstancia,Integer tipoOperacion,Queues queue) throws Exception;
  
	public String generarTxtQueue(String codUsuario,String idInstancia)throws Exception;
	
	public String writeQueue(String codUsuario,String idInstancia,List<Queues> listado)throws Exception;  
	  
}
