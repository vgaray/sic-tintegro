package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TipoDetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String noDescripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoDescripcion() {
		return noDescripcion;
	}

	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}
}
