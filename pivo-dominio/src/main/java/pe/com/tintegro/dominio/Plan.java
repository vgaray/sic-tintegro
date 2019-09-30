package pe.com.tintegro.dominio;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Plan implements Serializable{
	private static final long serialVersionUID = 1L;
private Integer id;
private String noDescripcion;
private Integer caAnexos;
public Integer getCaAnexos() {
	return caAnexos;
}
public void setCaAnexos(Integer caAnexos) {
	this.caAnexos = caAnexos;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNoDescripcion() {
	return noDescripcion;
}
public void setNoDescripcion(String noDescripcion) {
	this.noDescripcion = noDescripcion;
}
}
