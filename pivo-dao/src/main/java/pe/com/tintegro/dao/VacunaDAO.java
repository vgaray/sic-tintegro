package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;

public interface VacunaDAO {

	public ListarVacunaResponse listaVacuna(ListarHistoriaClinicaServiceRequest request)
			throws Exception;
}
