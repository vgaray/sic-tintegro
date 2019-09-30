package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Vacuna;

public class ListarVacunaResponse extends ResponseBase {

	private List<Vacuna> lsVacuna;

	public List<Vacuna> getLsVacuna() {
		return lsVacuna;
	}

	public void setLsVacuna(List<Vacuna> lsVacuna) {
		this.lsVacuna = lsVacuna;
	}

}
