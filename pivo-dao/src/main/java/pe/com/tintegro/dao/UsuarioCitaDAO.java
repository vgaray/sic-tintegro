package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;

public interface UsuarioCitaDAO {

	public ListarUsuarioCitaResponse listaUsuarioCita(ListarUsuarioCitaRequest request) throws Exception;
}
