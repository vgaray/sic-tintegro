package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnvioMail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> destinatario;
	private String passRemitente;
	private String remitente;
	private String asunto;
	private String contenido;
	private String seudonimo;
	private List<Document> lsDocumentos;
	
	public String getPassRemitente() {
		return passRemitente;
	}

	public void setPassRemitente(String passRemitente) {
		this.passRemitente = passRemitente;
	}

	public ArrayList<String> getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(ArrayList<String> destinatario) {
		this.destinatario = destinatario;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getSeudonimo() {
		return seudonimo;
	}

	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}

	public List<Document> getLsDocumentos() {
		return lsDocumentos;
	}

	public void setLsDocumentos(List<Document> lsDocumentos) {
		this.lsDocumentos = lsDocumentos;
	}

}
