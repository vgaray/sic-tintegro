package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LlamadasAtendidasAbandonadasFechas implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046712227227172286L;
	/**
	 * 
	 */
	
	private Integer idLlamada;
	private String fecha;
	private String atendidas;
	private String abandonadasMenor;
	private String abandonadasMayor;
	private Integer nuTotalReg;
	//
	private String queueName;
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
	public Integer getIdLlamada() {
		return idLlamada;
	}
	public void setIdLlamada(Integer idLlamada) {
		this.idLlamada = idLlamada;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getAtendidas() {
		return atendidas;
	}
	public void setAtendidas(String atendidas) {
		this.atendidas = atendidas;
	}
	public String getAbandonadasMenor() {
		return abandonadasMenor;
	}
	public void setAbandonadasMenor(String abandonadasMenor) {
		this.abandonadasMenor = abandonadasMenor;
	}
	public String getAbandonadasMayor() {
		return abandonadasMayor;
	}
	public void setAbandonadasMayor(String abandonadasMayor) {
		this.abandonadasMayor = abandonadasMayor;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	
}
