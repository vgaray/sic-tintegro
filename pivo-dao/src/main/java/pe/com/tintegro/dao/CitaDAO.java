package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.response.ListarCitaResponse;

public interface CitaDAO {

	public ListarCitaResponse listaCita(String ip,ListarCitaRequest request)throws Exception;
}
