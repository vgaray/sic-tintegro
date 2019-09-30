package pe.com.tintegro.dto.request;

public class ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest extends RequestBase{

	private String queueName;
	private String feIni;
	private String feFin;
	private int tipoFile;
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getFeIni() {
		return feIni;
	}
	public void setFeIni(String feIni) {
		this.feIni = feIni;
	}
	public String getFeFin() {
		return feFin;
	}
	public void setFeFin(String feFin) {
		this.feFin = feFin;
	}
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
	
}
