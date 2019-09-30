package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.TerritorioDAO;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.services.TerritorioServices;


@Service("TerritorioServices")
@Transactional
public class TerritorioServicesImpl implements TerritorioServices {
	@Resource(name = "territorioDAO")
	protected TerritorioDAO territorioDao;

	@Override
	public ListaTerritorioResponse listaTerritorio(ListaTerritorioRequest request) throws Exception {
		ListaTerritorioResponse response = new ListaTerritorioResponse();
		response = territorioDao.listaTerritorio(request);
		return response;
	}
}