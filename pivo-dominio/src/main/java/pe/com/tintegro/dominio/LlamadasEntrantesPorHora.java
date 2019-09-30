package pe.com.tintegro.dominio;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LlamadasEntrantesPorHora implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idQueueName;
	private String noQueueName;
	private Integer mes;
	private Integer anio;
	private String hora;
	private Integer entrante;
	private Integer atendido;
	private Integer abandono;
	
	public Integer getIdQueueName() {
		return idQueueName;
	}
	public void setIdQueueName(Integer idQueueName) {
		this.idQueueName = idQueueName;
	}
	public String getNoQueueName() {
		return noQueueName;
	}
	public void setNoQueueName(String noQueueName) {
		this.noQueueName = noQueueName;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getEntrante() {
		return entrante;
	}
	public void setEntrante(Integer entrante) {
		this.entrante = entrante;
	}
	public Integer getAtendido() {
		return atendido;
	}
	public void setAtendido(Integer atendido) {
		this.atendido = atendido;
	}
	public Integer getAbandono() {
		return abandono;
	}
	public void setAbandono(Integer abandono) {
		this.abandono = abandono;
	}
}
