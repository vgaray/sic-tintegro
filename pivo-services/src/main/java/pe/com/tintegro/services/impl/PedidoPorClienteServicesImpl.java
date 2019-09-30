package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PedidoPorClienteDAO;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.services.PedidoPorClienteServices;

@Service("pedidoPorClienteServices")
@Transactional
public class PedidoPorClienteServicesImpl implements PedidoPorClienteServices {

	@Resource(name = "pedidoPorClienteDAO")
	protected PedidoPorClienteDAO pedidoPorClienteDAO;

	@Override
	public InsertarPedidoPorClienteResponse insertarPedidoxCliente(String codUsuario, InsertarPedidoPorClienteRequest request) throws Exception {
		InsertarPedidoPorClienteResponse response = new InsertarPedidoPorClienteResponse();
		response = pedidoPorClienteDAO.insertaPedidoPorCliente(request);
		return response;
	}
}
