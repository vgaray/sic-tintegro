package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.MenuSicDAO;
import pe.com.tintegro.dominio.MenuSic;
import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;
import pe.com.tintegro.services.MenuSicServices;
import pe.com.tintegro.services.util.MenuSicUtil;

/**
 * 
 * @author Carlos
 *
 */
@Service("menuSicServices")
@Transactional
public class MenuSicServicesImpl implements MenuSicServices {
	@Resource(name = "menuSicDAO")
	protected MenuSicDAO menuSicDAO;

	@Override
	public MenuSicResponse listaMenu(String codUsuario, String idInstancia, MenuSicRequest request) throws Exception {
		MenuSicResponse response = new MenuSicResponse();
		List<MenuSic> lista = new ArrayList<MenuSic>();

		// Evaluamos si el idInstancia es null para retornar el tipo de menu
		if (idInstancia == null) {
			idInstancia = "null";
		}
		// agregamos el codusuario como parametro para la funcion
		request.setNomLogin(codUsuario);

		// retornamos el tipo de menu segun su idInstancia
		if (!idInstancia.equals("null")) {
			request.setTipoMenu(1);

		} else {
			request.setTipoMenu(2);
		}
		// obtenermos los datos con parametros enviados
		response = menuSicDAO.listaMenu(request);

		lista = response.getMenuLista();
		MenuSicUtil menuSicUtil = new MenuSicUtil();
		List<MenuSic> relaciona = menuSicUtil.procesarData(lista);
		for (MenuSic menuSic2 : relaciona) {
			menuSic2.setIdInstancia(idInstancia);
		}
		response.setMenuLista(relaciona);
		return response;
	}

}
