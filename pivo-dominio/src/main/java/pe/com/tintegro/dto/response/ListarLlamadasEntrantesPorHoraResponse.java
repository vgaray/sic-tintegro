package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadasEntrantesPorHora;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHoraGrafico;

public class ListarLlamadasEntrantesPorHoraResponse extends ResponseBase{

	private List<LlamadasEntrantesPorHora> lsLlamadasEntrantesPorHora;
	private LlamadasEntrantesPorHoraGrafico grafico;
	private String reporteFile;//Tipo de reporte PDF o Excel.

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public void setLsLlamadasEntrantesPorHora(List<LlamadasEntrantesPorHora> lsLlamadasEntrantesPorHora) {
		this.lsLlamadasEntrantesPorHora = lsLlamadasEntrantesPorHora;
	}

	public LlamadasEntrantesPorHoraGrafico getGrafico() {
		return grafico;
	}

	public void setGrafico(LlamadasEntrantesPorHoraGrafico grafico) {
		this.grafico = grafico;
	}

	public List<LlamadasEntrantesPorHora> getLsLlamadasEntrantesPorHora() {
		return lsLlamadasEntrantesPorHora;
	}
}
