package pe.com.tintegro.dominio;

import java.io.Serializable;

public class VariableGeneralInstancia implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idVariablesGenerales;
	private String noVariablesGenerales;
	public Integer getIdVariablesGenerales() {
		return idVariablesGenerales;
	}
	public void setIdVariablesGenerales(Integer idVariablesGenerales) {
		this.idVariablesGenerales = idVariablesGenerales;
	}
	public String getNoVariablesGenerales() {
		return noVariablesGenerales;
	}
	public void setNoVariablesGenerales(String noVariablesGenerales) {
		this.noVariablesGenerales = noVariablesGenerales;
	}
	}
