package pe.com.tintegro.dto.request;

public class ValidaAccesoAInstanciaRequest
{
	private String noLogin;
	private String idInstancia;

	public String getNoLogin()
	{
		return noLogin;
	}

	public void setNoLogin(String noLogin)
	{
		this.noLogin = noLogin;
	}

	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}
}
