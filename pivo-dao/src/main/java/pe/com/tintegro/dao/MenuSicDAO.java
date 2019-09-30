package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;

public interface MenuSicDAO
{
	public MenuSicResponse listaMenu(MenuSicRequest request) throws Exception;

}
