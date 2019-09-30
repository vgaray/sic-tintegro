/**
 * 
 */
package pe.com.tintegro.dto.request;

/**
 * @author FReyes
 *
 */
public class ListarPedidoPorClienteRequest extends RequestBase {

	private Integer idCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
}
