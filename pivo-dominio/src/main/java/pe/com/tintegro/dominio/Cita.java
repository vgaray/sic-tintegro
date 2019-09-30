package pe.com.tintegro.dominio;

import java.io.Serializable;

public class Cita implements Serializable {

	private static final long serialVersionUID = 658381624180211461L;
	private Integer idCita;
	private String noCita;
	private String noDescripcion;
	private String feReserva;
	private String feRegistro;
	private String noTipoDocumento;
	private String nuDocumento;
	private Integer idUsuario;
	private String noDuenio;
	private Integer idMascota;
	private String noMascota;
	private String noEspecie;
	private String noRaza;
	private String nuTelefono;
	private String noCorreo;
	private String nuContacto;
	private String noActividad;
	private String hoInicio;
	private String hoFinal;
	private String noTurno;
	private String noPeriodo;
	private String idTurno;
	private Integer idActividad;
	private Integer idEstado;
	private String noEstado;
	private String nuChip;
	private String idPersonal;
	private String noPersonal;
	

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

	public String getNuChip() {
		return nuChip;
	}

	public void setNuChip(String nuChip) {
		this.nuChip = nuChip;
	}

	public String getNoEstado() {
		return noEstado;
	}

	public void setNoEstado(String noEstado) {
		this.noEstado = noEstado;
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getNoCita() {
		return noCita;
	}

	public void setNoCita(String noCita) {
		this.noCita = noCita;
	}

	public String getNoDescripcion() {
		return noDescripcion;
	}

	public void setNoDescripcion(String noDescripcion) {
		this.noDescripcion = noDescripcion;
	}

	public String getFeReserva() {
		return feReserva;
	}

	public void setFeReserva(String feReserva) {
		this.feReserva = feReserva;
	}

	public String getFeRegistro() {
		return feRegistro;
	}

	public void setFeRegistro(String feRegistro) {
		this.feRegistro = feRegistro;
	}

	public String getNoTipoDocumento() {
		return noTipoDocumento;
	}

	public void setNoTipoDocumento(String noTipoDocumento) {
		this.noTipoDocumento = noTipoDocumento;
	}

	public String getNuDocumento() {
		return nuDocumento;
	}

	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNoDuenio() {
		return noDuenio;
	}

	public void setNoDuenio(String noDuenio) {
		this.noDuenio = noDuenio;
	}

	public Integer getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public String getNoMascota() {
		return noMascota;
	}

	public void setNoMascota(String noMascota) {
		this.noMascota = noMascota;
	}

	public String getNoEspecie() {
		return noEspecie;
	}

	public void setNoEspecie(String noEspecie) {
		this.noEspecie = noEspecie;
	}

	public String getNoRaza() {
		return noRaza;
	}

	public void setNoRaza(String noRaza) {
		this.noRaza = noRaza;
	}

	public String getNuTelefono() {
		return nuTelefono;
	}

	public void setNuTelefono(String nuTelefono) {
		this.nuTelefono = nuTelefono;
	}

	public String getNoCorreo() {
		return noCorreo;
	}

	public void setNoCorreo(String noCorreo) {
		this.noCorreo = noCorreo;
	}

	public String getNuContacto() {
		return nuContacto;
	}

	public void setNuContacto(String nuContacto) {
		this.nuContacto = nuContacto;
	}

	public String getNoActividad() {
		return noActividad;
	}

	public void setNoActividad(String noActividad) {
		this.noActividad = noActividad;
	}

	public String getHoInicio() {
		return hoInicio;
	}

	public void setHoInicio(String hoInicio) {
		this.hoInicio = hoInicio;
	}

	public String getHoFinal() {
		return hoFinal;
	}

	public void setHoFinal(String hoFinal) {
		this.hoFinal = hoFinal;
	}

	public String getNoTurno() {
		return noTurno;
	}

	public void setNoTurno(String noTurno) {
		this.noTurno = noTurno;
	}

	public String getNoPeriodo() {
		return noPeriodo;
	}

	public void setNoPeriodo(String noPeriodo) {
		this.noPeriodo = noPeriodo;
	}

	public String getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", noCita=" + noCita + ", noDescripcion=" + noDescripcion + ", feReserva="
				+ feReserva + ", feRegistro=" + feRegistro + ", noTipoDocumento=" + noTipoDocumento + ", nuDocumento="
				+ nuDocumento + ", idUsuario=" + idUsuario + ", noDuenio=" + noDuenio + ", idMascota=" + idMascota
				+ ", noMascota=" + noMascota + ", noEspecie=" + noEspecie + ", noRaza=" + noRaza + ", nuTelefono="
				+ nuTelefono + ", noCorreo=" + noCorreo + ", nuContacto=" + nuContacto + ", noActividad=" + noActividad
				+ ", hoInicio=" + hoInicio + ", hoFinal=" + hoFinal + ", noTurno=" + noTurno + ", noPeriodo="
				+ noPeriodo + ", idTurno=" + idTurno + ", idActividad=" + idActividad + ", idEstado=" + idEstado
				+ ", noEstado=" + noEstado + "]";
	}

	

}
