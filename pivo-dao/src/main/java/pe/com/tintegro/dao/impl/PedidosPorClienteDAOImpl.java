package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.PedidosPorClienteDAO;
import pe.com.tintegro.dominio.Pedido;
import pe.com.tintegro.dominio.Plan;
import pe.com.tintegro.dominio.TipoDetallePedido;
import pe.com.tintegro.dominio.TipoPedido;
import pe.com.tintegro.dto.request.EliminarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListarPlanRequest;
import pe.com.tintegro.dto.request.ListarTipoDetallePedidoRequest;
import pe.com.tintegro.dto.request.ListarTipoPedidoRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.EliminarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListarPlanResponse;
import pe.com.tintegro.dto.response.ListarTipoDetallePedidoResponse;
import pe.com.tintegro.dto.response.ListarTipoPedidoResponse;
import pe.com.tintegro.mapper.PedidosMapper;

/**
 * @author FReyes
 *
 */
@Repository("pedidosPorClienteDAO")
public class PedidosPorClienteDAOImpl extends DAOTintegroImpl implements PedidosPorClienteDAO {

	@Override
	public ListarPedidoPorClienteResponse listarPedidoPorCliente(ListarPedidoPorClienteRequest request) throws Exception {
		List<Pedido> result = new ArrayList<Pedido>();
		ListarPedidoPorClienteResponse response = new ListarPedidoPorClienteResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);
		// ClienteNMapper mapper =
		// this.getSqlSessionSic().getMapper(ClienteNMapper.class);
		result = (List<Pedido>) mapper.listPedidoPorCliente(request.getIdCliente());
		response.setPedidoPorClienteList(result);
		return response;
	}

	@Override
	public ListarTipoPedidoResponse listarTipoPedido(ListarTipoPedidoRequest request) throws Exception {
		List<TipoPedido> result = new ArrayList<TipoPedido>();
		ListarTipoPedidoResponse response = new ListarTipoPedidoResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);
		result = (List<TipoPedido>) mapper.listTipoPedido();
		response.setListTipoPedido(result);
		return response;
	}

	@Override
	public ListarTipoDetallePedidoResponse listarTipoDetallePedido(ListarTipoDetallePedidoRequest request) throws Exception {
		List<TipoDetallePedido> result = new ArrayList<TipoDetallePedido>();
		ListarTipoDetallePedidoResponse response = new ListarTipoDetallePedidoResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);
		result = (List<TipoDetallePedido>) mapper.listTipoDetallePedido();
		response.setListTipoDetallePedido(result);
		return response;
	}

	@Override
	public ListarPlanResponse listarPlan(ListarPlanRequest request) throws Exception {
		List<Plan> result = new ArrayList<Plan>();
		ListarPlanResponse response = new ListarPlanResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);
		result = (List<Plan>) mapper.listPlan();
		response.setListPlan(result);
		return response;
	}

	@Override
	public InsertarPedidoPorClienteResponse insertarPedidoPorCliente(InsertarPedidoPorClienteRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		InsertarPedidoPorClienteResponse response = new InsertarPedidoPorClienteResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);

		result = (List<CRUDResponse>) mapper.insertarPedidoPorCliente(request.getIdCliente(), request.getCoPedido(), request.getDireccionPedido(), request.getIdTipoPedido(), request.getIdPlan(), request.getDePedido(), request.getIdTipoDetalle());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public EliminarPedidoPorClienteResponse eliminarPedidoPorCliente(EliminarPedidoPorClienteRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		EliminarPedidoPorClienteResponse response = new EliminarPedidoPorClienteResponse();
		PedidosMapper mapper = this.getSqlSessionSic().getMapper(PedidosMapper.class);
		result = (List<CRUDResponse>) mapper.eliminarPedidoPorCliente(request.getIdPedido());

		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}
}