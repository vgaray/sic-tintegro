package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.PlanPrincipal;

public class ListarPlanPrincipalResponse extends ResponseBase
{
	List<PlanPrincipal> listado;

	public List<PlanPrincipal> getListado()
	{
		return listado;
	}

	public void setListado(List<PlanPrincipal> listado)
	{
		this.listado = listado;
	}
	
	
}
