package pe.com.tintegro.dto.request;

public class BuscarListaNegraRequest extends RequestBase{

	private String nuTelefo;
	private Boolean ilActivo;
	private String coTipllam;
	
	public String getNuTelefo() {
		return nuTelefo;
	}
	public void setNuTelefo(String nuTelefo) {
		this.nuTelefo = nuTelefo;
	}
	public Boolean getIlActivo() {
		return ilActivo;
	}
	public void setIlActivo(Boolean ilActivo) {
		this.ilActivo = ilActivo;
	}
	public String getCoTipllam() {
		return coTipllam;
	}
	public void setCoTipllam(String coTipllam) {
		this.coTipllam = coTipllam;
	}
	
}
