package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;

public interface MenuSicServices
{
public MenuSicResponse listaMenu(String codUsuario, String idInstancia, MenuSicRequest request)throws Exception;
}
