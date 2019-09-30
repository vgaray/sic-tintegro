package pe.com.tintegro.dto.request;

public class ActualizarCentralExternaRequest extends RequestBase
{
	private Integer idEmpresa;
	private String pNoEmpresa;
	private String pNuIpEmpr; 
	private String pNoDescrip;
	public Integer getIdEmpresa()
	{
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}
	public String getpNoEmpresa()
	{
		return pNoEmpresa;
	}
	public void setpNoEmpresa(String pNoEmpresa)
	{
		this.pNoEmpresa = pNoEmpresa;
	}
	public String getpNuIpEmpr()
	{
		return pNuIpEmpr;
	}
	public void setpNuIpEmpr(String pNuIpEmpr)
	{
		this.pNuIpEmpr = pNuIpEmpr;
	}
	public String getpNoDescrip()
	{
		return pNoDescrip;
	}
	public void setpNoDescrip(String pNoDescrip)
	{
		this.pNoDescrip = pNoDescrip;
	}
	
}
