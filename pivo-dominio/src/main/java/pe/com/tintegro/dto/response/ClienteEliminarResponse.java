package pe.com.tintegro.dto.response;

import java.util.List;

public class ClienteEliminarResponse extends ResponseBase {
	
	/**
	 * 
	 */
	private List<Integer> elimino;

	public List<Integer> getElimino() {
		return elimino;
	}

	public void setElimino(List<Integer> elimino) {
		this.elimino = elimino;
	}

}
