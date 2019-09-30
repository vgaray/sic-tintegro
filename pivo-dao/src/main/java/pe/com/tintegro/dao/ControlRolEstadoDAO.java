package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;

public interface ControlRolEstadoDAO
{
	public ListaControlRolEstadoResponse listaControlRolEstadoDAO(ListaControlRolEstadoRequest request) throws Exception;
}
