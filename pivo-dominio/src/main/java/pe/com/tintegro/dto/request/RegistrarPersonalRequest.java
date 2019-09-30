package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.Personal;

public class RegistrarPersonalRequest extends RequestBase{

	private Personal personal;//ahorro codigo

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
}
