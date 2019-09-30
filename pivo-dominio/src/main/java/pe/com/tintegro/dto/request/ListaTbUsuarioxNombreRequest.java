package pe.com.tintegro.dto.request;

public class ListaTbUsuarioxNombreRequest extends RequestBase{

	private String nombreUsuario;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public ListaTbUsuarioxNombreRequest(String nombreUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
	}

	public ListaTbUsuarioxNombreRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
