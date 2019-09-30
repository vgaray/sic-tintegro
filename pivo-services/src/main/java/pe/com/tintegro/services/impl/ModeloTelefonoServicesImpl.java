package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ModeloTelefonoDAO;
import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.ModeloTelefonoServices;

@Service("modeloTelefonoServices")
@Transactional
public class ModeloTelefonoServicesImpl implements ModeloTelefonoServices {
	
	@Resource(name = "modeloTelefonoDAO")
	protected ModeloTelefonoDAO modeloTelefonoDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(String codUsuario, String idInstancia, ListaModeloTelefonoPorMarcaRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return modeloTelefonoDAO.listaModeloTelefonoPorMarca(ip, request);
	}
}
