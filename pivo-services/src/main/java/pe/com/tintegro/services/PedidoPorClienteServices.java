package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.InsertarPedidoPorClienteRequest;
import pe.com.tintegro.dto.response.InsertarPedidoPorClienteResponse;

public interface PedidoPorClienteServices
{
    public InsertarPedidoPorClienteResponse insertarPedidoxCliente(String codUsuario, InsertarPedidoPorClienteRequest request) throws Exception;
}
