package pe.com.tintegro.dto.request;

public class ListaTbUsuarioPaginadoRequest extends RequestBase
{
	private Integer numpagina;
	private Integer numRegisMostrar;

	public Integer getNumpagina()
	{
		return numpagina;
	}

	public void setNumpagina(Integer numpagina)
	{
		this.numpagina = numpagina;
	}

	public Integer getNumRegisMostrar()
	{
		return numRegisMostrar;
	}

	public void setNumRegisMostrar(Integer numRegisMostrar)
	{
		this.numRegisMostrar = numRegisMostrar;
	}

}
