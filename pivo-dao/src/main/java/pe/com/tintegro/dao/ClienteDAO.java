package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ClienteActualizarReponse;
import pe.com.tintegro.dto.response.ClienteEliminarResponse;
import pe.com.tintegro.dto.response.InsertarClienteResponse;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;
import pe.com.tintegro.dto.response.ListaClienteResponse;

public interface ClienteDAO
{

	public ListaClienteResponse listarCliente() throws Exception;

	public InsertarClienteResponse insertarCliente(InsertarClienteRequest cliente) throws Exception;

	public ClienteEliminarResponse eliminarCliente(ClienteEliminarRequest cliente) throws Exception;

	public ClienteActualizarReponse actualizarCliente(ClienteActualizarRequest cliente) throws Exception;

	public ListaClienteAutoCompletarResponse listarClienteAutoCompletar(ListaClienteAutoCompletarRequest request) throws Exception;

}
