package pe.com.tintegro.dto.request;

public class InsertaTbPinRequest extends RequestBase{

	private int idUsupin;
	private int idClave;
	private int idTiptel;
	
	private int estadoIE;
	
	
	public int getEstadoIE() {
		return estadoIE;
	}
	public void setEstadoIE(int estadoIE) {
		this.estadoIE = estadoIE;
	}
	
	public int getIdUsupin() {
		return idUsupin;
	}
	public void setIdUsupin(int idUsupin) {
		this.idUsupin = idUsupin;
	}
	public int getIdClave() {
		return idClave;
	}
	public void setIdClave(int idClave) {
		this.idClave = idClave;
	}
	public int getIdTiptel() {
		return idTiptel;
	}
	public void setIdTiptel(int idTiptel) {
		this.idTiptel = idTiptel;
	}
	
	
	
}
