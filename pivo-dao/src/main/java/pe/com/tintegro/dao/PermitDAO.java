package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;

public interface PermitDAO
{
	public ListaPermitResponse listaPermit(String ip, ListaPermitRequest request)throws Exception ;
}
