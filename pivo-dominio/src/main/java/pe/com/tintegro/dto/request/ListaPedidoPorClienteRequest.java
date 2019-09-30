package pe.com.tintegro.dto.request;
public class ListaPedidoPorClienteRequest extends RequestBase
{
	private Integer idTipdoc;
	private Integer idCliente;
	private Integer idPedido;
	private Integer idEstadoPedido;
	
	public Integer getIdCliente()
	{
		return idCliente;
	}
	public Integer getIdTipdoc()
	{
		return idTipdoc;
	}
	public Integer getIdPedido()
	{
		return idPedido;
	}
	public Integer getIdEstadoPedido()
	{
		return idEstadoPedido;
	}
	public void setIdCliente(Integer idCliente)
	{
		this.idCliente = idCliente;
	}
	public void setIdTipdoc(Integer idTipdoc)
	{
		this.idTipdoc = idTipdoc;
	}
	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}
	public void setIdEstadoPedido(Integer idEstadoPedido)
	{
		this.idEstadoPedido = idEstadoPedido;
	}
	
}
