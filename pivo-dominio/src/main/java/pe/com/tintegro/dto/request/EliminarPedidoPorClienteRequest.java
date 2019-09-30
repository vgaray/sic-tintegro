/**
 * 
 */
package pe.com.tintegro.dto.request;

/**
 * @author FReyes
 *
 */
public class EliminarPedidoPorClienteRequest extends RequestBase{
	private Integer idPedido;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
}
