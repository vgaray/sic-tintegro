package pe.com.tintegro.dto.request;

public class ListaLlamadasContestadasRequest extends RequestBase{
	
	private String  vaQueue;
	private Integer idAgente;
	private String  feIniCon;
	private String  feFinCon;
	private String  horaIniC;
	private String  horaFinC;
	//variables paginacion
	//Indica # de paginas
	private Integer pNuPagina;
	//Indica # pagina donde estamos
	private Integer pNuReg;
	
	private int tipoFile;
	
	public String getVaQueue() {
		return vaQueue;
	}
	public void setVaQueue(String vaQueue) {
		this.vaQueue = vaQueue;
	}
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
	public String getHoraIniC() {
		return horaIniC;
	}
	public void setHoraIniC(String horaIniC) {
		this.horaIniC = horaIniC;
	}
	public String getHoraFinC() {
		return horaFinC;
	}
	public void setHoraFinC(String horaFinC) {
		this.horaFinC = horaFinC;
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
