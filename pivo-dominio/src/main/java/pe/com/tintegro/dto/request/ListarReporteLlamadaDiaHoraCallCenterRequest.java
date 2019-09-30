package pe.com.tintegro.dto.request;

public class ListarReporteLlamadaDiaHoraCallCenterRequest extends RequestBase {

	private String noCola;
	private String feInicon;
	private String feFincon;
	private int tipoFile;
	
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
	public String getNoCola() {
		return noCola;
	}
	public void setNoCola(String noCola) {
		this.noCola = noCola;
	}
	public String getFeInicon() {
		return feInicon;
	}
	public void setFeInicon(String feInicon) {
		this.feInicon = feInicon;
	}
	public String getFeFincon() {
		return feFincon;
	}
	public void setFeFincon(String feFincon) {
		this.feFincon = feFincon;
	}
}
