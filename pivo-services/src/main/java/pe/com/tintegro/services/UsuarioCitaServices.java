package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;

public interface UsuarioCitaServices {

	public ListarUsuarioCitaResponse listaUsuarioCita(ListarUsuarioCitaRequest request) throws Exception;
}
