package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Pagina;

public class ListarPaginaResponse extends ResponseBase{

	private List<Pagina> listaPagina;

	public List<Pagina> getListaPagina() {
		return listaPagina;
	}

	public void setListaPagina(List<Pagina> listaPagina) {
		this.listaPagina = listaPagina;
	}
	
}
