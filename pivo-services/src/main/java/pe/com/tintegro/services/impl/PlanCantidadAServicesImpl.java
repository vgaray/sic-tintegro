package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.PlanCantidadADAO;
import pe.com.tintegro.dto.request.ListarPlanCantidadARequest;
import pe.com.tintegro.dto.response.ListarPlanCantidadAResponse;
import pe.com.tintegro.services.PlanCantidadAServices;

@Service("planCantidadAServices")
@Transactional
public class PlanCantidadAServicesImpl implements PlanCantidadAServices {

	@Resource(name = "planCantidadADAO")
	protected PlanCantidadADAO plancanidadADAO;

	@Override
	public ListarPlanCantidadAResponse listarplancantida(ListarPlanCantidadARequest request) {
		ListarPlanCantidadAResponse response = new ListarPlanCantidadAResponse();
		response = plancanidadADAO.listarplancantidadanexos(request);
		return response;
	}

}
