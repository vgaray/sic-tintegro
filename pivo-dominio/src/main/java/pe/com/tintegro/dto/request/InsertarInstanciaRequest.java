package pe.com.tintegro.dto.request;

public class InsertarInstanciaRequest extends RequestBase{

	
	private Integer idInstancia;
	private String ipRed;
	private Integer nroVLan;
	private String ipMedian;
	private String mascara;
	private String ipRouter;
	private String dns1;
	private String dns2;
	private String subnet;
	private String broadcast;
	private String ipAsterisk;
	private Integer puertoAsteriskBashCertificadoExt;
	//temporal
	private String ipAsteriskBash;
	private Integer idCliente;
	
	
	public Integer getIdInstancia() {
		return idInstancia;
	}
	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}
	public String getIpRed() {
		return ipRed;
	}
	public void setIpRed(String ipRed) {
		this.ipRed = ipRed;
	}
	public Integer getNroVLan() {
		return nroVLan;
	}
	public void setNroVLan(Integer nroVLan) {
		this.nroVLan = nroVLan;
	}
	public String getIpMedian() {
		return ipMedian;
	}
	public void setIpMedian(String ipMedian) {
		this.ipMedian = ipMedian;
	}
	public String getMascara() {
		return mascara;
	}
	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	public String getIpRouter() {
		return ipRouter;
	}
	public void setIpRouter(String ipRouter) {
		this.ipRouter = ipRouter;
	}
	public String getDns1() {
		return dns1;
	}
	public void setDns1(String dns1) {
		this.dns1 = dns1;
	}
	public String getDns2() {
		return dns2;
	}
	public void setDns2(String dns2) {
		this.dns2 = dns2;
	}
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public String getBroadcast() {
		return broadcast;
	}
	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}
	public String getIpAsterisk() {
		return ipAsterisk;
	}
	public void setIpAsterisk(String ipAsterisk) {
		this.ipAsterisk = ipAsterisk;
	}
	public Integer getPuertoAsteriskBashCertificadoExt() {
		return puertoAsteriskBashCertificadoExt;
	}
	public void setPuertoAsteriskBashCertificadoExt(
			Integer puertoAsteriskBashCertificadoExt) {
		this.puertoAsteriskBashCertificadoExt = puertoAsteriskBashCertificadoExt;
	}
	public String getIpAsteriskBash() {
		return ipAsteriskBash;
	}
	public void setIpAsteriskBash(String ipAsteriskBash) {
		this.ipAsteriskBash = ipAsteriskBash;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	
}
