package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class DetallePedido implements Serializable
{
	private static final long serialVersionUID = -5755174619611539043L;
	
   private Integer idDetaPedido ;
   private String noDetaPedido ;
   private Integer idTipoPedido;
   private Integer idPedido ;
   private Integer idTipoDetalle ;
   private Integer idPlan ;
  // private Integer idInstancia;
   private InstanciaServerAsterisk instancia;
   
	public Integer getIdDetaPedido()
	{
		return idDetaPedido;
	}
	public void setIdDetaPedido(Integer idDetaPedido)
	{
		this.idDetaPedido = idDetaPedido;
	}
	public String getNoDetaPedido()
	{
		return noDetaPedido;
	}
	public void setNoDetaPedido(String noDetaPedido)
	{
		this.noDetaPedido = noDetaPedido;
	}
	public Integer getIdTipoPedido()
	{
		return idTipoPedido;
	}
	public void setIdTipoPedido(Integer idTipoPedido)
	{
		this.idTipoPedido = idTipoPedido;
	}
	public Integer getIdPedido()
	{
		return idPedido;
	}
	public void setIdPedido(Integer idPedido)
	{
		this.idPedido = idPedido;
	}
	public Integer getIdTipoDetalle()
	{
		return idTipoDetalle;
	}
	public void setIdTipoDetalle(Integer idTipoDetalle)
	{
		this.idTipoDetalle = idTipoDetalle;
	}
	public Integer getIdPlan()
	{
		return idPlan;
	}
	public void setIdPlan(Integer idPlan)
	{
		this.idPlan = idPlan;
	}
	public InstanciaServerAsterisk getInstancia()
	{
		return instancia;
	}
	public void setInstancia(InstanciaServerAsterisk instancia)
	{
		this.instancia = instancia;
	}
	

    
}
