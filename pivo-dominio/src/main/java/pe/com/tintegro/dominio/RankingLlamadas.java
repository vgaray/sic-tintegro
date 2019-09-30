package pe.com.tintegro.dominio;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class RankingLlamadas {
 private Integer idUsuario;
 private String noUsuario;
 private Integer caLlamad;
 private String caDuraci;
 private String caDuracProm;
 private String caDuracMin;
 private String caDuracMax;
 private Number nuTotalMin;
 private Integer indice;
	
public Number getNuTotalMin() {
	return nuTotalMin;
}
public void setNuTotalMin(Number nuTotalMin) {
	this.nuTotalMin = nuTotalMin;
}
//Para listar
 private Integer total;
 private Integer cantidadPaginas;
	
 
public Integer getTotal()
{
	return total;
}
public void setTotal(Integer total)
{
	this.total = total;
}
public Integer getCantidadPaginas()
{
	return cantidadPaginas;
}
public void setCantidadPaginas(Integer cantidadPaginas)
{
	this.cantidadPaginas = cantidadPaginas;
}
public Integer getIdUsuario() {
	return idUsuario;
}
public void setIdUsuario(Integer idUsuario) {
	this.idUsuario = idUsuario;
}
public String getNoUsuario() {
	return noUsuario;
}
public void setNoUsuario(String noUsuario) {
	this.noUsuario = noUsuario;
}
public Integer getCaLlamad() {
	return caLlamad;
}
public void setCaLlamad(Integer caLlamad) {
	this.caLlamad = caLlamad;
}
public String getCaDuraci() {
	return caDuraci;
}
public void setCaDuraci(String caDuraci) {
	this.caDuraci = caDuraci;
}
public String getCaDuracProm() {
	return caDuracProm;
}
public void setCaDuracProm(String caDuracProm) {
	this.caDuracProm = caDuracProm;
}
public String getCaDuracMin() {
	return caDuracMin;
}
public void setCaDuracMin(String caDuracMin) {
	this.caDuracMin = caDuracMin;
}
public String getCaDuracMax() {
	return caDuracMax;
}
public void setCaDuracMax(String caDuracMax) {
	this.caDuracMax = caDuracMax;
}
public Integer getIndice()
{
	return indice;
}
public void setIndice(Integer indice)
{
	this.indice = indice;
}



}