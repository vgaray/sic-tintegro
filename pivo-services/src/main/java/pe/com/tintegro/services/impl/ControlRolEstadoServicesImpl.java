package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ControlRolEstadoDAO;
import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;
import pe.com.tintegro.services.ControlRolEstadoServices;

@Service("controlRolEstadoServices")
@Transactional
public class ControlRolEstadoServicesImpl implements ControlRolEstadoServices {
	
	@Resource(name = "ControlRolEstadoDAO")
	ControlRolEstadoDAO controlRolEstadoDAO;

	public ListaControlRolEstadoResponse listarControlRolEstadoServices(String codUsuario, ListaControlRolEstadoRequest request) throws Exception {
		ListaControlRolEstadoResponse response = new ListaControlRolEstadoResponse();
		ListaControlRolEstadoResponse rpta = new ListaControlRolEstadoResponse();
		request.setNoLogin(codUsuario);
		rpta = controlRolEstadoDAO.listaControlRolEstadoDAO(request);
		response.setValidarControlResult(rpta.getValidarControlResult());
		return response;
	}
}