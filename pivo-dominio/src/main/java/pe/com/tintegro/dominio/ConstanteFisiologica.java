package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class ConstanteFisiologica implements Serializable {

	private static final long serialVersionUID = -5408741576992791463L;
	private Integer idConstanteFisiologica;
	private BigDecimal peso;
	private BigDecimal pulso;
	private BigDecimal temperatura;
	private Date feRegistro;
	private Integer idHistoriaClinica;
	private Integer idUnidad;

	public Integer getIdConstanteFisiologica() {
		return idConstanteFisiologica;
	}

	public void setIdConstanteFisiologica(Integer idConstanteFisiologica) {
		this.idConstanteFisiologica = idConstanteFisiologica;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getPulso() {
		return pulso;
	}

	public void setPulso(BigDecimal pulso) {
		this.pulso = pulso;
	}

	public BigDecimal getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
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

	public Integer getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	@Override
	public String toString() {
		return "ConstanteFisiologica [idConstanteFisiologica=" + idConstanteFisiologica + ", peso=" + peso + ", pulso="
				+ pulso + ", temperatura=" + temperatura + ", feRegistro=" + feRegistro + ", idHistoriaClinica="
				+ idHistoriaClinica + ", idUnidad=" + idUnidad + "]";
	}
	
}
