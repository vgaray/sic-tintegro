package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;

public interface ConstanteFisiologicaDAO {

	public ListarConstanteFisiologicaResponse listaConstanteFisiologica(ListarHistoriaClinicaServiceRequest request)
			throws Exception;
}
