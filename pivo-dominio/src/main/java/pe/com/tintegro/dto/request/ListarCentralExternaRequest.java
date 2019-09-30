package pe.com.tintegro.dto.request;

public class ListarCentralExternaRequest extends RequestBase
{
	private Integer pIdEmpresa;
	private Integer pOpcion;
	public Integer getpIdEmpresa()
	{
		return pIdEmpresa;
	}
	public void setpIdEmpresa(Integer pIdEmpresa)
	{
		this.pIdEmpresa = pIdEmpresa;
	}
	public Integer getpOpcion()
	{
		return pOpcion;
	}
	public void setpOpcion(Integer pOpcion)
	{
		this.pOpcion = pOpcion;
	}

}
