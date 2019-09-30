package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;

public interface ControlRolEstadoServices
{
public ListaControlRolEstadoResponse listarControlRolEstadoServices(String codUsuario, ListaControlRolEstadoRequest request) throws Exception;
}
