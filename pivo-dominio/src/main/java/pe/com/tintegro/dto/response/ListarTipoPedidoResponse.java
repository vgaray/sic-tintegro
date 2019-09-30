/**
 * 
 */
package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.TipoPedido;

/**
 * @author FReyes
 *
 */
public class ListarTipoPedidoResponse extends ResponseBase 
{
	private List<TipoPedido> listTipoPedido;

	public List<TipoPedido> getListTipoPedido() {
		return listTipoPedido;
	}

	public void setListTipoPedido(List<TipoPedido> listTipoPedido) {
		this.listTipoPedido = listTipoPedido;
	}
	
	
}
