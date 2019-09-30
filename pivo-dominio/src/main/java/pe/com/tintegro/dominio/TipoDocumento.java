package pe.com.tintegro.dominio;

import java.io.Serializable;

public class TipoDocumento implements Serializable{
	private static final long serialVersionUID = -1235800176805108313L;
	
	private Integer idTipodoc;
	private String 	noTipo;
	public Integer getIdTipodoc() {
		return idTipodoc;
	}
	public void setIdTipodoc(Integer idTipodoc) {
		this.idTipodoc = idTipodoc;
	}
	public String getNoTipo() {
		return noTipo;
	}
	public void setNoTipo(String noTipo) {
		this.noTipo = noTipo;
	}
}
