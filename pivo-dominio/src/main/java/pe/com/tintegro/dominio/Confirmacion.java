package pe.com.tintegro.dominio;

import java.io.Serializable;

public class Confirmacion implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6860021230134584439L;

	private int ID;
	private String mensaje;

	public int getID() 
	{
		return ID;
	}

	public void setID(int iD) 
	{
		ID = iD;
	}

	public String getMensaje() 
	{
		return mensaje;
	}

	public void setMensaje(String mensaje) 
	{
		this.mensaje = mensaje;
	}
}
