package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class GenerarTxtIvr implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idGrupoHor;
	private String noGurpoHor;
	private String noIVR;
	private Integer idHorario;
	private String hoInicio;
	private String hoFin;
	private String noDiaSemanaInicio;
	private String noDiaSemanaFin;
	private String noDiaMesInicio;
	private String noDiaMesFin;
	private String noMesInicio;
	private String noMesFin;
	private Integer tiHorario;
	private String noAudio;

	public String getNoIVR()
	{
		return noIVR;
	}

	public void setNoIVR(String noIVR)
	{
		this.noIVR = noIVR;
	}

	public Integer getIdGrupoHor()
	{
		return idGrupoHor;
	}

	public void setIdGrupoHor(Integer idGrupoHor)
	{
		this.idGrupoHor = idGrupoHor;
	}

	public String getNoGurpoHor()
	{
		return noGurpoHor;
	}

	public void setNoGurpoHor(String noGurpoHor)
	{
		this.noGurpoHor = noGurpoHor;
	}

	public Integer getIdHorario()
	{
		return idHorario;
	}

	public void setIdHorario(Integer idHorario)
	{
		this.idHorario = idHorario;
	}

	public String getHoInicio()
	{
		return hoInicio;
	}

	public void setHoInicio(String hoInicio)
	{
		this.hoInicio = hoInicio;
	}

	public String getHoFin()
	{
		return hoFin;
	}

	public void setHoFin(String hoFin)
	{
		this.hoFin = hoFin;
	}

	public String getNoDiaSemanaInicio()
	{
		return noDiaSemanaInicio;
	}

	public void setNoDiaSemanaInicio(String noDiaSemanaInicio)
	{
		this.noDiaSemanaInicio = noDiaSemanaInicio;
	}

	public String getNoDiaSemanaFin()
	{
		return noDiaSemanaFin;
	}

	public void setNoDiaSemanaFin(String noDiaSemanaFin)
	{
		this.noDiaSemanaFin = noDiaSemanaFin;
	}

	public String getNoDiaMesInicio()
	{
		return noDiaMesInicio;
	}

	public void setNoDiaMesInicio(String noDiaMesInicio)
	{
		this.noDiaMesInicio = noDiaMesInicio;
	}

	public String getNoDiaMesFin()
	{
		return noDiaMesFin;
	}

	public void setNoDiaMesFin(String noDiaMesFin)
	{
		this.noDiaMesFin = noDiaMesFin;
	}

	public String getNoMesInicio()
	{
		return noMesInicio;
	}

	public void setNoMesInicio(String noMesInicio)
	{
		this.noMesInicio = noMesInicio;
	}

	public String getNoMesFin()
	{
		return noMesFin;
	}

	public void setNoMesFin(String noMesFin)
	{
		this.noMesFin = noMesFin;
	}

	public Integer getTiHorario()
	{
		return tiHorario;
	}

	public void setTiHorario(Integer tiHorario)
	{
		this.tiHorario = tiHorario;
	}

	public String getNoAudio()
	{
		return noAudio;
	}

	public void setNoAudio(String noAudio)
	{
		this.noAudio = noAudio;
	}

}
