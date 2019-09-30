package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;

public interface HistoriaClinicaServiceDAO {

	public ListarHistoriaClinicaServiceResponse listarHistoriaClinicaService(ListarHistoriaClinicaServiceRequest request)
			throws Exception;
}
