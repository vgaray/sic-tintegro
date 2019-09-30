package pe.com.tintegro.dto.request;

public class ListaReporteAbandonosRequest extends RequestBase{

	private String noQueue;
	private String feIniCon;
	private String feFinCon;
	//variables paginacion
	//Indica # de paginas
	private Integer pNuPagina;
	//Indica # pagina donde estamos
	private Integer pNuReg;
	
	private int tipoFile;

	public String getNoQueue() {
		return noQueue;
	}
	public void setNoQueue(String noQueue) {
		this.noQueue = noQueue;
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
	//Paginacion
	public Integer getpNuPagina() {
		return pNuPagina;
	}
	public void setpNuPagina(Integer pNuPagina) {
		this.pNuPagina = pNuPagina;
	}
	public Integer getpNuReg() {
		return pNuReg;
	}
	public void setpNuReg(Integer pNuReg) {
		this.pNuReg = pNuReg;
	}
	public int getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
	}
	
}
