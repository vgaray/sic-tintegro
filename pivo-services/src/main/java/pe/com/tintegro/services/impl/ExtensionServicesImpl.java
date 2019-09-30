package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ExtensionDAO;
import pe.com.tintegro.dto.response.ListaExtensionResponse;
import pe.com.tintegro.services.ExtensionServices;
import pe.com.tintegro.services.InstanciaServices;

@Service("extensionServices")
@Transactional
public class ExtensionServicesImpl implements ExtensionServices {

	@Resource(name = "extensionDAO")
	protected ExtensionDAO extensionDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaExtensionResponse listaextension(String codUsuario, String idInstancia) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return extensionDAO.listaExtension(ip);
	}
}
