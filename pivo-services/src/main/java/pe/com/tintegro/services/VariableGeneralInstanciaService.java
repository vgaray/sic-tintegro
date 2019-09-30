package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;

public interface VariableGeneralInstanciaService  {
	public ListarVariableGeneralInstanciaResponse listarVariables(String codUsuario, String idInstancia,ListarVariableGeneralInstanciaRequest request)throws Exception;
}
