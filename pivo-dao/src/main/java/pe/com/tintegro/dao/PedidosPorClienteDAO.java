/**
 * 
 */
package pe.com.tintegro.dao;

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

/**
 * @author FReyes
 *
 */
public interface PedidosPorClienteDAO {

	public ListarPedidoPorClienteResponse listarPedidoPorCliente(ListarPedidoPorClienteRequest request) throws Exception;
	
	public InsertarPedidoPorClienteResponse insertarPedidoPorCliente(InsertarPedidoPorClienteRequest request) throws Exception;

	public EliminarPedidoPorClienteResponse eliminarPedidoPorCliente(EliminarPedidoPorClienteRequest request) throws Exception;

	public ListarTipoPedidoResponse listarTipoPedido(ListarTipoPedidoRequest request) throws Exception;
	
	public ListarTipoDetallePedidoResponse listarTipoDetallePedido(ListarTipoDetallePedidoRequest request) throws Exception;

	public ListarPlanResponse listarPlan(ListarPlanRequest request) throws Exception;
}
