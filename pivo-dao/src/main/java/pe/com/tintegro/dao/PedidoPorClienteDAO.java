package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.request.ListaPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;
import pe.com.tintegro.dto.response.ListaPedidoPorClienteResponse;

public interface PedidoPorClienteDAO {
	public InsertarPedidoPorClienteResponse insertaPedidoPorCliente(InsertarPedidoPorClienteRequest request) throws Exception;

	public ListaPedidoPorClienteResponse listaPedidoxCliente(ListaPedidoPorClienteRequest obj) throws Exception;

}
