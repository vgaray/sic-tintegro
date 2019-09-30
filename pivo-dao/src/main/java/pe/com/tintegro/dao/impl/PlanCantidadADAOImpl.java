package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.PlanCantidadADAO;
import pe.com.tintegro.dominio.Plan;
import pe.com.tintegro.dto.request.ListarPlanCantidadARequest;
import pe.com.tintegro.dto.response.ListarPlanCantidadAResponse;
import pe.com.tintegro.mapper.PlanCantidadAMapper;

@Repository("planCantidadADAO")
public class PlanCantidadADAOImpl extends DAOTintegroImpl implements PlanCantidadADAO{

	@Override
	public ListarPlanCantidadAResponse listarplancantidadanexos(ListarPlanCantidadARequest request) {
		List<Plan> result = new ArrayList<Plan>();
		ListarPlanCantidadAResponse response = new ListarPlanCantidadAResponse();
		PlanCantidadAMapper mapper = this.getSqlSessionSic().getMapper(PlanCantidadAMapper.class);
		result=(List<Plan>)mapper.listarplancantidadA(request.getpIdPlan());
		response.setEstado(1);
		response.setLsplanAnexos(result);
		return response;
	}
}
