package pe.com.tintegro.dominio;

public class LlamadasContestadas {

	private Integer idLlamadaC;
	private String noCola;
	private String noAgente;
	private String fecha;
	private String hora;
	private String numero;
	private String duracion;
	private Integer nuTotalReg;
	
	public Integer getIdLlamadaC() {
		return idLlamadaC;
	}
	public void setIdLlamadaC(Integer idLlamadaC) {
		this.idLlamadaC = idLlamadaC;
	}
	public String getNoCola() {
		return noCola;
	}
	public void setNoCola(String noCola) {
		this.noCola = noCola;
	}	
	public String getNoAgente() {
		return noAgente;
	}
	public void setNoAgente(String noAgente) {
		this.noAgente = noAgente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
}
