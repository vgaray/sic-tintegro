/**
 * 
 */
package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.TipoDetallePedido;

/**
 * @author FReyes
 *
 */
public class ListarTipoDetallePedidoResponse extends ResponseBase
{
	private List<TipoDetallePedido> listTipoDetallePedido;

	public List<TipoDetallePedido> getListTipoDetallePedido() {
		return listTipoDetallePedido;
	}

	public void setListTipoDetallePedido(
			List<TipoDetallePedido> listTipoDetallePedido) {
		this.listTipoDetallePedido = listTipoDetallePedido;
	}
	
}
