package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Cliente;

public class ListaClienteResponse extends ResponseBase 
{
	
	private List<Cliente> listarClientes;

	public List<Cliente> getListarClientes() {
		return listarClientes;
	}

	public void setListarClientes(List<Cliente> listarClientes) {
		this.listarClientes = listarClientes;
	}

}
