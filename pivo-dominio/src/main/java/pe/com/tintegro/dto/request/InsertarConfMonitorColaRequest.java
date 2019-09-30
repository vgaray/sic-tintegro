package pe.com.tintegro.dto.request;

public class InsertarConfMonitorColaRequest extends RequestBase
{
	private Integer idQueues;
	private Integer nuAnexo;
	private String noCorreo;
	private String hoMinimo;
	private String hoMedio;
	private String hoMaximo;
	
	public Integer getIdQueues()
	{
		return idQueues;
	}
	public void setIdQueues(Integer idQueues)
	{
		this.idQueues = idQueues;
	}
	public Integer getNuAnexo()
	{
		return nuAnexo;
	}
	public void setNuAnexo(Integer nuAnexo)
	{
		this.nuAnexo = nuAnexo;
	}
	public String getNoCorreo()
	{
		return noCorreo;
	}
	public void setNoCorreo(String noCorreo)
	{
		this.noCorreo = noCorreo;
	}
	public String getHoMinimo()
	{
		return hoMinimo;
	}
	public void setHoMinimo(String hoMinimo)
	{
		this.hoMinimo = hoMinimo;
	}
	public String getHoMedio()
	{
		return hoMedio;
	}
	public void setHoMedio(String hoMedio)
	{
		this.hoMedio = hoMedio;
	}
	public String getHoMaximo()
	{
		return hoMaximo;
	}
	public void setHoMaximo(String hoMaximo)
	{
		this.hoMaximo = hoMaximo;
	}
	
	
}
