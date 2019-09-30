package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.InstanciaN;

public class InsertarInstanciaNRequest extends RequestBase {

	private InstanciaN instanciaN;

	public InstanciaN getInstanciaN() {
		return instanciaN;
	}

	public void setInstanciaN(InstanciaN instanciaN) {
		this.instanciaN = instanciaN;
	}
}
