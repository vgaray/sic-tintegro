package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.EliminarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.EliminarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;

public interface PlanSalienteServices
{
	public ListarPlanSalienteResponse listarPlanSaliente(String codUsuario,String idInstancia,ListarPlanSalienteRequest request)throws Exception;
	
	public InsertarPlanSalienteResponse insertarPlanSaliente(String codUsuario,String idInstancia,InsertarPlanSalienteRequest request)throws Exception;

	public ActualizarPlanSalienteResponse actualizarPlanSaliente(String codUsuario,String idInstancia,ActualizarPlanSalienteRequest request)throws Exception;
	
	public EliminarPlanSalienteResponse eliminarPlanSaliente(String codUsuario,String idInstancia,EliminarPlanSalienteRequest request)throws Exception;
}
