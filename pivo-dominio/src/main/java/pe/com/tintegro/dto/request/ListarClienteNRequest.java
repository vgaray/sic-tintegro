package pe.com.tintegro.dto.request;


public class ListarClienteNRequest extends RequestBase{
	
	private Integer pIdCliente;
	private String pNoRazon;
	private String pNudocide;
	private boolean pEstado;
	private Integer pNuPagina;
	private Integer pNuRegMostras;
	
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
	public Integer getpIdCliente() {
		return pIdCliente;
	}
	public void setpIdCliente(Integer pIdCliente) {
		this.pIdCliente = pIdCliente;
	}
	public String getpNoRazon() {
		return pNoRazon;
	}
	public void setpNoRazon(String pNoRazon) {
		this.pNoRazon = pNoRazon;
	}
	public String getpNudocide() {
		return pNudocide;
	}
	public void setpNudocide(String pNudocide) {
		this.pNudocide = pNudocide;
	}

	public boolean ispEstado() {
		return pEstado;
	}
	public void setpEstado(boolean pEstado) {
		this.pEstado = pEstado;
	}

}
