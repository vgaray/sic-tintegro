package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ListaNegra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nuTelefo;
	private String noDescri;
	private boolean ilActivo;
	private String coTipllam;

	public String getNuTelefo()
	{
		return nuTelefo;
	}

	public void setNuTelefo(String nuTelefo)
	{
		this.nuTelefo = nuTelefo;
	}

	public String getNoDescri()
	{
		return noDescri;
	}

	public void setNoDescri(String noDescri)
	{
		this.noDescri = noDescri;
	}

	public boolean isIlActivo()
	{
		return ilActivo;
	}

	public void setIlActivo(boolean ilActivo)
	{
		this.ilActivo = ilActivo;
	}

	public String getCoTipllam()
	{
		return coTipllam;
	}

	public void setCoTipllam(String coTipllam)
	{
		this.coTipllam = coTipllam;
	}

}
