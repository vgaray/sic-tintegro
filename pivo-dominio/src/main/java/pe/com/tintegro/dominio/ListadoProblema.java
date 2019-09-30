package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.sql.Date;

public class ListadoProblema implements Serializable {

	private static final long serialVersionUID = 7276650635939281896L;
	private Integer idListadoProblema;
	private String noProblema;
	private String noDescripcion;
	private Integer idTipoProblema;
	private String noTipoProblema;
	private Date feRegistro;
	private Integer idHistoriaClinica;

	public Integer getIdListadoProblema() {
		return idListadoProblema;
	}

	public void setIdListadoProblema(Integer idListadoProblema) {
		this.idListadoProblema = idListadoProblema;
	}

	public String getNoProblema() {
		return noProblema;
	}

	public void setNoProblema(String noProblema) {
		this.noProblema = noProblema;
	}

	public String getNoDescripcion() {
		return noDescripcion;
	}

	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}

	public Integer getIdTipoProblema() {
		return idTipoProblema;
	}

	public void setIdTipoProblema(Integer idTipoProblema) {
		this.idTipoProblema = idTipoProblema;
	}

	public String getNoTipoProblema() {
		return noTipoProblema;
	}

	public void setNoTipoProblema(String noTipoProblema) {
		this.noTipoProblema = noTipoProblema;
	}

	public Date getFeRegistro() {
		return feRegistro;
	}

	public void setFeRegistro(Date feRegistro) {
		this.feRegistro = feRegistro;
	}

	public Integer getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

	public void setIdHistoriaClinica(Integer idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}

	@Override
	public String toString() {
		return "ListadoProblema [idListadoProblema=" + idListadoProblema + ", noProblema=" + noProblema
				+ ", noDescripcion=" + noDescripcion + ", idTipoProblema=" + idTipoProblema + ", noTipoProblema="
				+ noTipoProblema + ", feRegistro=" + feRegistro + ", idHistoriaClinica=" + idHistoriaClinica + "]";
	}
	
}
