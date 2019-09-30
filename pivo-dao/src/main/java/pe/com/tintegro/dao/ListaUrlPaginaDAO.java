package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;

public interface ListaUrlPaginaDAO {
	public ListaUrlPaginaResponse listaUrlPaginaResponse(String ip,ListaUrlPaginaRequest request) throws Exception;
}
