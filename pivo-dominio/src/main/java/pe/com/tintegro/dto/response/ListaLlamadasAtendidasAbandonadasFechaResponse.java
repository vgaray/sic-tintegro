package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;

public class ListaLlamadasAtendidasAbandonadasFechaResponse extends ResponseBase{
	
	private List<LlamadasAtendidasAbandonadasFechas> listaLlamadasAtendidasAbandonadas;
	private String reporteFile;
	//cant registros por paginacion
	private Integer nuTotalReg;
	
	public List<LlamadasAtendidasAbandonadasFechas> getListaLlamadasAtendidasAbandonadas() {
		return listaLlamadasAtendidasAbandonadas;
	}
	public void setListaLlamadasAtendidasAbandonadas(
			List<LlamadasAtendidasAbandonadasFechas> listaLlamadasAtendidasAbandonadas) {
		this.listaLlamadasAtendidasAbandonadas = listaLlamadasAtendidasAbandonadas;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
}
