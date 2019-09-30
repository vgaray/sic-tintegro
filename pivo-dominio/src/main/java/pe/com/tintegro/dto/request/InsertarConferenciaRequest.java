package pe.com.tintegro.dto.request;

public class InsertarConferenciaRequest extends RequestBase{
	
	private String noConferencia;
	private String nuConferencia;
	private String pwdAdmin;
	private String pwdUsuario;
	private String noRutBie; //Ruta de Bienvenida;
	private Integer nuMaxUsuario;
	private String noVarAdmin;
	private String noVarUsuario;
	private String noRutHol; //Ruta Musica en espera;
	private String fecha;
	
	public String getNoConferencia() {
		return noConferencia;
	}
	public void setNoConferencia(String noConferencia) {
		this.noConferencia = noConferencia;
	}
	public String getNuConferencia() {
		return nuConferencia;
	}
	public void setNuConferencia(String nuConferencia) {
		this.nuConferencia = nuConferencia;
	}
	public String getPwdAdmin() {
		return pwdAdmin;
	}
	public void setPwdAdmin(String pwdAdmin) {
		this.pwdAdmin = pwdAdmin;
	}
	public String getPwdUsuario() {
		return pwdUsuario;
	}
	public void setPwdUsuario(String pwdUsuario) {
		this.pwdUsuario = pwdUsuario;
	}
	public String getNoRutBie() {
		return noRutBie;
	}
	public void setNoRutBie(String noRutBie) {
		this.noRutBie = noRutBie;
	}
	public Integer getNuMaxUsuario() {
		return nuMaxUsuario;
	}
	public void setNuMaxUsuario(Integer nuMaxUsuario) {
		this.nuMaxUsuario = nuMaxUsuario;
	}
	public String getNoVarAdmin() {
		return noVarAdmin;
	}
	public void setNoVarAdmin(String noVarAdmin) {
		this.noVarAdmin = noVarAdmin;
	}
	public String getNoVarUsuario() {
		return noVarUsuario;
	}
	public void setNoVarUsuario(String noVarUsuario) {
		this.noVarUsuario = noVarUsuario;
	}
	public String getNoRutHol() {
		return noRutHol;
	}
	public void setNoRutHol(String noRutHol) {
		this.noRutHol = noRutHol;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
