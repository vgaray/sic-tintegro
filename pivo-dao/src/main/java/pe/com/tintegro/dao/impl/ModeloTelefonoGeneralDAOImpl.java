package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.ModeloTelefonoGeneralDAO;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;
import pe.com.tintegro.mapper.ModeloTelefonoGeneralMapper;

@Repository("modeloTelefonoGeneralDAO")
public class ModeloTelefonoGeneralDAOImpl extends DAOTintegroImpl implements ModeloTelefonoGeneralDAO
{
	
	@Override
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarcaGeneral(ListaModeloTelefonoPorMarcaRequest request) throws Exception
	{
		// TODO Auto-generated method stub
		ListaModeloTelefonoPorMarcaResponse response = new ListaModeloTelefonoPorMarcaResponse();
		List<ModeloTelefono> listModelo = new ArrayList<ModeloTelefono>();
		ModeloTelefonoGeneralMapper modeloMapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.ModeloTelefonoGeneralMapper.class);
		listModelo = modeloMapper.listaModeloTelefonoPorMarcaGeneral(request.getMarcaId());
		response.setModeloTelefonoList(listModelo);
		return response;
	}
}
