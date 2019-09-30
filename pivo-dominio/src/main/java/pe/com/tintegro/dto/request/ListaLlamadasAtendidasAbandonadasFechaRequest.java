package pe.com.tintegro.dto.request;

public class ListaLlamadasAtendidasAbandonadasFechaRequest extends RequestBase{
	
	private String pQueuename;
	private String pFeIni;
	private String pFeFin;
	//variables paginacion
	//Indica # de paginas
	private Integer pNuPagina;
	//Indica # pagina donde estamos
	private Integer pNuReg;
	
	private int tipoFile;
	
	public String getpQueuename() {
		return pQueuename;
	}
	public void setpQueuename(String pQueuename) {
		this.pQueuename = pQueuename;
	}
	public String getpFeIni() {
		return pFeIni;
	}
	public void setpFeIni(String pFeIni) {
		this.pFeIni = pFeIni;
	}
	public String getpFeFin() {
		return pFeFin;
	}
	public void setpFeFin(String pFeFin) {
		this.pFeFin = pFeFin;
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
