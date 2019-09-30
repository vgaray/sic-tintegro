package pe.com.tintegro.dto.request;

public class EliminarAgentexColaRequest extends RequestBase
{
	private Integer idAgente;
	private Integer idCola;
	public Integer getIdAgente()
	{
		return idAgente;
	}
	public void setIdAgente(Integer idAgente)
	{
		this.idAgente = idAgente;
	}
	public Integer getIdCola()
	{
		return idCola;
	}
	public void setIdCola(Integer idCola)
	{
		this.idCola = idCola;
	}
	
	
}
