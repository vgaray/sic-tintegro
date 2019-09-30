package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ClienteDAO;
import pe.com.tintegro.dto.request.ClienteActualizarRequest;
import pe.com.tintegro.dto.request.ClienteEliminarRequest;
import pe.com.tintegro.dto.request.InsertarClienteRequest;
import pe.com.tintegro.dto.request.ListaClienteAutoCompletarRequest;
import pe.com.tintegro.dto.response.ClienteActualizarReponse;
import pe.com.tintegro.dto.response.ClienteEliminarResponse;
import pe.com.tintegro.dto.response.InsertarClienteResponse;
import pe.com.tintegro.dto.response.ListaClienteAutoCompletarResponse;
import pe.com.tintegro.dto.response.ListaClienteResponse;
import pe.com.tintegro.services.ClienteServices;

@Service("clienteServices")
@Transactional
public class ClienteServicesImpl implements ClienteServices {

	@Resource(name = "clienteDAO")
	protected ClienteDAO clienteDAO;

	@Override
	public ListaClienteResponse listarcliente(String CodUsuario) throws Exception {
		ListaClienteResponse respuesta = new ListaClienteResponse();
		respuesta = clienteDAO.listarCliente();
		return respuesta;
	}

	@Override
	public InsertarClienteResponse insertarCliente(String codUsuario, InsertarClienteRequest cliente) throws Exception {
		InsertarClienteResponse response = new InsertarClienteResponse();
		response = clienteDAO.insertarCliente(cliente);
		return response;
	}

	@Override
	public ClienteActualizarReponse actualizarCliente(String codUsuario, ClienteActualizarRequest obj) throws Exception {
		ClienteActualizarReponse response = new ClienteActualizarReponse();
		response = clienteDAO.actualizarCliente(obj);
		return response;
	}

	@Override
	public ClienteEliminarResponse eliminarCliente(String codUsuario, ClienteEliminarRequest obj) throws Exception {
		ClienteEliminarResponse response = new ClienteEliminarResponse();
		response = clienteDAO.eliminarCliente(obj);
		return response;
	}

	@Override
	public ListaClienteAutoCompletarResponse listaClienteAutoCompletar(String codUsuario, ListaClienteAutoCompletarRequest request) throws Exception {
		ListaClienteAutoCompletarResponse response = new ListaClienteAutoCompletarResponse();
		response = clienteDAO.listarClienteAutoCompletar(request);
		return response;
	}
}