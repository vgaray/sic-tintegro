package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;

public interface ListadoProblemaDAO {

	public ListarListadoProblemaResponse listaListadoProblema(ListarHistoriaClinicaServiceRequest request)
			throws Exception;
}
