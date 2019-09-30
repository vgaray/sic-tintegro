package pe.com.tintegro.dao;

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

public interface PlanPrincipalDAO
{
	public ListarPlanPrincipalResponse listarPlanPrincipal(String ip,ListarPlanPrincipalRequest request)throws Exception;
	public ListarContextoPorPlanResponse listarContextoPorPlan(String ip,ListarContextoPorPlanRequest request)throws Exception;
	public InsertarPlanPrincipalResponse insertarPlanPrincipal(String ip,InsertarPlanPrincipalRequest request)throws Exception;
	public ActualizarPlanPrincipalResponse actualizarPlanPrincipal(String ip,ActualizarPlanPrincipalRequest request)throws Exception;
	public EliminarPlanPrincipalResponse eliminarPlanPrincipal(String ip,EliminarPlanPrincipalRequest request)throws Exception;	
}
