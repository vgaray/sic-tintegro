package pe.com.tintegro.dto.request;

public class ListarLlamadasAtendidasAbandonadasRequest extends RequestBase{

	private String cola;
	private Integer agente;
	private String feIni;
	private String feFin;
	
	//Para la paginación
	private Integer nuPagina;	  //Número de página actual.
	private Integer nuRegisMostrar; //Cantidad de registros por página
	
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
	public Integer getAgente() {
		return agente;
	}
	public void setAgente(Integer agente) {
		this.agente = agente;
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
	public Integer getNuPagina() {
		return nuPagina;
	}
	public void setNuPagina(Integer nuPagina) {
		this.nuPagina = nuPagina;
	}
	public Integer getNuRegisMostrar() {
		return nuRegisMostrar;
	}
	public void setNuRegisMostras(Integer nuRegisMostras) {
		this.nuRegisMostrar = nuRegisMostras;
	}
	
}
