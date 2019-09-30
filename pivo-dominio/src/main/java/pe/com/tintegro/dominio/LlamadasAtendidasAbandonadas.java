package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LlamadasAtendidasAbandonadas implements Serializable{

	private static final long serialVersionUID = -6931197690208027053L;
 	private Integer idQueueName;
	private String noQueueName;
	private String noAgente;
	private String data5;
	private Integer contestadas;
	private String prEspera;
	private String prConversa;
	private Integer nuTotalReg;
	
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
	public String getNoAgente() {
		return noAgente;
	}
	public void setNoAgente(String noAgente) {
		this.noAgente = noAgente;
	}
	public String getData5() {
		return data5;
	}
	public void setData5(String data5) {
		this.data5 = data5;
	}
	public Integer getContestadas() {
		return contestadas;
	}
	public void setContestadas(Integer contestadas) {
		this.contestadas = contestadas;
	}
	public String getPrEspera() {
		return prEspera;
	}
	public void setPrEspera(String prEspera) {
		this.prEspera = prEspera;
	}
	public String getPrConversa() {
		return prConversa;
	}
	public void setPrConversa(String prConversa) {
		this.prConversa = prConversa;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
