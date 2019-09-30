package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Grabacion implements Serializable {
	private static final long serialVersionUID = 1L;
	String nombreAudio;
	String tipo;
	String origen;
	String destino;
	String fecha;
	String hora;
	String duracion;
	String uniqueId;
	String nuAnexo;
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getNuAnexo() {
		return nuAnexo;
	}
	public void setNuAnexo(String nuAnexo) {
		this.nuAnexo = nuAnexo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getNombreAudio() {
		return nombreAudio;
	}
	public void setNombreAudio(String nombreAudio) {
		this.nombreAudio = nombreAudio;
	}
	
}
