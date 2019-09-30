package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ReporteLlamadaConsolidadaAgenteCallCenter;

public class ListarReporteLlamadaConsolidadaAgenteCallCenterResponse extends ResponseBase{
	private List<ReporteLlamadaConsolidadaAgenteCallCenter> lsreporteLlamadaConsolidadaAgente;
	private String reporteFile;
	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public List<ReporteLlamadaConsolidadaAgenteCallCenter> getLsreporteLlamadaConsolidadaAgente() {
		return lsreporteLlamadaConsolidadaAgente;
	}

	public void setLsreporteLlamadaConsolidadaAgente(
			List<ReporteLlamadaConsolidadaAgenteCallCenter> lsreporteLlamadaConsolidadaAgente) {
		this.lsreporteLlamadaConsolidadaAgente = lsreporteLlamadaConsolidadaAgente;
	}
}
