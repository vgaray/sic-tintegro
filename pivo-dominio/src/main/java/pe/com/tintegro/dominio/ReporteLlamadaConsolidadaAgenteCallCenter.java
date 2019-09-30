package pe.com.tintegro.dominio;

import java.io.Serializable;

public class ReporteLlamadaConsolidadaAgenteCallCenter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String anexo;
	private Integer eContestada;
	private Integer eNoContestada;
	private Integer eFallida;
	private Integer totalEntrante;
	private Integer totalInhablando;
	private String totalInhablando2;
	private Integer sContestada;
	private Integer sNocontestada;
	private Integer sFallida;
	private Integer totalSaliente;
	private Integer totalOutHablando;
	private String totalOuthablando2;
	private Integer totalRegistros;
	

	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public Integer geteContestada() {
		return eContestada;
	}
	public void seteContestada(Integer eContestada) {
		this.eContestada = eContestada;
	}
	public Integer geteNoContestada() {
		return eNoContestada;
	}
	public void seteNoContestada(Integer eNoContestada) {
		this.eNoContestada = eNoContestada;
	}
	public Integer geteFallida() {
		return eFallida;
	}
	public void seteFallida(Integer eFallida) {
		this.eFallida = eFallida;
	}
	public Integer getTotalEntrante() {
		return totalEntrante;
	}
	public void setTotalEntrante(Integer totalEntrante) {
		this.totalEntrante = totalEntrante;
	}
	public Integer getTotalInhablando() {
		return totalInhablando;
	}
	public void setTotalInhablando(Integer totalInhablando) {
		this.totalInhablando = totalInhablando;
	}
	public String getTotalInhablando2() {
		return totalInhablando2;
	}
	public void setTotalInhablando2(String totalInhablando2) {
		this.totalInhablando2 = totalInhablando2;
	}
	public Integer getsContestada() {
		return sContestada;
	}
	public void setsContestada(Integer sContestada) {
		this.sContestada = sContestada;
	}
	public Integer getsNocontestada() {
		return sNocontestada;
	}
	public void setsNocontestada(Integer sNocontestada) {
		this.sNocontestada = sNocontestada;
	}
	public Integer getsFallida() {
		return sFallida;
	}
	public void setsFallida(Integer sFallida) {
		this.sFallida = sFallida;
	}
	public Integer getTotalSaliente() {
		return totalSaliente;
	}
	public void setTotalSaliente(Integer totalSaliente) {
		this.totalSaliente = totalSaliente;
	}
	public Integer getTotalOutHablando() {
		return totalOutHablando;
	}
	public void setTotalOutHablando(Integer totalOutHablando) {
		this.totalOutHablando = totalOutHablando;
	}
	public String getTotalOuthablando2() {
		return totalOuthablando2;
	}
	public void setTotalOuthablando2(String totalOuthablando2) {
		this.totalOuthablando2 = totalOuthablando2;
	}
	public Integer getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	
}
