package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.PlanSaliente;

public class ListarPlanSalienteResponse extends ResponseBase
{
	List<PlanSaliente> listado;

	public List<PlanSaliente> getListado()
	{
		return listado;
	}

	public void setListado(List<PlanSaliente> listado)
	{
		this.listado = listado;
	}
	
	
}
