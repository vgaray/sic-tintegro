package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Pagina;

public class ListaUrlPaginaResponse extends ResponseBase{
	
	private List<Pagina> lsPaginaUrl;

	public List<Pagina> getLsPaginaUrl() {
		return lsPaginaUrl;
	}

	public void setLsPaginaUrl(List<Pagina> lsPaginaUrl) {
		this.lsPaginaUrl = lsPaginaUrl;
	}
}
