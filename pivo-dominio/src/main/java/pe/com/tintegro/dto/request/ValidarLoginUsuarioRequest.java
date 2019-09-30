package pe.com.tintegro.dto.request;

public class ValidarLoginUsuarioRequest extends RequestBase
{
	private String nologin;

	public String getNologin()
	{
		return nologin;
	}

	public void setNologin(String nologin)
	{
		this.nologin = nologin;
	}

}
