package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class GrupoHorario
{
	private Integer idGrupoHor;
	private String nomGrupoHor;

	public Integer getIdGrupoHor()
	{
		return idGrupoHor;
	}

	public void setIdGrupoHor(Integer idGrupoHor)
	{
		this.idGrupoHor = idGrupoHor;
	}

	public String getNomGrupoHor()
	{
		return nomGrupoHor;
	}

	public void setNomGrupoHor(String nomGrupoHor)
	{
		this.nomGrupoHor = nomGrupoHor;
	}

}
