package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadas;

public class ListarLlamadasAtendidasAbandonadasResponse extends ResponseBase{

	private List<LlamadasAtendidasAbandonadas> lsAtendidasAbandonadas;
//	private Integer nuTotalReg; //Número total de registros sin paginación
	private String reporteFile; //Tipo de reporte PDF o Excel.

	public String getReporteFile() {
		return reporteFile;
	}

	public void setReporteFile(String reporteFile) {
		this.reporteFile = reporteFile;
	}

	public List<LlamadasAtendidasAbandonadas> getLsAtendidasAbandonadas() {
		return lsAtendidasAbandonadas;
	}

	public void setLsAtendidasAbandonadas(List<LlamadasAtendidasAbandonadas> lsAtendidasAbandonadas) {
		this.lsAtendidasAbandonadas = lsAtendidasAbandonadas;
	}

//	public Integer getNuTotalReg() {
//		return nuTotalReg;
//	}
//
//	public void setNuTotalReg(Integer nuTotalReg) {
//		this.nuTotalReg = nuTotalReg;
//	}
	
}
