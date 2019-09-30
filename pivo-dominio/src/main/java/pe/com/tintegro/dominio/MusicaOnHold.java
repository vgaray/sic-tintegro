package pe.com.tintegro.dominio;

import java.io.Serializable;

public class MusicaOnHold implements Serializable
{
	private static final long serialVersionUID = 6781388288128282338L;
	private Integer idClase;
	private String noClase;

	public Integer getIdClase()
	{
		return idClase;
	}

	public void setIdClase(Integer idClase)
	{
		this.idClase = idClase;
	}

	public String getNoClase()
	{
		return noClase;
	}

	public void setNoClase(String noClase)
	{
		this.noClase = noClase;
	}

}
