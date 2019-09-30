package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.LlamadasAbandonadasPorMinuto;

public class ListarLlamadasAbandonadasPorMinutoResponse extends ResponseBase{
	private List<LlamadasAbandonadasPorMinuto> lsLlamadasEntradasPorMinuto;
	private String reporteFile;

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public void setLsLlamadasEntradasPorMinuto(List<LlamadasAbandonadasPorMinuto> lsLlamadasEntradasPorMinuto) {
		this.lsLlamadasEntradasPorMinuto = lsLlamadasEntradasPorMinuto;
	}

	public List<LlamadasAbandonadasPorMinuto> getLsLlamadasEntradasPorMinuto() {
		return lsLlamadasEntradasPorMinuto;
	}

}
