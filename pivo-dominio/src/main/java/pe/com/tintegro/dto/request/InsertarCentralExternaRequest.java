package pe.com.tintegro.dto.request;

public class InsertarCentralExternaRequest extends RequestBase
{
	private String pNoEmpresa;
	private String pNuIpEmpr; 
	private String pNoDescrip;
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
