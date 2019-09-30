package pe.com.tintegro.dto.request;

public class ListaModeloTelefonoPorMarcaRequest extends RequestBase
{
	private int marcaId;

	public int getMarcaId()
	{
		return marcaId;
	}

	public void setMarcaId(int marcaId)
	{
		this.marcaId = marcaId;
	}

}
