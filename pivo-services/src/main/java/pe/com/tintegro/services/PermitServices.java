package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;

public interface PermitServices
{
	ListaPermitResponse listaPermit(String codUsuario, String idInstancia, ListaPermitRequest request) throws Exception;
}
