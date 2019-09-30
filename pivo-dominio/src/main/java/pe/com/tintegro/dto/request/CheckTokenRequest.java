package pe.com.tintegro.dto.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckTokenRequest implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String clientId;
   private String token;
	private String codUsuario;
   
   
	public String getClientId()
	{
		return clientId;
	}

	public void setClientId(String clientId)
	{
		this.clientId = clientId;
	}
	
	public String getToken()
	{
		return token;
	}
	
	public void setToken(String token)
	{
		this.token = token;
	}
	
	public String getCodUsuario()
	{
		return codUsuario;
	}
	
	public void setCodUsuario(String codUsuario)
	{
		this.codUsuario = codUsuario;
	}
	
}
