package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.response.ListarCitaResponse;

public interface CitaServices {
	public ListarCitaResponse listaCita(String codUsuario, String idInstancia,ListarCitaRequest request) throws Exception;
}
