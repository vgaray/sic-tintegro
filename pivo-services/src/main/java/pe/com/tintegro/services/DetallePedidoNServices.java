package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;

public interface DetallePedidoNServices {
public ListarDetallePedidoNResponse listardetallepedido(ListarDetallePedidoNRequest request) throws Exception;
}
