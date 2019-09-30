package pe.com.tintegro.dto.request;

public class InsertarAreaCentroCostRequest extends RequestBase {

	private String pNombre;
	private Integer idPadre;
	public String getpNombre() {
		return pNombre;
	}
	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}
	public Integer getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	

	
}
