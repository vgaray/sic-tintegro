package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;

public interface PaginaService {
	 public ListarPaginaResponse listarPaginaServices(ListarPaginaRequest request) throws Exception;
	 public ListarPaginaResponse listarPaginaServicesGP(ListarPaginaRequest request) throws Exception;
	 public ListaUrlPaginaResponse listaUrlPaginaResponse(ListaUrlPaginaRequest request)throws Exception;
	 
}
