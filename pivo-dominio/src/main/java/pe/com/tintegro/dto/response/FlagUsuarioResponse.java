package pe.com.tintegro.dto.response;


public class FlagUsuarioResponse extends ResponseBase  {
	/**
	 * 
	 */
	private int activado;

	public int getActivado() {
		return activado;
	}

	public void setActivado(int activado) {
		this.activado = activado;
	}

	public FlagUsuarioResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlagUsuarioResponse(int activado) {
		super();
		this.activado = activado;
	}
	
}
