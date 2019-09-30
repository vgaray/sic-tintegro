package pe.com.tintegro.dto.response;

import java.util.List;

public class ClienteActualizarReponse extends ResponseBase {
	
	/**
	 * 
	 */
	private List<Integer> actualizo;

	public List<Integer> getActualizo() {
		return actualizo;
	}

	public void setActualizo(List<Integer> actualizo) {
		this.actualizo = actualizo;
	}

}
