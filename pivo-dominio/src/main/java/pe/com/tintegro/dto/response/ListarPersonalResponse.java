package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.Personal;

public class ListarPersonalResponse extends ResponseBase{

	private List<Personal> lsPersonal;
	private String reporteFile;
	private Graficos graficoPersonal;
	 
	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public Graficos getGraficoPersonal() {
		return graficoPersonal;
	}

	public void setGraficoPersonal(Graficos graficoPersonal) {
		this.graficoPersonal = graficoPersonal;
	}

	public List<Personal> getLsPersonal() {
		return lsPersonal;
	}

	public void setLsPersonal(List<Personal> lsPersonal) {
		this.lsPersonal = lsPersonal;
	}
}
