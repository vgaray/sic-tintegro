package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class HistoriaClinica implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idHistoriaClinica;
	private String nuHistoria;
	private Integer idEncargado;
	private String feAdmision;
	private String nuChip;
	private String noNombre;
	private String noEspecie;
	private String noRaza;
	private String noColor;
	private String noSexo;
	private String feNacimiento;
	private String nuEdad;
	private String noSenasParticulares;
	private String noProcedencia;
	private Integer idUsuario;
	private String noMotivoConsulta;
	private String noAnamnesicos;
	private String noAlergias;
	private String noEfermedadesRecientes;
	private String noCirugias;
	private String noHabitad;
	private String noAntFamiliares;
	private String noTipoAlimentacion;
	private Integer idMascota;
	private Integer idEstadoReproductivo;
	private Integer idVeterinaria;
	private String noNombreEstadoReproductivo;
	private String noPass;

	public String getNuHistoria() {
		return nuHistoria;
	}

	public void setNuHistoria(String nuHistoria) {
		this.nuHistoria = nuHistoria;
	}

	public Integer getIdEncargado() {
		return idEncargado;
	}

	public void setIdEncargado(Integer idEncargado) {
		this.idEncargado = idEncargado;
	}

	public String getFeAdmision() {
		return feAdmision;
	}

	public void setFeAdmision(String feAdmision) {
		this.feAdmision = feAdmision;
	}

	public String getNuChip() {
		return nuChip;
	}

	public void setNuChip(String nuChip) {
		this.nuChip = nuChip;
	}

	public String getNoNombre() {
		return noNombre;
	}

	public void setNoNombre(String noNombre) {
		this.noNombre = noNombre;
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

	public String getNoColor() {
		return noColor;
	}

	public void setNoColor(String noColor) {
		this.noColor = noColor;
	}

	public String getNoSexo() {
		return noSexo;
	}

	public void setNoSexo(String noSexo) {
		this.noSexo = noSexo;
	}

	public String getFeNacimiento() {
		return feNacimiento;
	}

	public void setFeNacimiento(String feNacimiento) {
		this.feNacimiento = feNacimiento;
	}

	public String getNuEdad() {
		return nuEdad;
	}

	public void setNuEdad(String nuEdad) {
		this.nuEdad = nuEdad;
	}

	public String getNoSenasParticulares() {
		return noSenasParticulares;
	}

	public void setNoSenasParticulares(String noSenasParticulares) {
		this.noSenasParticulares = noSenasParticulares;
	}

	public String getNoProcedencia() {
		return noProcedencia;
	}

	public void setNoProcedencia(String noProcedencia) {
		this.noProcedencia = noProcedencia;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNoMotivoConsulta() {
		return noMotivoConsulta;
	}

	public void setNoMotivoConsulta(String noMotivoConsulta) {
		this.noMotivoConsulta = noMotivoConsulta;
	}

	public String getNoAnamnesicos() {
		return noAnamnesicos;
	}

	public void setNoAnamnesicos(String noAnamnesicos) {
		this.noAnamnesicos = noAnamnesicos;
	}

	public String getNoEfermedadesRecientes() {
		return noEfermedadesRecientes;
	}

	public void setNoEfermedadesRecientes(String noEfermedadesRecientes) {
		this.noEfermedadesRecientes = noEfermedadesRecientes;
	}

	public String getNoCirugias() {
		return noCirugias;
	}

	public void setNoCirugias(String noCirugias) {
		this.noCirugias = noCirugias;
	}

	public String getNoHabitad() {
		return noHabitad;
	}

	public void setNoHabitad(String noHabitad) {
		this.noHabitad = noHabitad;
	}

	public String getNoTipoAlimentacion() {
		return noTipoAlimentacion;
	}

	public void setNoTipoAlimentacion(String noTipoAlimentacion) {
		this.noTipoAlimentacion = noTipoAlimentacion;
	}

	public Integer getIdVterinaria() {
		return idVeterinaria;
	}

	public void setIdVterinaria(Integer idVterinaria) {
		this.idVeterinaria = idVterinaria;
	}

	public Integer getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

	public void setIdHistoriaClinica(Integer idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}

	public String getNoAlergias() {
		return noAlergias;
	}

	public void setNoAlergias(String noAlergias) {
		this.noAlergias = noAlergias;
	}

	public String getNoAntFamiliares() {
		return noAntFamiliares;
	}

	public void setNoAntFamiliares(String noAntFamiliares) {
		this.noAntFamiliares = noAntFamiliares;
	}

	public Integer getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public Integer getIdEstadoReproductivo() {
		return idEstadoReproductivo;
	}

	public void setIdEstadoReproductivo(Integer idEstadoReproductivo) {
		this.idEstadoReproductivo = idEstadoReproductivo;
	}

	public String getNoNombreEstadoReproductivo() {
		return noNombreEstadoReproductivo;
	}

	public void setNoNombreEstadoReproductivo(String noNombreEstadoReproductivo) {
		this.noNombreEstadoReproductivo = noNombreEstadoReproductivo;
	}

	public String getNoPass() {
		return noPass;
	}

	public void setNoPass(String noPass) {
		this.noPass = noPass;
	}

	@Override
	public String toString() {
		return "HistoriaClinica [idHistoriaClinica=" + idHistoriaClinica + ", nuHistoria=" + nuHistoria
				+ ", idEncargado=" + idEncargado + ", feAdmision=" + feAdmision + ", nuChip=" + nuChip + ", noNombre="
				+ noNombre + ", noEspecie=" + noEspecie + ", noRaza=" + noRaza + ", noColor=" + noColor + ", noSexo="
				+ noSexo + ", feNacimiento=" + feNacimiento + ", nuEdad=" + nuEdad + ", noSenasParticulares="
				+ noSenasParticulares + ", noProcedencia=" + noProcedencia + ", idUsuario=" + idUsuario
				+ ", noMotivoConsulta=" + noMotivoConsulta + ", noAnamnesicos=" + noAnamnesicos + ", noAlergias="
				+ noAlergias + ", noEfermedadesRecientes=" + noEfermedadesRecientes + ", noCirugias=" + noCirugias
				+ ", noHabitad=" + noHabitad + ", noAntFamiliares=" + noAntFamiliares + ", noTipoAlimentacion="
				+ noTipoAlimentacion + ", idMascota=" + idMascota + ", idEstadoReproductivo=" + idEstadoReproductivo
				+ ", idVeterinaria=" + idVeterinaria 
				+ ", noNombreEstadoReproductivo=" + noNombreEstadoReproductivo + ", noPass=" + noPass + "]";
	}

}
