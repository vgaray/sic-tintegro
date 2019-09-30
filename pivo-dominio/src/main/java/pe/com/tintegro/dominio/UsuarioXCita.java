package pe.com.tintegro.dominio;

import java.io.Serializable;

public class UsuarioXCita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6745085345693410265L;
	private Integer idUsuario;
	private String noNombre;
	private String noApellido;
	private String nuTelefono;
	private String noEmail;
	private String noProfe;
	private String noTipoDocumento;
	private String nuDocumento;
	private Integer idMascota;
	private String noNombreMascota;
	private String nuChip;
	private String noEspecie;
	private String noRaza;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getNuTelefono() {
		return nuTelefono;
	}

	public void setNuTelefono(String nuTelefono) {
		this.nuTelefono = nuTelefono;
	}

	public String getNoEmail() {
		return noEmail;
	}

	public void setNoEmail(String noEmail) {
		this.noEmail = noEmail;
	}

	public String getNoProfe() {
		return noProfe;
	}

	public void setNoProfe(String noProfe) {
		this.noProfe = noProfe;
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

	public Integer getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public String getNoNombreMascota() {
		return noNombreMascota;
	}

	public void setNoNombreMascota(String noNombreMascota) {
		this.noNombreMascota = noNombreMascota;
	}

	public String getNuChip() {
		return nuChip;
	}

	public void setNuChip(String nuChip) {
		this.nuChip = nuChip;
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

	@Override
	public String toString() {
		return "UsuarioXCita [idUsuario=" + idUsuario + ", noNombre=" + noNombre + ", noApellido=" + noApellido
				+ ", nuTelefono=" + nuTelefono + ", noEmail=" + noEmail + ", noProfe=" + noProfe + ", noTipoDocumento="
				+ noTipoDocumento + ", nuDocumento=" + nuDocumento + ", idMascota=" + idMascota + ", noNombreMascota="
				+ noNombreMascota + ", nuChip=" + nuChip + ", noEspecie=" + noEspecie + ", noRaza=" + noRaza + "]";
	}
}
