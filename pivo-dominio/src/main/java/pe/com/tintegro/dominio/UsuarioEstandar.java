package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.sql.Date;

public class UsuarioEstandar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8352955874288332566L;
	private Integer idUsuario;
	private String noLogin;
	private String noPasswo;
	private String noNombre;
	private String noApellido;
	private String email;
	private String noProfe;
	private boolean ilActivo;
	private Date feCreacion;
	private boolean ilAccountNonWExpired;
	private boolean ilCredentialNonExpired;
	private boolean ilAccountNonLocked;
	private String noRol;
	private Integer idRol;
	private Integer idInstancia;
	private String idInstanciaEncryp;
	private String noInstancia;
	private Integer idCliente;
	private String noCliente;
	private Integer idTipoRol;
	private String noNewPassword;
	private String noToken;
	private Integer result;
	private String mensaje;
	private Integer idTipoDocumento;
	private String nuDocumento;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNoLogin() {
		return noLogin;
	}
	public void setNoLogin(String noLogin) {
		this.noLogin = noLogin;
	}
	public String getNoPasswo() {
		return noPasswo;
	}
	public void setNoPasswo(String noPasswo) {
		this.noPasswo = noPasswo;
	}
	public String getNoNombre() {
		return noNombre;
	}
	public void setNoNombre(String noNombre) {
		this.noNombre = noNombre;
	}
	public String getNoApellido() {
		return noApellido;
	}
	public void setNoApellido(String noApellido) {
		this.noApellido = noApellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoProfe() {
		return noProfe;
	}
	public void setNoProfe(String noProfe) {
		this.noProfe = noProfe;
	}
	public boolean isIlActivo() {
		return ilActivo;
	}
	public void setIlActivo(boolean ilActivo) {
		this.ilActivo = ilActivo;
	}
	public Date getFeCreacion() {
		return feCreacion;
	}
	public void setFeCreacion(Date feCreacion) {
		this.feCreacion = feCreacion;
	}
	public boolean isIlAccountNonWExpired() {
		return ilAccountNonWExpired;
	}
	public void setIlAccountNonWExpired(boolean ilAccountNonWExpired) {
		this.ilAccountNonWExpired = ilAccountNonWExpired;
	}
	public boolean isIlCredentialNonExpired() {
		return ilCredentialNonExpired;
	}
	public void setIlCredentialNonExpired(boolean ilCredentialNonExpired) {
		this.ilCredentialNonExpired = ilCredentialNonExpired;
	}
	public boolean isIlAccountNonLocked() {
		return ilAccountNonLocked;
	}
	public void setIlAccountNonLocked(boolean ilAccountNonLocked) {
		this.ilAccountNonLocked = ilAccountNonLocked;
	}
	public String getNoRol() {
		return noRol;
	}
	public void setNoRol(String noRol) {
		this.noRol = noRol;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Integer getIdInstancia() {
		return idInstancia;
	}
	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}
	public String getIdInstanciaEncryp() {
		return idInstanciaEncryp;
	}
	public void setIdInstanciaEncryp(String idInstanciaEncryp) {
		this.idInstanciaEncryp = idInstanciaEncryp;
	}
	public String getNoInstancia() {
		return noInstancia;
	}
	public void setNoInstancia(String noInstancia) {
		this.noInstancia = noInstancia;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNoCliente() {
		return noCliente;
	}
	public void setNoCliente(String noCliente) {
		this.noCliente = noCliente;
	}
	public Integer getIdTipoRol() {
		return idTipoRol;
	}
	public void setIdTipoRol(Integer idTipoRol) {
		this.idTipoRol = idTipoRol;
	}
	public String getNoNewPassword() {
		return noNewPassword;
	}
	public void setNoNewPassword(String noNewPassword) {
		this.noNewPassword = noNewPassword;
	}
	public String getNoToken() {
		return noToken;
	}
	public void setNoToken(String noToken) {
		this.noToken = noToken;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNuDocumento() {
		return nuDocumento;
	}
	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}
	
}
