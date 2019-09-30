package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ModeloTelefonoGeneralDAO;
import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;
import pe.com.tintegro.services.ModeloTelefonoGeneralServices;

@Service("modeloTelefonoGeneralServices")
@Transactional
public class ModeloTelefonoGeneraServicesImpl implements ModeloTelefonoGeneralServices {
	@Resource(name = "modeloTelefonoGeneralDAO")
	protected ModeloTelefonoGeneralDAO modeloTelefonoGeneralDAO;

	@Override
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(String codUsuario, ListaModeloTelefonoPorMarcaRequest request) throws Exception {
		ListaModeloTelefonoPorMarcaResponse response = modeloTelefonoGeneralDAO.listaModeloTelefonoPorMarcaGeneral(request);
		return response;
	}

}
