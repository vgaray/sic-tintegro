/**
 * 
 */
package pe.com.tintegro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PedidosPorClienteDAO;
import pe.com.tintegro.dto.request.EliminarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPlanRequest;
import pe.com.tintegro.dto.request.ListarTipoDetallePedidoRequest;
import pe.com.tintegro.dto.request.ListarTipoPedidoRequest;
import pe.com.tintegro.dto.response.EliminarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPlanResponse;
import pe.com.tintegro.dto.response.ListarTipoDetallePedidoResponse;
import pe.com.tintegro.dto.response.ListarTipoPedidoResponse;
import pe.com.tintegro.services.PedidosPorClienteService;

/**
 * @author FReyes
 *
 */
@Service("pedidosPorClienteService")
@Transactional
public class PedidosPorClienteServiceImpl implements PedidosPorClienteService {

	@Autowired
	protected PedidosPorClienteDAO pedidosPorClienteDAO;

	@Override
	public ListarPedidoPorClienteResponse listarPedidoPorCliente(ListarPedidoPorClienteRequest obj) throws Exception {
		ListarPedidoPorClienteResponse response = new ListarPedidoPorClienteResponse();
		response = pedidosPorClienteDAO.listarPedidoPorCliente(obj);
		return response;
	}

	@Override
	public InsertarPedidoPorClienteResponse insertarPedidoPorCliente(InsertarPedidoPorClienteRequest obj) throws Exception {
		InsertarPedidoPorClienteResponse response = new InsertarPedidoPorClienteResponse();
		response = pedidosPorClienteDAO.insertarPedidoPorCliente(obj);
		return response;
	}

	@Override
	public EliminarPedidoPorClienteResponse eliminarPedidoPorCliente(EliminarPedidoPorClienteRequest obj) throws Exception {
		EliminarPedidoPorClienteResponse response = new EliminarPedidoPorClienteResponse();
		response = pedidosPorClienteDAO.eliminarPedidoPorCliente(obj);
		return response;
	}

	@Override
	public ListarTipoPedidoResponse listarTipoPedido(ListarTipoPedidoRequest obj) throws Exception {
		ListarTipoPedidoResponse response = new ListarTipoPedidoResponse();
		response = pedidosPorClienteDAO.listarTipoPedido(obj);
		return response;
	}

	@Override
	public ListarTipoDetallePedidoResponse listarTipoDetallePedido(ListarTipoDetallePedidoRequest obj) throws Exception {
		ListarTipoDetallePedidoResponse response = new ListarTipoDetallePedidoResponse();
		response = pedidosPorClienteDAO.listarTipoDetallePedido(obj);
		return response;
	}

	@Override
	public ListarPlanResponse listarPlan(ListarPlanRequest obj) throws Exception {
		ListarPlanResponse response = new ListarPlanResponse();
		response = pedidosPorClienteDAO.listarPlan(obj);
		return response;
	}
}
