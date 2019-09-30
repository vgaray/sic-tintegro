package pe.com.tintegro.dto.request;

public class EditaHorarioRequest extends RequestBase
{
	private Integer idHorario;
	private Integer idGrupoHor;
	private String hoInicio;
	private String hoFin;
	private String nomDiaSemanaInicio;
	private String nomDiaSemanaFin;
	private String nomDiaMesInicio;
	private String nomDiaMesFin;
	private String nomMesInicio;
	private String nomMesFin;
	private Integer tiHorario;
	private String nomAudio;
	private String base64Audio;
	
	public Integer getIdHorario()
	{
		return idHorario;
	}

	public void setIdHorario(Integer idHorario)
	{
		this.idHorario = idHorario;
	}

	public Integer getIdGrupoHor()
	{
		return idGrupoHor;
	}

	public void setIdGrupoHor(Integer idGrupoHor)
	{
		this.idGrupoHor = idGrupoHor;
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

	public Integer getTiHorario()
	{
		return tiHorario;
	}

	public void setTiHorario(Integer tiHorario)
	{
		this.tiHorario = tiHorario;
	}

	public String getNomAudio()
	{
		return nomAudio;
	}

	public void setNomAudio(String nomAudio)
	{
		this.nomAudio = nomAudio;
	}

	public String getBase64Audio()
	{
		return base64Audio;
	}

	public void setBase64Audio(String base64Audio)
	{
		this.base64Audio = base64Audio;
	}

}
