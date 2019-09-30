package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;

public class ListarInstanciaxIdClienteResponse extends ResponseBase  {
	
	private List<ListarInstanciaxIdClienteRequest> listarInstanciaxIdcliente;

	public List<ListarInstanciaxIdClienteRequest> getListarInstanciaxIdcliente() {
		return listarInstanciaxIdcliente;
	}

	public void setListarInstanciaxIdcliente(
			List<ListarInstanciaxIdClienteRequest> listarInstanciaxIdcliente) {
		this.listarInstanciaxIdcliente = listarInstanciaxIdcliente;
	}

	



}
