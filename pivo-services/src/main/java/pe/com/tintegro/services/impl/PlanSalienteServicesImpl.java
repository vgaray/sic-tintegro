package pe.com.tintegro.services.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PlanSalienteDAO;
import pe.com.tintegro.dominio.PlanSaliente;
import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.EliminarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.EliminarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;
import pe.com.tintegro.services.GenerarPlanMarcacionServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.PlanSalienteServices;

@Service("planSalienteServices")
@Transactional
public class PlanSalienteServicesImpl implements PlanSalienteServices {
	
	@Resource(name = "planSalienteDAO")
	protected PlanSalienteDAO planSalienteDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "generarPlanMarcacionServices")
	protected GenerarPlanMarcacionServices generarPlanMarcacionServices;

	@Override
	public ListarPlanSalienteResponse listarPlanSaliente(String codUsuario, String idInstancia, ListarPlanSalienteRequest request) throws Exception {
		ListarPlanSalienteResponse response = new ListarPlanSalienteResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planSalienteDAO.listarPlanSaliente(ip, request);
		return response;
	}

	@Override
	public InsertarPlanSalienteResponse insertarPlanSaliente(String codUsuario, String idInstancia, InsertarPlanSalienteRequest request) throws Exception {
		InsertarPlanSalienteResponse response = new InsertarPlanSalienteResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		ListarPlanSalienteRequest rePlan = new ListarPlanSalienteRequest();
		List<PlanSaliente> lsPlan = listarPlanSaliente(codUsuario, idInstancia, rePlan).getListado();
		int cont = 0;
		for (int i = 0; i < lsPlan.size(); i++) {
			if (lsPlan.get(i).getNoNombre().equals(request.getNoNombre())) {
				cont = 1;
			}
		}

		if (cont == 1) {
			response.setInsertado(4);
		} else {
			response = planSalienteDAO.insertarPlanSaliente(ip, request);
			generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		}
		return response;
	}

	@Override
	public ActualizarPlanSalienteResponse actualizarPlanSaliente(String codUsuario, String idInstancia, ActualizarPlanSalienteRequest request) throws Exception {
		ActualizarPlanSalienteResponse response = new ActualizarPlanSalienteResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planSalienteDAO.actualizarPlanSaliente(ip, request);
		generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminarPlanSalienteResponse eliminarPlanSaliente(String codUsuario, String idInstancia, EliminarPlanSalienteRequest request) throws Exception {
		EliminarPlanSalienteResponse response = new EliminarPlanSalienteResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = planSalienteDAO.eliminarPlanSaliente(ip, request);
		generarPlanMarcacionServices.generarTxtPlanMarcacion(codUsuario, idInstancia);
		return response;
	}

}
