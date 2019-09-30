package pe.com.tintegro.dominio;

import java.io.Serializable;

public class StatusBash implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2408562186235993778L;

	private Integer idBash;
	private String noDescripBash;
	private String noServicioEjecucion;
	private Integer nuStatusBash;
	private String noStatusBash;
	private Boolean ilNext;
	private Boolean ilLast;

	public Boolean getIlNext()
	{
		return ilNext;
	}

	public void setIlNext(Boolean ilNext)
	{
		this.ilNext = ilNext;
	}

	public Integer getIdBash()
	{
		return idBash;
	}

	public void setIdBash(Integer idBash)
	{
		this.idBash = idBash;
	}

	public String getNoDescripBash()
	{
		return noDescripBash;
	}

	public void setNoDescripBash(String noDescripBash)
	{
		this.noDescripBash = noDescripBash;
	}

	public String getNoServicioEjecucion()
	{
		return noServicioEjecucion;
	}

	public void setNoServicioEjecucion(String noServicioEjecucion)
	{
		this.noServicioEjecucion = noServicioEjecucion;
	}

	public Integer getNuStatusBash()
	{
		return nuStatusBash;
	}

	public Boolean getIlLast()
	{
		return ilLast;
	}

	public void setIlLast(Boolean ilLast)
	{
		this.ilLast = ilLast;
	}

	public void setNuStatusBash(Integer nuStatusBash)
	{
		this.nuStatusBash = nuStatusBash;
	}

	public String getNoStatusBash()
	{
		return noStatusBash;
	}

	public void setNoStatusBash(String noStatusBash)
	{
		this.noStatusBash = noStatusBash;
	}
}
