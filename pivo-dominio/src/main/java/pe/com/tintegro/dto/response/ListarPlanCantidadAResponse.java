package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Plan;

public class ListarPlanCantidadAResponse extends ResponseBase{
private List<Plan> lsplanAnexos;

public List<Plan> getLsplanAnexos() {
	return lsplanAnexos;
}

public void setLsplanAnexos(List<Plan> lsplanAnexos) {
	this.lsplanAnexos = lsplanAnexos;
}
}
