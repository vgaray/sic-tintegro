package pe.com.tintegro.dto.request;

public class ConfirmarCambioContrasenaRequest
{
	private String pCodUsuario;
	private String pToken;
	private String pTokenEncript;

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

	public String getpTokenEncript()
	{
		return pTokenEncript;
	}

	public void setpTokenEncript(String pTokenEncript)
	{
		this.pTokenEncript = pTokenEncript;
	}
}
