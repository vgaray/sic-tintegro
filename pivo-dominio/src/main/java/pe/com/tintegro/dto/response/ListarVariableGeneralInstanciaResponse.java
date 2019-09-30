package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.VariableGeneralInstancia;

public class ListarVariableGeneralInstanciaResponse extends ResponseBase {
	private List<VariableGeneralInstancia> lsVariableGeneral;

	public List<VariableGeneralInstancia> getLsVariableGeneral() {
		return lsVariableGeneral;
	}

	public void setLsVariableGeneral(
			List<VariableGeneralInstancia> lsVariableGeneral) {
		this.lsVariableGeneral = lsVariableGeneral;
	}
}
