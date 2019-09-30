package pe.com.tintegro.dominio;

import java.io.Serializable;

public class Bash implements Serializable
{
	private static final long serialVersionUID = 2694297841954447663L;

	private Integer idBash;
	private String noDescrip;
	private String noRuta;
	private Integer nuTipo;
	private boolean ilUltimo;

	public Integer getIdBash()
	{
		return idBash;
	}

	public void setIdBash(Integer idBash)
	{
		this.idBash = idBash;
	}

	public String getNoDescrip()
	{
		return noDescrip;
	}

	public void setNoDescrip(String noDescrip)
	{
		this.noDescrip = noDescrip;
	}

	public String getNoRuta()
	{
		return noRuta;
	}

	public void setNoRuta(String noRuta)
	{
		this.noRuta = noRuta;
	}

	public Integer getNuTipo()
	{
		return nuTipo;
	}

	public void setNuTipo(Integer nuTipo)
	{
		this.nuTipo = nuTipo;
	}

	public boolean isIlUltimo()
	{
		return ilUltimo;
	}

	public void setIlUltimo(boolean ilUltimo)
	{
		this.ilUltimo = ilUltimo;
	}
}
