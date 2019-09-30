package pe.com.tintegro.dominio;

import java.io.Serializable;

public class MailContent implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean hasTemplate;
	private String usuario;
	private Integer tipoMensaje;
	private Integer tipoFirma;
	private String link;
	public boolean isHasTemplate() {
		return hasTemplate;
	}
	public void setHasTemplate(boolean hasTemplate) {
		this.hasTemplate = hasTemplate;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getTipoMensaje() {
		return tipoMensaje;
	}
	public void setTipoMensaje(Integer tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public Integer getTipoFirma() {
		return tipoFirma;
	}
	public void setTipoFirma(Integer tipoFirma) {
		this.tipoFirma = tipoFirma;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
