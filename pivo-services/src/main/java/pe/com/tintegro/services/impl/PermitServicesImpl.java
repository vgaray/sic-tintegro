package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PermitDAO;
import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PermitServices;

@Service("permitServices")
@Transactional
public class PermitServicesImpl implements PermitServices {
	
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "permitDAO")
	protected PermitDAO permitDAO;

	@Override
	public ListaPermitResponse listaPermit(String codUsuario, String idInstancia, ListaPermitRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return permitDAO.listaPermit(ip, request);
	}
}
