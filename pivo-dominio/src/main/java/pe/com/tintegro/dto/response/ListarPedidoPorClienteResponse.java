/**
 * 
 */
package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Pedido;

/**
 * @author FReyes
 *
 */
public class ListarPedidoPorClienteResponse extends ResponseBase{
	
	private List <Pedido> pedidoPorClienteList;

	public List<Pedido> getPedidoPorClienteList() {
		return pedidoPorClienteList;
	}

	public void setPedidoPorClienteList(List<Pedido> pedidoPorClienteList) {
		this.pedidoPorClienteList = pedidoPorClienteList;
	}
}
