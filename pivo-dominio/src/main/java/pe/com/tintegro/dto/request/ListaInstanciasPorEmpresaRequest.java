package pe.com.tintegro.dto.request;

public class ListaInstanciasPorEmpresaRequest extends RequestBase
{
	private String idInstancia;
	private Integer idInstanciaDesc;

	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}

	public Integer getIdInstanciaDesc()
	{
		return idInstanciaDesc;
	}

	public void setIdInstanciaDesc(Integer idInstanciaDesc)
	{
		this.idInstanciaDesc = idInstanciaDesc;
	}

}
