package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.CitaDAO;
import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.response.ListarCitaResponse;
import pe.com.tintegro.services.CitaServices;
import pe.com.tintegro.services.InstanciaServices;

@Service("citaServices")
@Transactional
public class CitaServicesImpl implements CitaServices {

	@Resource(name = "citaDAO")
	protected CitaDAO citaDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListarCitaResponse listaCita(String codUsuario, String idInstancia, ListarCitaRequest request)
			throws Exception {
		ListarCitaResponse response = new ListarCitaResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = citaDAO.listaCita(ip, request);
		return response;
	}

}
