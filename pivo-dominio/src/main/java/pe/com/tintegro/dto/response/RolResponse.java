package pe.com.tintegro.dto.response;

public class RolResponse extends ResponseBase{
	private Integer idRol;
	private String noMensaje;

	public String getNoMensaje() {
		return noMensaje;
	}

	public void setNoMensaje(String noMensaje) {
		this.noMensaje = noMensaje;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
	
}
