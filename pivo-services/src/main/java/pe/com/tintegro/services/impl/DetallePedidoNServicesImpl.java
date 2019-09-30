package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.DetallePedidoNDAO;
import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;
import pe.com.tintegro.services.DetallePedidoNServices;

@Service("detallePedidoNServices")
@Transactional
public class DetallePedidoNServicesImpl implements DetallePedidoNServices {
	@Resource(name = "detallePedidoNDAO")
	protected DetallePedidoNDAO detallepedidoDAO;

	@Override
	public ListarDetallePedidoNResponse listardetallepedido(ListarDetallePedidoNRequest request) throws Exception {
		ListarDetallePedidoNResponse response = new ListarDetallePedidoNResponse();
		response = detallepedidoDAO.listadetallepedido(request);
		return response;
	}
}