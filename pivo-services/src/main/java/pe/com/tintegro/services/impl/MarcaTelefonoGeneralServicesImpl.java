package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.MarcaTelefonoGeneralDAO;
import pe.com.tintegro.dto.request.ListaMarcaTelefonoRequest;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;
import pe.com.tintegro.services.MarcaTelefonoGeneralServices;

@Service("marcaTelefonoGeneralServices")
@Transactional
public class MarcaTelefonoGeneralServicesImpl implements MarcaTelefonoGeneralServices {
	@Resource(name = "marcaTelefonoGeneralDAO")
	protected MarcaTelefonoGeneralDAO marcaTelefonoGeneralDAO;

	@Override
	public ListaMarcaTelefonoResponse listaMarcaTelefonoGeneral(String codUsuario, ListaMarcaTelefonoRequest request) throws Exception {
		// ListaMarcaTelefonoResponse response = new
		// ListaMarcaTelefonoResponse();
		return marcaTelefonoGeneralDAO.listaMarcaTelefonoGeneral(request);
	}

}
