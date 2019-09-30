package pe.com.tintegro.dto.request;

public class ActualizarListaNegraRequest extends RequestBase
{

	private String nuTelefo;
	private String noDescri;
	private boolean ilActivo;
	private Integer coTipllam;
	private String coTipllamSig;

	public String getNuTelefo()
	{
		return nuTelefo;
	}

	public void setNuTelefo(String nuTelefo)
	{
		this.nuTelefo = nuTelefo;
	}

	public String getNoDescri()
	{
		return noDescri;
	}

	public void setNoDescri(String noDescri)
	{
		this.noDescri = noDescri;
	}

	public boolean isIlActivo()
	{
		return ilActivo;
	}

	public void setIlActivo(boolean ilActivo)
	{
		this.ilActivo = ilActivo;
	}

	public Integer getCoTipllam()
	{
		return coTipllam;
	}

	public void setCoTipllam(Integer coTipllam)
	{
		this.coTipllam = coTipllam;
	}

	public String getCoTipllamSig()
	{
		return coTipllamSig;
	}

	public void setCoTipllamSig(String coTipllamSig)
	{
		this.coTipllamSig = coTipllamSig;
	}

	

}
