package pe.com.tintegro.dto.request;

public class CambiaEstadoListaNegraRequest extends RequestBase
{
	private String nuTelefo;
	private Boolean ilActivo;

	public String getNuTelefo()
	{
		return nuTelefo;
	}

	public void setNuTelefo(String nuTelefo)
	{
		this.nuTelefo = nuTelefo;
	}

	public Boolean getIlActivo()
	{
		return ilActivo;
	}

	public void setIlActivo(Boolean ilActivo)
	{
		this.ilActivo = ilActivo;
	}

}
