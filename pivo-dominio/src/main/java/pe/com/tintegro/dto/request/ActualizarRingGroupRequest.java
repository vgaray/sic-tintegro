package pe.com.tintegro.dto.request;

import java.util.List;

public class ActualizarRingGroupRequest extends RequestBase
{
	private Integer idGrupo;
	private String noGrupo;
	private Integer nuGrupo;
	private List<String> nuSips;
	private Boolean ilActivo;
	private String idSip;

	public Integer getIdGrupo()
	{
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo)
	{
		this.idGrupo = idGrupo;
	}

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
	public String getIdSip()
	{
		return idSip;
	}

	public void setIdSip(String idSip)
	{
		this.idSip = idSip;
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
