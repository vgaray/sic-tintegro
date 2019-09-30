package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.VariableGeneralInstanciaDAO;
import pe.com.tintegro.dto.request.ListarVariableGeneralInstanciaRequest;
import pe.com.tintegro.dto.response.ListarVariableGeneralInstanciaResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.VariableGeneralInstanciaService;

@Service("variableGeneralInstanciaService")
@Transactional
public class VariableGeneralInstanciaServiceImpl implements VariableGeneralInstanciaService {
	@Resource(name = "variableGeneralInstanciaDAO")
	protected VariableGeneralInstanciaDAO variablesDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;
	@Override
	public ListarVariableGeneralInstanciaResponse listarVariables(String codUsuario, String idInstancia,ListarVariableGeneralInstanciaRequest request) throws Exception {
		ListarVariableGeneralInstanciaResponse response=new ListarVariableGeneralInstanciaResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = variablesDAO.listarVariables(ip, request);
		return response;
	}
}
