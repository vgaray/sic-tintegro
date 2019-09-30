package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.MarcaTelefonoDAO;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.MarcaTelefonoServices;

@Service("marcaTelefonoServices")
@Transactional
public class MarcaTelefonoServicesImpl implements MarcaTelefonoServices {
	
	@Resource(name = "marcaTelefonoDAO")
	protected MarcaTelefonoDAO marcaTelefonoDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaMarcaTelefonoResponse listaMarcaTelefono(String codUsuario, String idInstancia) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return marcaTelefonoDAO.listaMarcaTelefono(ip);
	}

}
