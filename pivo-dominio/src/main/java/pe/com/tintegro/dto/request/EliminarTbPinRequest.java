package pe.com.tintegro.dto.request;

public class EliminarTbPinRequest extends RequestBase {
	
	private int idUsupin;
	private int idClave;
	private int idTiptel;
	
	private int estadoIE_1;
	
	
	public int getEstadoIE_1() {
		return estadoIE_1;
	}

	public void setEstadoIE_1(int estadoIE_1) {
		this.estadoIE_1 = estadoIE_1;
	}

	

	public int getIdUsupin() {
		return idUsupin;
	}

	public EliminarTbPinRequest() {
		super();
		// TODO Auto-generated constructor stub
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
