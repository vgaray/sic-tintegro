package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.HistoriaClinica;

public class ActualizarHistoriaClinicaRequest extends RequestBase{
	private HistoriaClinica historiaClinica;

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
}
