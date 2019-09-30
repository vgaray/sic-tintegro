package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ReporteAtencionClienteCallCenter implements Serializable{

	private static final long serialVersionUID = 1L;
	private String feLlamad;
	private Integer	llaEntra;
	private Integer	llaAtendi;
	private Integer	llaAtetab;
	private Integer	llaAbando;
	private Integer	llaAbatab;
	////////////////////////////
	private Integer	llaDisuac;
	private Integer	llaAtens;
	private Integer	tiAbando;
	///////////////////////////
	private BigDecimal porcentajeTotalAbandonos;
	private BigDecimal porcentajeTabAbandonos;
	private BigDecimal porcentajeRoEficacia;
	private BigDecimal porcentajeNsvEficacia;
	private Integer	tiProcon;
	private Integer	tiProesp;
	private Integer	tiEma;
	
	public String getFeLlamad() {
		return feLlamad;
	}
	public void setFeLlamad(String feLlamad) {
		this.feLlamad = feLlamad;
	}
	public Integer getLlaEntra() {
		return llaEntra;
	}
	public void setLlaEntra(Integer llaEntra) {
		this.llaEntra = llaEntra;
	}
	public Integer getLlaAtendi() {
		return llaAtendi;
	}
	public void setLlaAtendi(Integer llaAtendi) {
		this.llaAtendi = llaAtendi;
	}
	public Integer getLlaAtetab() {
		return llaAtetab;
	}
	public void setLlaAtetab(Integer llaAtetab) {
		this.llaAtetab = llaAtetab;
	}
	public Integer getLlaAbando() {
		return llaAbando;
	}
	public void setLlaAbando(Integer llaAbando) {
		this.llaAbando = llaAbando;
	}
	public Integer getLlaAbatab() {
		return llaAbatab;
	}
	public void setLlaAbatab(Integer llaAbatab) {
		this.llaAbatab = llaAbatab;
	}
	public Integer getLlaDisuac() {
		return llaDisuac;
	}
	public void setLlaDisuac(Integer llaDisuac) {
		this.llaDisuac = llaDisuac;
	}
	public Integer getLlaAtens() {
		return llaAtens;
	}
	public void setLlaAtens(Integer llaAtens) {
		this.llaAtens = llaAtens;
	}
	public Integer getTiAbando() {
		return tiAbando;
	}
	public void setTiAbando(Integer tiAbando) {
		this.tiAbando = tiAbando;
	}
	public BigDecimal getPorcentajeTotalAbandonos() {
		return porcentajeTotalAbandonos;
	}
	public void setPorcentajeTotalAbandonos(BigDecimal porcentajeTotalAbandonos) {
		this.porcentajeTotalAbandonos = porcentajeTotalAbandonos;
	}
	public BigDecimal getPorcentajeTabAbandonos() {
		return porcentajeTabAbandonos;
	}
	public void setPorcentajeTabAbandonos(BigDecimal porcentajeTabAbandonos) {
		this.porcentajeTabAbandonos = porcentajeTabAbandonos;
	}
	public BigDecimal getPorcentajeRoEficacia() {
		return porcentajeRoEficacia;
	}
	public void setPorcentajeRoEficacia(BigDecimal porcentajeRoEficacia) {
		this.porcentajeRoEficacia = porcentajeRoEficacia;
	}
	public BigDecimal getPorcentajeNsvEficacia() {
		return porcentajeNsvEficacia;
	}
	public void setPorcentajeNsvEficacia(BigDecimal porcentajeNsvEficacia) {
		this.porcentajeNsvEficacia = porcentajeNsvEficacia;
	}
	public Integer getTiProcon() {
		return tiProcon;
	}
	public void setTiProcon(Integer tiProcon) {
		this.tiProcon = tiProcon;
	}
	public Integer getTiProesp() {
		return tiProesp;
	}
	public void setTiProesp(Integer tiProesp) {
		this.tiProesp = tiProesp;
	}
	public Integer getTiEma() {
		return tiEma;
	}
	public void setTiEma(Integer tiEma) {
		this.tiEma = tiEma;
	}
	
	
}
