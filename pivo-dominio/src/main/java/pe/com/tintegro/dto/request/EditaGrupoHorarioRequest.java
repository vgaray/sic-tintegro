package pe.com.tintegro.dto.request;

public class EditaGrupoHorarioRequest extends RequestBase
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
