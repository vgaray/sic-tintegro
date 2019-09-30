package pe.com.tintegro.dominio;

import java.io.Serializable;

public class LlamadasAbandonadasPorMinuto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nuLlam;
	private String abaMenor;
	private String abaMayor;
	
	public String getNuLlam() {
		return nuLlam;
	}
	public void setNuLlam(String nuLlam) {
		this.nuLlam = nuLlam;
	}
	public String getAbaMenor() {
		return abaMenor;
	}
	public void setAbaMenor(String abaMenor) {
		this.abaMenor = abaMenor;
	}
	public String getAbaMayor() {
		return abaMayor;
	}
	public void setAbaMayor(String abaMayor) {
		this.abaMayor = abaMayor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
