package pe.com.tintegro.dto.request;

public class GrabacionRequest extends RequestBase{
	private Integer agente;
	private String tipo;//
	private Integer tipoFun;
	private String origen;
	private String destino;
	private String feInicon;
	private String feFincon;
	private String pHorai;
	private String pHoraf;
	public Integer getAgente() {
		return agente;
	}
	public void setAgente(Integer agente) {
		this.agente = agente;
	}
	public int getTipoFun() {
		return tipoFun;
	}
	public void setTipoFun(int tipoFun) {
		this.tipoFun = tipoFun;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFeInicon() {
		return feInicon;
	}
	public void setFeInicon(String feInicon) {
		this.feInicon = feInicon;
	}
	public String getFeFincon() {
		return feFincon;
	}
	public void setFeFincon(String feFincon) {
		this.feFincon = feFincon;
	}
	public String getpHorai() {
		return pHorai;
	}
	public void setpHorai(String pHorai) {
		this.pHorai = pHorai;
	}
	public String getpHoraf() {
		return pHoraf;
	}
	public void setpHoraf(String pHoraf) {
		this.pHoraf = pHoraf;
	}
}
