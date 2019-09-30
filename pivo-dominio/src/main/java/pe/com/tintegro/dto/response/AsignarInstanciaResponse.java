package pe.com.tintegro.dto.response;

import java.util.List;

public class AsignarInstanciaResponse extends ResponseBase {
	
	private List<Integer> asignado;

	public List<Integer> getAsignado() {
		return asignado;
	}

	public void setAsignado(List<Integer> asignado) {
		this.asignado = asignado;
	}

	

}
