package pe.com.tintegro.dto.request;

public class ListarInstanciaxCasoRequest extends RequestBase{
	
	
	private Integer idCliente;
	private Integer valor;
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	private Integer estadoE;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	private Integer ocupadoE;
	
	public Integer getEstadoE() {
		return estadoE;
	}
	public void setEstadoE(Integer estadoE) {
		this.estadoE = estadoE;
	}
	public Integer getOcupadoE() {
		return ocupadoE;
	}
	public void setOcupadoE(Integer ocupadoE) {
		this.ocupadoE = ocupadoE;
	}
	
	
}
