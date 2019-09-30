package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Cita;

public class ListarCitaResponse extends ResponseBase {
	private List<Cita> listaCita;

	public List<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}

}
