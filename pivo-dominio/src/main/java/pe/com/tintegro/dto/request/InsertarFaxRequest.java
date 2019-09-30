package pe.com.tintegro.dto.request;

public class InsertarFaxRequest extends RequestBase
{
	private Integer idFax;
	private String noFaxVirtual;
	private String noCorreoAsociado;
	private Integer unCallerId;
	private String noCallerId; 
	private String passwordFax; 
	private Integer idExtension;
	
	public Integer getIdFax()
	{
		return idFax;
	}
	public void setIdFax(Integer idFax)
	{
		this.idFax = idFax;
	}
	public String getNoFaxVirtual()
	{
		return noFaxVirtual;
	}
	public void setNoFaxVirtual(String noFaxVirtual)
	{
		this.noFaxVirtual = noFaxVirtual;
	}
	public String getNoCorreoAsociado()
	{
		return noCorreoAsociado;
	}
	public void setNoCorreoAsociado(String noCorreoAsociado)
	{
		this.noCorreoAsociado = noCorreoAsociado;
	}
	public Integer getUnCallerId()
	{
		return unCallerId;
	}
	public void setUnCallerId(Integer unCallerId)
	{
		this.unCallerId = unCallerId;
	}
	public String getPasswordFax()
	{
		return passwordFax;
	}
	public void setPasswordFax(String passwordFax)
	{
		this.passwordFax = passwordFax;
	}
	public Integer getIdExtension()
	{
		return idExtension;
	}
	public void setIdExtension(Integer idExtension)
	{
		this.idExtension = idExtension;
	}
	public String getNoCallerId()
	{
		return noCallerId;
	}
	public void setNoCallerId(String noCallerId)
	{
		this.noCallerId = noCallerId;
	}

	
}
