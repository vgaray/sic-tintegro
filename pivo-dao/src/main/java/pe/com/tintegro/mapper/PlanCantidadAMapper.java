package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Plan;

public interface PlanCantidadAMapper {
	public List<Plan> listarplancantidadA(@Param("pIdPlan") Integer IdCliente);
}
