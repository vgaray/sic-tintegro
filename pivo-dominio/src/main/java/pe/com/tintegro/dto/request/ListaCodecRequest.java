package pe.com.tintegro.dto.request;

public class ListaCodecRequest extends RequestBase
{
	private Integer idSipTrunk;
	private Integer tipo;

	public Integer getIdSipTrunk()
	{
		return idSipTrunk;
	}

	public void setIdSipTrunk(Integer idSipTrunk)
	{
		this.idSipTrunk = idSipTrunk;
	}

	public Integer getTipo()
	{
		return tipo;
	}

	public void setTipo(Integer tipo)
	{
		this.tipo = tipo;
	}

}
