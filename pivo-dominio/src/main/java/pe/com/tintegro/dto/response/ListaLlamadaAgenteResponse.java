package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadaAgente;

public class ListaLlamadaAgenteResponse  extends ResponseBase{

	private List<LlamadaAgente> lsLAgente;
	private String reporteFile;
		
	public List<LlamadaAgente> getLsLAgente() {
		return lsLAgente;
	}
	public void setLsLAgente(List<LlamadaAgente> lsLAgente) {
		this.lsLAgente = lsLAgente;
	}
	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
}
