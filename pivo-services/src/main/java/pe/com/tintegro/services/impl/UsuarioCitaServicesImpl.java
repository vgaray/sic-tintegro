package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.TerritorioDAO;
import pe.com.tintegro.dao.UsuarioCitaDAO;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;
import pe.com.tintegro.services.TerritorioServices;
import pe.com.tintegro.services.UsuarioCitaServices;


@Service("usuarioCitaServices")
@Transactional
public class UsuarioCitaServicesImpl implements UsuarioCitaServices {
	@Resource(name = "usuarioCitaDAO")
	protected UsuarioCitaDAO usuarioCitaDAO;

	@Override
	public ListarUsuarioCitaResponse listaUsuarioCita(ListarUsuarioCitaRequest request) throws Exception {
		ListarUsuarioCitaResponse response = new ListarUsuarioCitaResponse();
		response = usuarioCitaDAO.listaUsuarioCita(request);
		return response;
	}
}