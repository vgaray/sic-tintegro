package pe.com.tintegro.dto.request;

public class ClienteActualizarRequest extends RequestBase{
	
	private String telef;
	private String correoEle;
	private String personRef;
	private boolean estado;
	private Integer confirmacion;
	private Integer estadoAc;//1:ACTIVADO----0:DESACTIVADO
	private Integer resultado;
	private Integer idCliente;
	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}
	public String getCorreoEle() {
		return correoEle;
	}
	public void setCorreoEle(String correoEle) {
		this.correoEle = correoEle;
	}
	public String getPersonRef() {
		return personRef;
	}
	public void setPersonRef(String personRef) {
		this.personRef = personRef;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Integer getConfirmacion() {
		return confirmacion;
	}
	public void setConfirmacion(Integer confirmacion) {
		this.confirmacion = confirmacion;
	}
	public Integer getEstadoAc() {
		return estadoAc;
	}
	public void setEstadoAc(Integer estadoAc) {
		this.estadoAc = estadoAc;
	}
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNoRazonSocial() {
		return noRazonSocial;
	}
	public void setNoRazonSocial(String noRazonSocial) {
		this.noRazonSocial = noRazonSocial;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDirecc() {
		return direcc;
	}
	public void setDirecc(String direcc) {
		this.direcc = direcc;
	}
	private String noRazonSocial;
	private String ruc;
	private String direcc;
	

}
