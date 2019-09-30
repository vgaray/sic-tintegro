package pe.com.tintegro.dto.request;

public class ListaCustomTrunkRequest extends RequestBase
{
	private Integer idCustomTrunk;
	private Integer idTipoCustomTrunk;

	public Integer getIdCustomTrunk()
	{
		return idCustomTrunk;
	}

	public void setIdCustomTrunk(Integer idCustomTrunk)
	{
		this.idCustomTrunk = idCustomTrunk;
	}

	public Integer getIdTipoCustomTrunk()
	{
		return idTipoCustomTrunk;
	}

	public void setIdTipoCustomTrunk(Integer idTipoCustomTrunk)
	{
		this.idTipoCustomTrunk = idTipoCustomTrunk;
	}
}
