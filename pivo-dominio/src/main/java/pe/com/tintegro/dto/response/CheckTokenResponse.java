package pe.com.tintegro.dto.response;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckTokenResponse 
{
	/**
	 * 
	 */

	private String aud;
	private Date expiration;
	private String username;
	private List<String> authorities;
	private String clientId;
	private List<String> scope;
	private String mensaje;

	public String getAud()
	{
		return aud;
	}

	public void setAud(String aud)
	{
		this.aud = aud;
	}

	public Date getExpiration()
	{
		return expiration;
	}

	public void setExpiration(Date expiration)
	{
		this.expiration = expiration;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public List<String> getAuthorities()
	{
		return authorities;
	}

	public void setAuthorities(List<String> authorities)
	{
		this.authorities = authorities;
	}

	public String getClientId()
	{
		return clientId;
	}

	public void setClientId(String clientId)
	{
		this.clientId = clientId;
	}

	public List<String> getScope()
	{
		return scope;
	}

	public void setScope(List<String> scope)
	{
		this.scope = scope;
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
