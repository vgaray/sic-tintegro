package pe.com.tintegro.dto.request;

public class ActualizarGrupoDirectRequest extends RequestBase
{
	private Integer idGrupo;
	private String noNombre;
	public Integer getIdGrupo()
	{
		return idGrupo;
	}
	public void setIdGrupo(Integer idGrupo)
	{
		this.idGrupo = idGrupo;
	}
	public String getNoNombre()
	{
		return noNombre;
	}
	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}
	
	
}
