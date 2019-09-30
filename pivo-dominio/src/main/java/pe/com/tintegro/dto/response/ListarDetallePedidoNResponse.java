package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.DetallePedidoN;

public class ListarDetallePedidoNResponse extends ResponseBase{
private List<DetallePedidoN> lsdetaped;

public List<DetallePedidoN> getLsdetaped() {
	return lsdetaped;
}

public void setLsdetaped(List<DetallePedidoN> lsdetaped) {
	this.lsdetaped = lsdetaped;
}
}
