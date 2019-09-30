package pe.com.tintegro.dto.request;

public class ActualizarPlanPrincipalRequest extends RequestBase
{
	private Integer idPlanPrincipal;
	private String noNombre;
	private String noDescripcion;
	private String contexto;
	
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
	public String getContexto()
	{
		return contexto;
	}
	public void setContexto(String contexto)
	{
		this.contexto = contexto;
	}
	
	
}
