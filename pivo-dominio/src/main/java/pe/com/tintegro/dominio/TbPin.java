package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TbPin implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private int idClave;
	private int idTipotelefono;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdClave() {
		return idClave;
	}
	public void setIdClave(int idClave) {
		this.idClave = idClave;
	}
	public int getIdTipotelefono() {
		return idTipotelefono;
	}
	public void setIdTipotelefono(int idTipotelefono) {
		this.idTipotelefono = idTipotelefono;
	}
	
	
	

}
