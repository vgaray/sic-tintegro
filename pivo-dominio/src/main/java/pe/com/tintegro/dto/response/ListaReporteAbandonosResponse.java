package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ReporteAbandonos;

public class ListaReporteAbandonosResponse extends ResponseBase{
	
	private List<ReporteAbandonos> lsReporteAbandonos;
	private String reporteFile;
	
	public List<ReporteAbandonos> getLsReporteAbandonos() {
		return lsReporteAbandonos;
	}
	public void setLsReporteAbandonos(List<ReporteAbandonos> lsReporteAbandonos) {
		this.lsReporteAbandonos = lsReporteAbandonos;
	}
	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
	
}
