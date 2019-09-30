package pe.com.tintegro.dto.request;

public class ValidarDirectorioRequest extends RequestBase{
	private String noNombre;
	private Integer idGrupo;

	public String getNoNombre() {
		return noNombre;
	}

	public void setNoNombre(String noNombre) {
		this.noNombre = noNombre;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}


	
	
}
