package pe.com.tintegro.dto.request;

import java.util.List;

public class InsertarRingGroupRequest extends RequestBase
{
	private String noGrupo;
	private Integer nuGrupo;
	private List<String> nuSips;

	private String nuSipL;

	public String getNoGrupo()
	{
		return noGrupo;
	}

	public void setNoGrupo(String noGrupo)
	{
		this.noGrupo = noGrupo;
	}

	public Integer getNuGrupo()
	{
		return nuGrupo;
	}

	public void setNuGrupo(Integer nuGrupo)
	{
		this.nuGrupo = nuGrupo;
	}

	public List<String> getNuSips()
	{
		return nuSips;
	}

	public void setNuSips(List<String> nuSips)
	{
		this.nuSips = nuSips;
	}

	public String getNuSipL()
	{
		return nuSipL;
	}

	public void setNuSipL(String nuSipL)
	{
		this.nuSipL = nuSipL;
	}

}
