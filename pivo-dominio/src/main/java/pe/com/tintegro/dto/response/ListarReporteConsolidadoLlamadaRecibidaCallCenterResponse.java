package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ReporteConsolidadoLlamadaRecibidaCallCenter;

public class ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse extends ResponseBase{
	private List<ReporteConsolidadoLlamadaRecibidaCallCenter> lsreporteConsolidadoLlamadaRecibida;
	private String reporteFile;
	public List<ReporteConsolidadoLlamadaRecibidaCallCenter> getLsreporteConsolidadoLlamadaRecibida() {
		return lsreporteConsolidadoLlamadaRecibida;
	}

	public void setLsreporteConsolidadoLlamadaRecibida(
			List<ReporteConsolidadoLlamadaRecibidaCallCenter> lsreporteConsolidadoLlamadaRecibida) {
		this.lsreporteConsolidadoLlamadaRecibida = lsreporteConsolidadoLlamadaRecibida;
	}

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
}
