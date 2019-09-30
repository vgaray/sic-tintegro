package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Extension implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSip;
	private String nombre;
	private String callerId;
	public int getIdSip() {
		return idSip;
	}
	public void setIdSip(int idSip) {
		this.idSip = idSip;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCallerId() {
		return callerId;
	}
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}


	
	
}
