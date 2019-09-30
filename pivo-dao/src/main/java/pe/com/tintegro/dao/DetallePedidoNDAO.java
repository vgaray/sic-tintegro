package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;

public interface DetallePedidoNDAO {

public ListarDetallePedidoNResponse listadetallepedido(ListarDetallePedidoNRequest request) throws Exception;
}
