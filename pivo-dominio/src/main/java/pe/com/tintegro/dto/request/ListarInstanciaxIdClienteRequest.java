package pe.com.tintegro.dto.request;

public class ListarInstanciaxIdClienteRequest extends RequestBase{
	
	//mybatis
	private Integer idCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
