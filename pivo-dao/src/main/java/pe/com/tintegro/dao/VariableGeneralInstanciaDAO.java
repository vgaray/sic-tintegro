package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;

public interface VariableGeneralInstanciaDAO {

	public ListarVariableGeneralInstanciaResponse listarVariables(String ip,ListarVariableGeneralInstanciaRequest request) throws Exception;
}
