package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.LlamadasContestadas;

public class ListaLlamadasContestadasResponse extends ResponseBase{

	private List<LlamadasContestadas> lsLContestadas;	
		
	public List<LlamadasContestadas> getLsLContestadas() {
		return lsLContestadas;
	}
	public void setLsLContestadas(List<LlamadasContestadas> lsLContestadas) {
		this.lsLContestadas = lsLContestadas;
	}
	private String reporteFile;

	public String getReporteFile() {
		return reporteFile;
	}
	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}
	
}
