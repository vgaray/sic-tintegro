package pe.com.tintegro.dto.request;

import java.io.Serializable;
import java.util.Date;

public class SendMessageRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6783996544774422782L;
	
	private String nombreApp;
	private String codUsuario;
	private Date fecha;
	private String servicio;

	private String requests;
	private String headers;
	
	//private Header head;

	public String getNombreApp()
	{
		return nombreApp;
	}

	public void setNombreApp(String nombreApp)
	{
		this.nombreApp = nombreApp;
	}

	public String getCodUsuario()
	{
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario)
	{
		this.codUsuario = codUsuario;
	}

	public Date getFecha()
	{
		return fecha;
	}

	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}

	public String getServicio()
	{
		return servicio;
	}

	public void setServicio(String servicio)
	{
		this.servicio = servicio;
	}

	public String getRequests()
	{
		return requests;
	}

	public void setRequests(String requests)
	{
		this.requests = requests;
	}

	public String getHeaders()
	{
		return headers;
	}

	public void setHeaders(String headers)
	{
		this.headers = headers;
	}

	


}
