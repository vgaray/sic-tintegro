package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;

public interface PedidoPorClienteService
{
	
	public ListaPedidoPorClienteResponse listaPedidoxCliente(String codUsuario,ListaPedidoPorClienteRequest obj)throws Exception;

}
