package pe.com.tintegro.dto.request;

public class AsignarInstanciaRequest extends RequestBase{
	
	private Integer idCliente;
	private Integer idInstancia;
	private Integer valor;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdInstancia() {
		return idInstancia;
	}
	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
