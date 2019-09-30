package pe.com.tintegro.dto.request;

public class ListaLlamadaAgenteRequest  extends RequestBase{
	
	private Integer idAgente;
	private String feIniCon;
	private String feFinCon;
	private String horaI;
	private String horaF;
	
	private int tipoFile;
	
	public Integer getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	public String getFeIniCon() {
		return feIniCon;
	}
	public void setFeIniCon(String feIniCon) {
		this.feIniCon = feIniCon;
	}
	public String getFeFinCon() {
		return feFinCon;
	}
	public void setFeFinCon(String feFinCon) {
		this.feFinCon = feFinCon;
	}
	public String getHoraI() {
		return horaI;
	}
	public void setHoraI(String horaI) {
		this.horaI = horaI;
	}
	public String getHoraF() {
		return horaF;
	}
	public void setHoraF(String horaF) {
		this.horaF = horaF;
	}
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
}
