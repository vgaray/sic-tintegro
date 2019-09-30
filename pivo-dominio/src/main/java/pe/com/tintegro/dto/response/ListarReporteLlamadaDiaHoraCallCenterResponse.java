package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;

public class ListarReporteLlamadaDiaHoraCallCenterResponse extends ResponseBase{
	private List<ReporteLlamadaDiaHoraCallCenter> lsreporteLlamadaDiaHora;
	private String reporteFile;
	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public List<ReporteLlamadaDiaHoraCallCenter> getLsreporteLlamadaDiaHora() {
		return lsreporteLlamadaDiaHora;
	}

	public void setLsreporteLlamadaDiaHora(List<ReporteLlamadaDiaHoraCallCenter> lsreporteLlamadaDiaHora) {
		this.lsreporteLlamadaDiaHora = lsreporteLlamadaDiaHora;
	}
}
