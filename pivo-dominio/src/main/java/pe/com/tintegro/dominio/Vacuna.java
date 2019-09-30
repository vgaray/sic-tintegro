package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.sql.Date;

public class Vacuna implements Serializable{

	private static final long serialVersionUID = 221352024320378295L;
	private Integer idVacuna;
	private String noNombre;
	private String noDescripcion;
	private Integer idTipoVacuna;
	private String noTipoVacuna;
	private Date feRegistro;
	private Date feAplicado;
	private Boolean ilAplicado;
	private Integer idHistoriaClinica;
	
	public Integer getIdVacuna() {
		return idVacuna;
	}
	public void setIdVacuna(Integer idVacuna) {
		this.idVacuna = idVacuna;
	}
	public String getNoNombre() {
		return noNombre;
	}
	public void setNoNombre(String noNombre) {
		this.noNombre = noNombre;
	}
	public String getNoDescripcion() {
		return noDescripcion;
	}
	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}
	public Integer getIdTipoVacuna() {
		return idTipoVacuna;
	}
	public void setIdTipoVacuna(Integer idTipoVacuna) {
		this.idTipoVacuna = idTipoVacuna;
	}
	public String getNoTipoVacuna() {
		return noTipoVacuna;
	}
	public void setNoTipoVacuna(String noTipoVacuna) {
		this.noTipoVacuna = noTipoVacuna;
	}
	public Date getFeRegistro() {
		return feRegistro;
	}
	public void setFeRegistro(Date feRegistro) {
		this.feRegistro = feRegistro;
	}
	public Date getFeAplicado() {
		return feAplicado;
	}
	public void setFeAplicado(Date feAplicado) {
		this.feAplicado = feAplicado;
	}
	public Boolean getIlAplicado() {
		return ilAplicado;
	}
	public void setIlAplicado(Boolean ilAplicado) {
		this.ilAplicado = ilAplicado;
	}
	public Integer getIdHistoriaClinica() {
		return idHistoriaClinica;
	}
	public void setIdHistoriaClinica(Integer idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}
	@Override
	public String toString() {
		return "Vacuna [idVacuna=" + idVacuna + ", noNombre=" + noNombre + ", noDescripcion=" + noDescripcion
				+ ", idTipoVacuna=" + idTipoVacuna + ", noTipoVacuna=" + noTipoVacuna + ", feRegistro=" + feRegistro
				+ ", feAplicado=" + feAplicado + ", ilAplicado=" + ilAplicado + ", idHistoriaClinica="
				+ idHistoriaClinica + "]";
	}
	
}
