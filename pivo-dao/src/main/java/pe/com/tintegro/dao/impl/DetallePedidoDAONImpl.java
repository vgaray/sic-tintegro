package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.DetallePedidoNDAO;
import pe.com.tintegro.dominio.DetallePedidoN;
import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;
import pe.com.tintegro.mapper.DetallePedidoNMapper;

;

@Repository("detallePedidoNDAO")
public class DetallePedidoDAONImpl extends DAOTintegroImpl implements DetallePedidoNDAO {

	@Override
	public ListarDetallePedidoNResponse listadetallepedido(ListarDetallePedidoNRequest request) throws Exception {
		List<DetallePedidoN> result = new ArrayList<DetallePedidoN>();
		ListarDetallePedidoNResponse response = new ListarDetallePedidoNResponse();
		DetallePedidoNMapper mapper = this.getSqlSessionSic().getMapper(DetallePedidoNMapper.class);
		System.out.println(request.getIdCliente());
		result = (List<DetallePedidoN>) mapper.listardetallepedidoN(request.getIdCliente());
		// response.setEstado(1);
		response.setLsdetaped(result);
		return response;
	}

}
