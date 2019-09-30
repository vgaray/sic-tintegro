package pe.com.tintegro.dto.request;

public class FlagTbPinRequest extends RequestBase{

	private int idUsupin;
	private int idClave;
	private int idTiptel;
	
	private int estado;

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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
