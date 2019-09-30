package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PedidoPorCliente implements Serializable
{


	private static final long serialVersionUID = 2279508744807196169L;
	private Integer idCliente;


	private String noRazonSocial;
	// pedido
	private Integer idPedido;
	private String fePedido;
	// estado pedido
	private String noEstadoPedido;


	
	public String getNoRazonSocial()
	{
		return noRazonSocial;

	}

	public Integer getIdPedido()
	{
		return idPedido;
	}

	public void setIdCliente(Integer idCliente)
	{
		this.idCliente = idCliente;
	}

	public void setNoRazonSocial(String noRazonSocial)
	{
		this.noRazonSocial = noRazonSocial;
	}

	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}


	public String getFePedido()
	{
		return fePedido;
	}

	public void setFePedido(String fePedido)
	{
		this.fePedido = fePedido;
	}

	public String getNoEstadoPedido()
	{
		return noEstadoPedido;
	}

	public void setNoEstadoPedido(String noEstadoPedido)
	{
		this.noEstadoPedido = noEstadoPedido;
	}


	public Integer getIdCliente()
	{
		return idCliente;
	}

	

}
