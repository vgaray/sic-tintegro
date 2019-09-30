package pe.com.tintegro.dominio;

public class LlamadaAgente {
	private Integer idAgente;
	private String noAgente;
	private Integer llamadasAtendidas;
	private Integer llamadasCulCli;
	private Integer llamadasCulAge;
	private String tiempoHablado;
	private String tPromHablado;
	private String tMinHablado;
	private String tMaxHablado;
	private String fechaHora;

	
	
	public Integer getIdAgente() {
		return idAgente;
	}
	public void setIdAgente(Integer idAgente) {
		this.idAgente = idAgente;
	}
	public String getNoAgente() {
		return noAgente;
	}
	public void setNoAgente(String noAgente) {
		this.noAgente = noAgente;
	}
	public Integer getLlamadasAtendidas() {
		return llamadasAtendidas;
	}
	public void setLlamadasAtendidas(Integer llamadasAtendidas) {
		this.llamadasAtendidas = llamadasAtendidas;
	}
	public Integer getLlamadasCulCli() {
		return llamadasCulCli;
	}
	public void setLlamadasCulCli(Integer llamadasCulCli) {
		this.llamadasCulCli = llamadasCulCli;
	}
	public Integer getLlamadasCulAge() {
		return llamadasCulAge;
	}
	public void setLlamadasCulAge(Integer llamadasCulAge) {
		this.llamadasCulAge = llamadasCulAge;
	}
	public String getTiempoHablado() {
		return tiempoHablado;
	}
	public void setTiempoHablado(String tiempoHablado) {
		this.tiempoHablado = tiempoHablado;
	}
	public String gettPromHablado() {
		return tPromHablado;
	}
	public void settPromHablado(String tPromHablado) {
		this.tPromHablado = tPromHablado;
	}
	public String gettMinHablado() {
		return tMinHablado;
	}
	public void settMinHablado(String tMinHablado) {
		this.tMinHablado = tMinHablado;
	}
	public String gettMaxHablado() {
		return tMaxHablado;
	}
	public void settMaxHablado(String tMaxHablado) {
		this.tMaxHablado = tMaxHablado;
	}	

	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
}
