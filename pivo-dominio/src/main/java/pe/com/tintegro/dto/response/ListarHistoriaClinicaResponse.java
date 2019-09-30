package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.HistoriaClinica;

public class ListarHistoriaClinicaResponse extends ResponseBase{
	private List<HistoriaClinica> lsHistoriaClinica;
	private String reporteFile;
	private Graficos graficoHistoriaClinica;
	
	public List<HistoriaClinica> getLsHistoriaClinica() {
		return lsHistoriaClinica;
	}
	public void setLsHistoriaClinica(List<HistoriaClinica> lsHistoriaClinica) {
		this.lsHistoriaClinica = lsHistoriaClinica;
	}
	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
	public Graficos getGraficoHistoriaClinica() {
		return graficoHistoriaClinica;
	}
	public void setGraficoHistoriaClinica(Graficos graficoHistoriaClinica) {
		this.graficoHistoriaClinica = graficoHistoriaClinica;
	}
	
}
