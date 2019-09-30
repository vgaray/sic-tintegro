package pe.com.tintegro.dto.request;

public class InsertarPlanPrincipalRequest extends RequestBase
{
	private String noNombre;
	private String noDescripcion;
	private String contexto;
	
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
