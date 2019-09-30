package pe.com.tintegro.dto.request;

public class ListaUsuarioPorCodigoRequest extends RequestBase {
private String pCodUsuario;
private Integer pIdUsuario;

public String getpCodUsuario() {
	return pCodUsuario;
}

public void setpCodUsuario(String pCodUsuario) {
	this.pCodUsuario = pCodUsuario;
}

public Integer getpIdUsuario() {
	return pIdUsuario;
}

public void setpIdUsuario(Integer pIdUsuario) {
	this.pIdUsuario = pIdUsuario;
} 


}
