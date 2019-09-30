package pe.com.tintegro.dto.response;


public class EliminarTbPinResponse extends  ResponseBase {
	/**
	 * 
	 */
	private int eliminado;

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}

	public EliminarTbPinResponse(int eliminado) {
		super();
		this.eliminado = eliminado;
	}

	public EliminarTbPinResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
