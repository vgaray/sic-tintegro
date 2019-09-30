package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;

public interface ClienteNDAO {

	public ActualizarClienteNResponse actualizarClienteN(ActualizarClienteNRequest request)throws Exception; 
	public EliminarClienteNResponse eliminarClienteN(EliminarClienteNRequest request)throws Exception; 
	public RegistrarClienteNResponse registrarClienteN(RegistrarClienteNRequest request)throws Exception;
	public ListarClienteNResponse listarClienteN(ListarClienteNRequest request )throws Exception;
	/////////////////////////////////////////////////////////////////////////
}
