package pe.com.tintegro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dto.request.GeneraClaveAnexoSipRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.services.ConfiguracionPlanServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.Util;

@Service("configuracionPlanServices")
@Transactional
public class ConfiguracionPlanServicesImpl implements ConfiguracionPlanServices {
	
	@Autowired
	private InstanciaServices instanciaServices;

	@Autowired
	private SipBuddieServices sipBuddieServices;

	@Override
	public InsertaSipBuddieResponse cargarAnexosIniciales(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		InsertaSipBuddieResponse response = new InsertaSipBuddieResponse();
		InsertaSipBuddieRequest request = new InsertaSipBuddieRequest();
		for (int i = Util.NUMBER_ANNEX_INITIAL; i < Util.NUMBER_ANNEX_INITIAL + vm.getInicial(); i++) {
			request.setNomUsuario(String.format("%d", i));
			request.setCallerId(null);
			request.setClaveUsuario(sipBuddieServices.generateAnnexID(codUsuario, idInstancia, new GeneraClaveAnexoSipRequest()));
			request.setCorreoBox(null);
			request.setModeloId(vm.getIdModelo());
			request.setMarcaId(vm.getIdMarca());
			response = sipBuddieServices.insertarSipBuddie(codUsuario, idInstancia, request);
		}
		return response;
	}
}