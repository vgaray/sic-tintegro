package pe.com.tintegro.dominio;

public class Permit
{
	private Integer idPermit;
	private Integer idSipTrunk;
	private String valor;

	public Integer getIdPermit()
	{
		return idPermit;
	}

	public void setIdPermit(Integer idPermit)
	{
		this.idPermit = idPermit;
	}

	public Integer getIdSipTrunk()
	{
		return idSipTrunk;
	}

	public void setIdSipTrunk(Integer idSipTrunk)
	{
		this.idSipTrunk = idSipTrunk;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor = valor;
	}

}
