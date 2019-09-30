package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.*;

public class InsertarPedidoPorClienteResponse extends ResponseBase
{
	private List<PedidoPorCliente> pedidos;
	private Integer cantidadPedidos;
	private Integer insertado;

	public Integer getInsertado() {
		return insertado;
	}

	public void setInsertado(Integer insertado) {
		this.insertado = insertado;
	}

	public List<PedidoPorCliente> getPedidos()
	{
		return pedidos;
	}

	public void setPedidos(List<PedidoPorCliente> pedidos)
	{
		this.pedidos = pedidos;
	}

	public Integer getCantidadPedidos()
	{
		return cantidadPedidos;
	}

	public void setCantidadPedidos(Integer cantidadPedidos)
	{
		this.cantidadPedidos = cantidadPedidos;
	}

}
