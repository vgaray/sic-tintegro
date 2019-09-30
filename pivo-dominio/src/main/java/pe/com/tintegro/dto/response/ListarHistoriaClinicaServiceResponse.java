package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;

public class ListarHistoriaClinicaServiceResponse extends ResponseBase {
	private List<HistoriaClinicaService> lsHistoriaClinica;

	public List<HistoriaClinicaService> getLsHistoriaClinica() {
		return lsHistoriaClinica;
	}

	public void setLsHistoriaClinica(List<HistoriaClinicaService> lsHistoriaClinica) {
		this.lsHistoriaClinica = lsHistoriaClinica;
	}

}
