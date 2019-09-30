package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PlanPrincipalDAO;
import pe.com.tintegro.dto.request.ActualizarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.EliminarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.InsertarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.ListarContextoPorPlanRequest;
import pe.com.tintegro.dto.request.ListarPlanPrincipalRequest;
import pe.com.tintegro.dto.response.ActualizarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.EliminarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.InsertarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.ListarContextoPorPlanResponse;
import pe.com.tintegro.dto.response.ListarPlanPrincipalResponse;
import pe.com.tintegro.services.GenerarPlanMarcacionServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PlanPrincipalServices;

@Service("planPrincipalServices")
@Transactional
public class PlanPrincipalServicesImpl implements PlanPrincipalServices {
	
	@Resource(name = "generarPlanMarcacionServices")
	protected GenerarPlanMarcacionServices generarPlanMarcacionServices;

	@Resource(name = "planPrincipalDAO")
	protected PlanPrincipalDAO planPrincipalDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListarPlanPrincipalResponse listarPlanPrincipal(String codUsuario, String idInstancia, ListarPlanPrincipalRequest request) throws Exception {
		ListarPlanPrincipalResponse response = new ListarPlanPrincipalResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planPrincipalDAO.listarPlanPrincipal(ip, request);
		return response;
	}

	@Override
	public ListarContextoPorPlanResponse listarContextoPorPlan(String codUsuario, String idInstancia, ListarContextoPorPlanRequest request) throws Exception {
		ListarContextoPorPlanResponse response = new ListarContextoPorPlanResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planPrincipalDAO.listarContextoPorPlan(ip, request);
		return response;
	}

	@Override
	public InsertarPlanPrincipalResponse insertarPlanPrincipal(String codUsuario, String idInstancia, InsertarPlanPrincipalRequest request) throws Exception {
		InsertarPlanPrincipalResponse response = new InsertarPlanPrincipalResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planPrincipalDAO.insertarPlanPrincipal(ip, request);
		generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		return response;
	}

	@Override
	public ActualizarPlanPrincipalResponse actualizarPlanPrincipal(String codUsuario, String idInstancia, ActualizarPlanPrincipalRequest request) throws Exception {
		ActualizarPlanPrincipalResponse response = new ActualizarPlanPrincipalResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planPrincipalDAO.actualizarPlanPrincipal(ip, request);
		generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminarPlanPrincipalResponse eliminarPlanPrincipal(String codUsuario, String idInstancia, EliminarPlanPrincipalRequest request) throws Exception {
		EliminarPlanPrincipalResponse response = new EliminarPlanPrincipalResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planPrincipalDAO.eliminarPlanPrincipal(ip, request);
		generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		return response;
	}
}
