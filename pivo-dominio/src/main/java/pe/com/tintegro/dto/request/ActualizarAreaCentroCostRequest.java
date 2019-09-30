package pe.com.tintegro.dto.request;

public class ActualizarAreaCentroCostRequest extends RequestBase {
	private Integer idEmpare;
	private String pNombre;
	private Integer idPadre;
	public Integer getIdEmpare() {
		return idEmpare;
	}
	public void setIdEmpare(Integer idEmpare) {
		this.idEmpare = idEmpare;
	}
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
