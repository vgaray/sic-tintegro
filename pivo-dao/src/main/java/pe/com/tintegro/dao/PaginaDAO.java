package pe.com.tintegro.dao;


import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;

public interface PaginaDAO {
	public ListarPaginaResponse listarPagina(ListarPaginaRequest request);
	
	public ListarPaginaResponse listarPaginasGP(ListarPaginaRequest request) throws Exception;
	
	public ListaUrlPaginaResponse listaUrlPagina(ListaUrlPaginaRequest request) throws Exception;
	
	
}
