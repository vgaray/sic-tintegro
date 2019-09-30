package pe.com.tintegro.dto.request;

public class ListarReporteLlamadaConsolidadaAgenteCallCenterRequest extends RequestBase {

	private String feInicon;
	private String feFincon;
	private String pHorai;
	private String pHoraf;
	private Integer pNuPagina;
	private Integer pNuRegMostras;
	private int tipoFile;
	
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
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
	public String getpHorai() {
		return pHorai;
	}
	public void setpHorai(String pHorai) {
		this.pHorai = pHorai;
	}
	public String getpHoraf() {
		return pHoraf;
	}
	public void setpHoraf(String pHoraf) {
		this.pHoraf = pHoraf;
	}
	public Integer getpNuPagina() {
		return pNuPagina;
	}
	public void setpNuPagina(Integer pNuPagina) {
		this.pNuPagina = pNuPagina;
	}
	public Integer getpNuRegMostras() {
		return pNuRegMostras;
	}
	public void setpNuRegMostras(Integer pNuRegMostras) {
		this.pNuRegMostras = pNuRegMostras;
	}
}
