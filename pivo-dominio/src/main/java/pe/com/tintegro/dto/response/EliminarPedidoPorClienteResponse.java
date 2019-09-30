/**
 * 
 */
package pe.com.tintegro.dto.response;

/**
 * @author FReyes
 *
 */
public class EliminarPedidoPorClienteResponse extends ResponseBase{
	private Integer insertado;

	public Integer getInsertado() {
		return insertado;
	}

	public void setInsertado(Integer insertado) {
		this.insertado = insertado;
	}
}
