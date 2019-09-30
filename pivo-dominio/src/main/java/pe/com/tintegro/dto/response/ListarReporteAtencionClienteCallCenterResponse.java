package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;

public class ListarReporteAtencionClienteCallCenterResponse extends ResponseBase{
	private List<ReporteAtencionClienteCallCenter> lsreporteAtencionCliente;
	private Graficos graficoLlamada;
	private Graficos graficoLlamadaPorc;
	private String reporteFile;

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public Graficos getGraficoLlamada() {
		return graficoLlamada;
	}

	public void setGraficoLlamada(Graficos graficoLlamada) {
		this.graficoLlamada = graficoLlamada;
	}

	public Graficos getGraficoLlamadaPorc() {
		return graficoLlamadaPorc;
	}

	public void setGraficoLlamadaPorc(Graficos graficoLlamadaPorc) {
		this.graficoLlamadaPorc = graficoLlamadaPorc;
	}

	public List<ReporteAtencionClienteCallCenter> getLsreporteAtencionCliente() {
		return lsreporteAtencionCliente;
	}

	public void setLsreporteAtencionCliente(List<ReporteAtencionClienteCallCenter> lsreporteAtencionCliente) {
		this.lsreporteAtencionCliente = lsreporteAtencionCliente;
	}

	
}
