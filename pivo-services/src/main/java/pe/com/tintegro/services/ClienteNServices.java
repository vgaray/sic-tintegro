package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;

public interface ClienteNServices {

	public RegistrarClienteNResponse registrarClienteN(RegistrarClienteNRequest request)throws Exception;
	public ActualizarClienteNResponse actualizarClienteN(ActualizarClienteNRequest request)throws Exception;
	public ListarClienteNResponse listarClienteN (ListarClienteNRequest request)throws Exception;
	public EliminarClienteNResponse eliminarClienteN(EliminarClienteNRequest request) throws Exception;
	
}
