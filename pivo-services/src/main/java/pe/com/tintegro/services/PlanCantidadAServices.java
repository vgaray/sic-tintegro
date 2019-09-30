package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarPlanCantidadARequest;
import pe.com.tintegro.dto.response.ListarPlanCantidadAResponse;

public interface PlanCantidadAServices {
	public ListarPlanCantidadAResponse listarplancantida(ListarPlanCantidadARequest request);

}
