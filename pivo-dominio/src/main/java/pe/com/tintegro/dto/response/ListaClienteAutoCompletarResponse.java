package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Cliente;

public class ListaClienteAutoCompletarResponse extends ResponseBase
{
	private List<Cliente> listaCliente;

	public List<Cliente> getListaCliente()
	{
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente)
	{
		this.listaCliente = listaCliente;
	}

}
