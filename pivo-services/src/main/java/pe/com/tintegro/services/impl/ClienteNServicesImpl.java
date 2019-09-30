package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ClienteNDAO;
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.services.ClienteNServices;

@Service("ClienteNServices")
@Transactional
public class ClienteNServicesImpl implements ClienteNServices {
	
	@Resource(name = "clienteNDAO")
	protected ClienteNDAO clienteNDAO;

	@Override
	public RegistrarClienteNResponse registrarClienteN(RegistrarClienteNRequest request) throws Exception {
		RegistrarClienteNResponse response = new RegistrarClienteNResponse();
		response = clienteNDAO.registrarClienteN(request);
		return response;
	}

	@Override
	public ActualizarClienteNResponse actualizarClienteN(ActualizarClienteNRequest request) throws Exception {
		ActualizarClienteNResponse response = new ActualizarClienteNResponse();
		response = clienteNDAO.actualizarClienteN(request);
		return response;
	}

	@Override
	public ListarClienteNResponse listarClienteN(ListarClienteNRequest request) throws Exception {
		ListarClienteNResponse response = new ListarClienteNResponse();
		response = clienteNDAO.listarClienteN(request);
		return response;
	}

	@Override
	public EliminarClienteNResponse eliminarClienteN(EliminarClienteNRequest request) throws Exception {
		EliminarClienteNResponse response = new EliminarClienteNResponse();
		response = clienteNDAO.eliminarClienteN(request);
		return response;
	}
}