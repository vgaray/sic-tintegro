package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.EliminarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.EliminarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;


public interface PlanSalienteDAO
{
	public ListarPlanSalienteResponse listarPlanSaliente(String ip,ListarPlanSalienteRequest request)throws Exception;
	public InsertarPlanSalienteResponse insertarPlanSaliente(String ip,InsertarPlanSalienteRequest request)throws Exception;
	public ActualizarPlanSalienteResponse actualizarPlanSaliente(String ip,ActualizarPlanSalienteRequest request)throws Exception;
	public EliminarPlanSalienteResponse eliminarPlanSaliente(String ip,EliminarPlanSalienteRequest request)throws Exception;	
}
