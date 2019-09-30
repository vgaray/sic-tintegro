package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.VariableGeneralInstanciaDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.VariableGeneralInstancia;
import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;
@Repository("variableGeneralInstanciaDAO")
public class VariableGeneralInstanciaDAOImpl extends DAOTintegroImpl implements
		VariableGeneralInstanciaDAO {

	@Override
	public ListarVariableGeneralInstanciaResponse listarVariables(String ip,
			ListarVariableGeneralInstanciaRequest request) throws Exception {
		// TODO Auto-generated method stub
		ListarVariableGeneralInstanciaResponse response = new ListarVariableGeneralInstanciaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		String storedProcedureName = "asterisk.fn_listar_variable_por_tipo";
		Object[][] params = { { request.getpIdGrupoVariable(), Integer.class }
		};
		Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
		mapColumnToAttributte.put("id", "idVariablesGenerales");
		mapColumnToAttributte.put("descripcion", "noVariablesGenerales");

		Response<VariableGeneralInstancia> responseA = BaseDao.baseData(storedProcedureName,
				params, db.con, VariableGeneralInstancia.class, mapColumnToAttributte);
		if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
			throw responseA.getException();
		} else {
			response.setMensaje("OK");
			response.setLsVariableGeneral(responseA.getData());
		}
		response.setEstado(responseA.getCodigo());

		return response;
	}

}
