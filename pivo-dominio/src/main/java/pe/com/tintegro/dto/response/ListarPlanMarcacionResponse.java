package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.PlanMarcacion;

public class ListarPlanMarcacionResponse extends ResponseBase
{ 
	private List<PlanMarcacion> listado;

	public List<PlanMarcacion> getListado()
	{
		return listado;
	}

	public void setListado(List<PlanMarcacion> listado)
	{
		this.listado = listado;
	}
	
	
}
