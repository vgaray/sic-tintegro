package pe.com.tintegro.dominio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)

public class Pagina {
	private Integer idPagina;
	private String noPagina;
	private Integer idPadre;
	private String noComponente;
	private String noUrl;
	private Integer ilPadre;
	
	private boolean seleccionado;
	
	public boolean isSeleccionado()
	{
		return seleccionado;
	}
	public void setSeleccionado(boolean seleccionado)
	{
		this.seleccionado = seleccionado;
	}
	private List<Pagina> listHijos;
	private List<Integer> listHijosSeleccionado=new ArrayList<Integer>();
	
	
	public List<Integer> getListHijosSeleccionado()
	{
		return listHijosSeleccionado;
	}
	public void setListHijosSeleccionado(List<Integer> listHijosSeleccionado)
	{
		this.listHijosSeleccionado = listHijosSeleccionado;
	}
	public List<Pagina> getListHijos() {
		return listHijos;
	}
	public void setListHijos(List<Pagina> listHijos) {
		this.listHijos = listHijos;
	}
	public Integer getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}
	public Integer getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(Integer idPagina) {
		this.idPagina = idPagina;
	}
	public String getNoPagina() {
		return noPagina;
	}
	public void setNoPagina(String noPagina) {
		this.noPagina = noPagina;
	}
	public String getNoComponente() {
		return noComponente;
	}
	public void setNoComponente(String noComponente) {
		this.noComponente = noComponente;
	}
	public String getNoUrl() {
		return noUrl;
	}
	public void setNoUrl(String noUrl) {
		this.noUrl = noUrl;
	}
	public Integer getIlPadre() {
		return ilPadre;
	}
	public void setIlPadre(Integer ilPadre) {
		this.ilPadre = ilPadre;
	}
	
}
