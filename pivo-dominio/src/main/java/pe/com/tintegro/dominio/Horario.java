package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Horario
{
	private Integer idHorario;
	private String noHorario;
	private Integer IdGrupoHorario;
	private String hoInicio;
	private String hoFin;
	private String nomDiaSemanaInicio;
	private String nomDiaSemanaFin;
	private String nomDiaMesInicio;
	private String nomDiaMesFin;
	private String nomMesInicio;
	private String nomMesFin;
	private Integer tipoHorario;
	private String nomAudio;

	public String getNoHorario()
	{
		return noHorario;
	}

	public void setNoHorario(String noHorario)
	{
		this.noHorario = noHorario;
	}

	public Integer getIdHorario()
	{
		return idHorario;
	}

	public void setIdHorario(Integer idHorario)
	{
		this.idHorario = idHorario;
	}

	public Integer getIdGrupoHorario()
	{
		return IdGrupoHorario;
	}

	public void setIdGrupoHorario(Integer idGrupoHorario)
	{
		IdGrupoHorario = idGrupoHorario;
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

	public String getNomDiaSemanaInicio()
	{
		return nomDiaSemanaInicio;
	}

	public void setNomDiaSemanaInicio(String nomDiaSemanaInicio)
	{
		this.nomDiaSemanaInicio = nomDiaSemanaInicio;
	}

	public String getNomDiaSemanaFin()
	{
		return nomDiaSemanaFin;
	}

	public void setNomDiaSemanaFin(String nomDiaSemanaFin)
	{
		this.nomDiaSemanaFin = nomDiaSemanaFin;
	}

	public String getNomDiaMesInicio()
	{
		return nomDiaMesInicio;
	}

	public void setNomDiaMesInicio(String nomDiaMesInicio)
	{
		this.nomDiaMesInicio = nomDiaMesInicio;
	}

	public String getNomDiaMesFin()
	{
		return nomDiaMesFin;
	}

	public void setNomDiaMesFin(String nomDiaMesFin)
	{
		this.nomDiaMesFin = nomDiaMesFin;
	}

	public String getNomMesInicio()
	{
		return nomMesInicio;
	}

	public void setNomMesInicio(String nomMesInicio)
	{
		this.nomMesInicio = nomMesInicio;
	}

	public String getNomMesFin()
	{
		return nomMesFin;
	}

	public void setNomMesFin(String nomMesFin)
	{
		this.nomMesFin = nomMesFin;
	}

	public Integer getTipoHorario()
	{
		return tipoHorario;
	}

	public void setTipoHorario(Integer tipoHorario)
	{
		this.tipoHorario = tipoHorario;
	}

	public String getNomAudio()
	{
		return nomAudio;
	}

	public void setNomAudio(String nomAudio)
	{
		this.nomAudio = nomAudio;
	}

}
