package pe.com.tintegro.services;


import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ClienteActualizarReponse;
import pe.com.tintegro.dto.response.ClienteEliminarResponse;
import pe.com.tintegro.dto.response.InsertarClienteResponse;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;
import pe.com.tintegro.dto.response.ListaClienteResponse;

public interface ClienteServices {

	
	//public ArrayList<Cliente> listarInstancia()throws Exception;
	
	public ListaClienteResponse listarcliente(String codUsuario)throws Exception;
	
	public ClienteActualizarReponse actualizarCliente(String codUsuario,ClienteActualizarRequest obj )throws Exception;
	
	public ClienteEliminarResponse eliminarCliente(String codUsuario,ClienteEliminarRequest obj )throws Exception;
	
	public InsertarClienteResponse insertarCliente(String codUsuario, InsertarClienteRequest cliente ) throws Exception;
	
	public ListaClienteAutoCompletarResponse listaClienteAutoCompletar(String codUsuario, ListaClienteAutoCompletarRequest request) throws Exception;
}
