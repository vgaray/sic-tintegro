package pe.com.tintegro.dto.request;

public class ActualizaNuevaContrasenaRequest
{
	private String pNewPassword;
	private String pCodUsuario;
	private String pToken;
	private String pToken2;

	public String getpNewPassword()
	{
		return pNewPassword;
	}

	public void setpNewPassword(String pNewPassword)
	{
		this.pNewPassword = pNewPassword;
	}

	public String getpCodUsuario()
	{
		return pCodUsuario;
	}

	public void setpCodUsuario(String pCodUsuario)
	{
		this.pCodUsuario = pCodUsuario;
	}

	public String getpToken()
	{
		return pToken;
	}

	public void setpToken(String pToken)
	{
		this.pToken = pToken;
	}

	public String getpToken2()
	{
		return pToken2;
	}

	public void setpToken2(String pToken2)
	{
		this.pToken2 = pToken2;
	}

}
