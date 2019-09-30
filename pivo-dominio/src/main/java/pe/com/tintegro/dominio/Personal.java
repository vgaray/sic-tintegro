package pe.com.tintegro.dominio;

import java.io.Serializable;

public class Personal implements Serializable{
	private static final long serialVersionUID = 1546133420015445455L;
	
	private String idPersonal;
	private String noPersonal;
	private String noApePat;
	private String noApeMat;
	private String noAbreviatura;
	private String nuDocumento;
	private String noDireccion;
	private String nuTelefono;
	private String nuCelular;
	private String noCorreo;
	private String nuCmvp;
	private String noGrupoOcupacional;
	private String noTipoProfesional;
	private String noEstado;
	private Integer idTipoDocumento;
	private Integer idGrupoOcupacional;
	private Boolean ilActivo;
	private Integer caProfesional;
	private Integer caNoProfesional;
	
	public String getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}
	public String getNoPersonal() {
		return noPersonal;
	}
	public void setNoPersonal(String noPersonal) {
		this.noPersonal = noPersonal;
	}
	public String getNoApePat() {
		return noApePat;
	}
	public void setNoApePat(String noApePat) {
		this.noApePat = noApePat;
	}
	public String getNoApeMat() {
		return noApeMat;
	}
	public void setNoApeMat(String noApeMat) {
		this.noApeMat = noApeMat;
	}
	public String getNoAbreviatura() {
		return noAbreviatura;
	}
	public void setNoAbreviatura(String noAbreviatura) {
		this.noAbreviatura = noAbreviatura;
	}
	public String getNuDocumento() {
		return nuDocumento;
	}
	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}
	public String getNoDireccion() {
		return noDireccion;
	}
	public void setNoDireccion(String noDireccion) {
		this.noDireccion = noDireccion;
	}
	public String getNuTelefono() {
		return nuTelefono;
	}
	public void setNuTelefono(String nuTelefono) {
		this.nuTelefono = nuTelefono;
	}
	public String getNuCelular() {
		return nuCelular;
	}
	public void setNuCelular(String nuCelular) {
		this.nuCelular = nuCelular;
	}
	public String getNoCorreo() {
		return noCorreo;
	}
	public void setNoCorreo(String noCorreo) {
		this.noCorreo = noCorreo;
	}
	public String getNuCmvp() {
		return nuCmvp;
	}
	public void setNuCmvp(String nuCmvp) {
		this.nuCmvp = nuCmvp;
	}
	public String getNoGrupoOcupacional() {
		return noGrupoOcupacional;
	}
	public void setNoGrupoOcupacional(String noGrupoOcupacional) {
		this.noGrupoOcupacional = noGrupoOcupacional;
	}
	public String getNoTipoProfesional() {
		return noTipoProfesional;
	}
	public void setNoTipoProfesional(String noTipoProfesional) {
		this.noTipoProfesional = noTipoProfesional;
	}
	public String getNoEstado() {
		return noEstado;
	}
	public void setNoEstado(String noEstado) {
		this.noEstado = noEstado;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Integer getIdGrupoOcupacional() {
		return idGrupoOcupacional;
	}
	public void setIdGrupoOcupacional(Integer idGrupoOcupacional) {
		this.idGrupoOcupacional = idGrupoOcupacional;
	}
	public Boolean getIlActivo() {
		return ilActivo;
	}
	public void setIlActivo(Boolean ilActivo) {
		this.ilActivo = ilActivo;
	}
	public Integer getCaProfesional() {
		return caProfesional;
	}
	public void setCaProfesional(Integer caProfesional) {
		this.caProfesional = caProfesional;
	}
	public Integer getCaNoProfesional() {
		return caNoProfesional;
	}
	public void setCaNoProfesional(Integer caNoProfesional) {
		this.caNoProfesional = caNoProfesional;
	}
	
}