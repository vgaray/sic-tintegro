package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PedidoPorClienteDAO;
import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PedidoPorClienteService;

@Service("pedidoxClienteService")
@Transactional
public class PedidoPorClienteServiceImpl implements PedidoPorClienteService {

	@Resource(name = "pedidoPorClienteDAO")
	PedidoPorClienteDAO pedidoPorClienteDao;
	
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaPedidoPorClienteResponse listaPedidoxCliente(String CodUsuario, ListaPedidoPorClienteRequest obj) throws Exception {
		ListaPedidoPorClienteResponse response = new ListaPedidoPorClienteResponse();
		response = pedidoPorClienteDao.listaPedidoxCliente(obj);
		return response;
	}

}
