package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.Personal;

public class ActualizarPersonalRequest extends RequestBase{

	private Personal personal;
	

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
}
