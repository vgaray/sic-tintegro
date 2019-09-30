package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pe.com.tintegro.dominio.DetallePedidoN;

public interface DetallePedidoNMapper {
	public List<DetallePedidoN> listardetallepedidoN(@Param("p_id_cliente") Integer IdCliente);
}
