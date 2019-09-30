package pe.com.tintegro.dto.request;

public class ListarConsolidadoTiempoEsperaRequest extends RequestBase{

	private String cola;
	private String feIni;
	private String feFin;

	//tipo de archivo
	private int tipoFile;
		
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
	public String getCola() {
		return cola;
	}
	public void setCola(String cola) {
		this.cola = cola;
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
	
}
