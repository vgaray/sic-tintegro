package pe.com.tintegro.dominio;

import java.io.Serializable;

public class ReporteConsolidadoLlamadaRecibidaCallCenter implements Serializable {

	private static final long serialVersionUID = 1L;
	String noQueuename;
	String noMes;
	String noDia;
	String noDiaSemana;
	Integer nuCantidad;
	Integer nuAnio;

	public String getNoQueuename() {
		return noQueuename;
	}
	public void setNoQueuename(String noQueuename) {
		this.noQueuename = noQueuename;
	}
	public String getNoMes() {
		return noMes;
	}
	public void setNoMes(String noMes) {
		this.noMes = noMes;
	}
	public String getNoDia() {
		return noDia;
	}
	public void setNoDia(String noDia) {
		this.noDia = noDia;
	}
	
	public String getNoDiaSemana() {
		return noDiaSemana;
	}
	public void setNoDiaSemana(String noDiaSemana) {
		this.noDiaSemana = noDiaSemana;
	}

	public Integer getNuCantidad() {
		return nuCantidad;
	}
	public void setNuCantidad(Integer nuCantidad) {
		this.nuCantidad = nuCantidad;
	}
	public Integer getNuAnio() {
		return nuAnio;
	}
	public void setNuAnio(Integer nuAnio) {
		this.nuAnio = nuAnio;
	}
	

}
