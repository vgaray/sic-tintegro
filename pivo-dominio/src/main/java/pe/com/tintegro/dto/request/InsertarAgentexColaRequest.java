package pe.com.tintegro.dto.request;

public class InsertarAgentexColaRequest extends RequestBase
{
	private Integer idAgente;
	private Integer idCola;
	private Integer prioridad;
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
	public Integer getPrioridad()
	{
		return prioridad;
	}
	public void setPrioridad(Integer prioridad)
	{
		this.prioridad = prioridad;
	}
	
	
}
