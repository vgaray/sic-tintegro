package pe.com.tintegro.dto.request;

public class ValidaAccesoAServicioRequest extends RequestBase
{
	private String noLogin;
	private String noUrl;
	private boolean ilIstancia;

	public String getNoLogin()
	{
		return noLogin;
	}

	public void setNoLogin(String noLogin)
	{
		this.noLogin = noLogin;
	}

	public String getNoUrl()
	{
		return noUrl;
	}

	public void setNoUrl(String noUrl)
	{
		this.noUrl = noUrl;
	}

	public boolean getIlIstancia()
	{
		return ilIstancia;
	}

	public void setIlIstancia(boolean ilIstancia)
	{
		this.ilIstancia = ilIstancia;
	}

}
