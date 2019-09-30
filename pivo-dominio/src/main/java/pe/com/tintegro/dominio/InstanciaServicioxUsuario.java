package pe.com.tintegro.dominio;

import java.io.Serializable;

public class InstanciaServicioxUsuario implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer idResulta;
	private String noMensaje;

	public Integer getIdResulta()
	{
		return idResulta;
	}

	public void setIdResulta(Integer idResulta)
	{
		this.idResulta = idResulta;
	}

	public String getNoMensaje()
	{
		return noMensaje;
	}

	public void setNoMensaje(String noMensaje)
	{
		this.noMensaje = noMensaje;
	}
}
