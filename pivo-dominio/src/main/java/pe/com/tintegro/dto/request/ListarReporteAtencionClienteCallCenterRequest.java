package pe.com.tintegro.dto.request;


public class ListarReporteAtencionClienteCallCenterRequest extends RequestBase{

	private String tiReport;
	private	Integer vaTab;
	private	Integer vaNsv;
	private	String feReport;
	private	String noQueue;
	private int tipoFile;
	
	public String getTiReport() {
		return tiReport;
	}
	public void setTiReport(String tiReport) {
		this.tiReport = tiReport;
	}
	public Integer getVaTab() {
		return vaTab;
	}
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
	public void setVaTab(Integer vaTab) {
		this.vaTab = vaTab;
	}
	public Integer getVaNsv() {
		return vaNsv;
	}
	public void setVaNsv(Integer vaNsv) {
		this.vaNsv = vaNsv;
	}
	public String getFeReport() {
		return feReport;
	}
	public void setFeReport(String feReport) {
		this.feReport = feReport;
	}
	public String getNoQueue() {
		return noQueue;
	}
	public void setNoQueue(String noQueue) {
		this.noQueue = noQueue;
	}
	

}
