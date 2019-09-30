package pe.com.tintegro.dto.response;

public class EvaluarInstanciaResponse extends ResponseBase {
	private Integer cantidad;
	private String idInstancia;
	private Integer tipoRol;
	public Integer getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(Integer tipoRol) {
		this.tipoRol = tipoRol;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}

}
