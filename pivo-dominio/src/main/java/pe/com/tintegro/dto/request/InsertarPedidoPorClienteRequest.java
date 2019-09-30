package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.*;

public class InsertarPedidoPorClienteRequest extends RequestBase
{
	private Cliente cliente;
	private Pedido pedido;
	private String coPedido;
	private Integer idTipoPedido;
	private Integer idPlan;
	private String dePedido;
	private Integer idCliente;
	private Integer idTipoDetalle;
	private String direccionPedido;
	public Integer getIdTipoDetalle() {
		return idTipoDetalle;
	}

	public void setIdTipoDetalle(Integer idTipoDetalle) {
		this.idTipoDetalle = idTipoDetalle;
	}

	public String getCoPedido() {
		return coPedido;
	}

	public void setCoPedido(String coPedido) {
		this.coPedido = coPedido;
	}

	public Integer getIdTipoPedido() {
		return idTipoPedido;
	}

	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getDePedido() {
		return dePedido;
	}

	public void setDePedido(String dePedido) {
		this.dePedido = dePedido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente getCliente()
	{
		return cliente;
	}

	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public Pedido getPedido()
	{
		return pedido;
	}

	public void setPedido(Pedido pedido)
	{
		this.pedido = pedido;
	}
	

	public String getDireccionPedido()
	{
		return direccionPedido;
	}
	
	public void setDireccionPedido(String direccionPedido)
	{
		this.direccionPedido = direccionPedido;
	}
}
