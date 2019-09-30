package pe.com.tintegro.services;

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

public interface PlanPrincipalServices
{
	public ListarPlanPrincipalResponse listarPlanPrincipal(String codUsuario,String idInstancia,ListarPlanPrincipalRequest request)throws Exception;
	
	public ListarContextoPorPlanResponse listarContextoPorPlan(String codUsuario,String idInstancia,ListarContextoPorPlanRequest request)throws Exception;
	
	public InsertarPlanPrincipalResponse insertarPlanPrincipal(String codUsuario,String idInstancia,InsertarPlanPrincipalRequest request)throws Exception;
	
	public ActualizarPlanPrincipalResponse actualizarPlanPrincipal(String codUsuario,String idInstancia,ActualizarPlanPrincipalRequest request)throws Exception;
	
	public EliminarPlanPrincipalResponse eliminarPlanPrincipal(String codUsuario,String idInstancia,EliminarPlanPrincipalRequest request)throws Exception;
}
