package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.MenuSicDAO;
import pe.com.tintegro.dominio.MenuSic;
import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;
import pe.com.tintegro.mapper.MenuSicMapper;

@Repository("menuSicDAO")
public class MenuSicDAOImpl extends DAOTintegroImpl implements MenuSicDAO {

	@Override
	public MenuSicResponse listaMenu(MenuSicRequest request) throws Exception {
		List<MenuSic> menuSic = new ArrayList<MenuSic>();
		MenuSicResponse response = new MenuSicResponse();
		MenuSicMapper menuSicMappper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.MenuSicMapper.class);
		menuSic = menuSicMappper.listaMenuSic(request.getNomLogin(), request.getTipoMenu());

		response.setMenuLista(menuSic);
		return response;
	}
}
