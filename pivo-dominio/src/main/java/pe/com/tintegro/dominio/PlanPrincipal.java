package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PlanPrincipal
{
	private Integer idPlanPrincipal;
	private String noNombre;
	private String noDescripcion;
	
	public Integer getIdPlanPrincipal()
	{
		return idPlanPrincipal;
	}
	public void setIdPlanPrincipal(Integer idPlanPrincipal)
	{
		this.idPlanPrincipal = idPlanPrincipal;
	}
	public String getNoNombre()
	{
		return noNombre;
	}
	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}
	public String getNoDescripcion()
	{
		return noDescripcion;
	}
	public void setNoDescripcion(String noDescripcion)
	{
		this.noDescripcion = noDescripcion;
	}
	
	
}
