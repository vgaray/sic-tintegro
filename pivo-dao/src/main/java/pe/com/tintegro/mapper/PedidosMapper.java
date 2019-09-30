package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Pedido;
import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dominio.Plan;
import pe.com.tintegro.dominio.TipoDetallePedido;
import pe.com.tintegro.dominio.TipoPedido;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface PedidosMapper
{
	public List<PedidoPorCliente> listPedidoxClientess(@Param("idTipdoc") Integer idTdfipdoc, 
			@Param("idCliente") Integer idClientsdfe,
			@Param("idPedido") Integer idPedsdfido,
			@Param("idEstadoPedido") Integer idEstadoPesdfdido);
	
	public List<Pedido> listPedidoPorCliente(@Param("p_id_cliente") Integer idCliente);
	
	public List<CRUDResponse> insertarPedidoPorCliente(
			@Param("v_id_cliente") Integer idCliente,
			@Param("v_co_pedido") String coCliente,
			@Param("v_direccion_pedido") String direccionPedido,
			@Param("v_id_tipopedido") Integer idTipoPedido,
			@Param("v_id_plan") Integer idPlan,
			@Param("v_no_descripcion") String descripcion,	
			@Param("v_id_tipodetalle") Integer idtipoDetalle
			);
	
	public List<CRUDResponse> eliminarPedidoPorCliente(@Param("p_id_pedido") Integer idPedido);
	
	public List<TipoPedido> listTipoPedido();
	
	public List<TipoDetallePedido> listTipoDetallePedido();
	
	public List<Plan> listPlan();
}
