/**
 * 
 */
package pe.com.tintegro.services;

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
	
public interface PedidosPorClienteService 
{
	public ListarPedidoPorClienteResponse listarPedidoPorCliente(ListarPedidoPorClienteRequest obj) throws Exception;
	public InsertarPedidoPorClienteResponse insertarPedidoPorCliente(InsertarPedidoPorClienteRequest obj) throws Exception;
	public EliminarPedidoPorClienteResponse eliminarPedidoPorCliente(EliminarPedidoPorClienteRequest obj) throws Exception;
	public ListarTipoPedidoResponse listarTipoPedido(ListarTipoPedidoRequest obj) throws Exception;
	public ListarTipoDetallePedidoResponse listarTipoDetallePedido(ListarTipoDetallePedidoRequest obj) throws Exception;
	public ListarPlanResponse listarPlan(ListarPlanRequest obj) throws Exception;
}
