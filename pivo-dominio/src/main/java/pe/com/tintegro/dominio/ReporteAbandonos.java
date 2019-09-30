package pe.com.tintegro.dominio;

public class ReporteAbandonos {
	
	private String   uniqueId;
	private String   queueName;
	private String   fecha;
	private String   qTime;
	private Integer  info3;
	private Integer  nuMin;
	private String   numero;
	private Integer nuTotalReg;
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getQueueName() {
		return queueName;
	}
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getqTime() {
		return qTime;
	}
	public void setqTime(String qTime) {
		this.qTime = qTime;
	}
	public Integer getInfo3() {
		return info3;
	}
	public void setInfo3(Integer info3) {
		this.info3 = info3;
	}
	public Integer getNuMin() {
		return nuMin;
	}
	public void setNuMin(Integer nuMin) {
		this.nuMin = nuMin;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getNuTotalReg() {
		return nuTotalReg;
	}
	public void setNuTotalReg(Integer nuTotalReg) {
		this.nuTotalReg = nuTotalReg;
	}
}
