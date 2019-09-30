package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.ListaNegra;

public class BuscarListaNegraResponse extends ResponseBase{

	private List<ListaNegra> lsListaNegra;

	public List<ListaNegra> getLsListaNegra() {
		return lsListaNegra;
	}

	public void setLsListaNegra(List<ListaNegra> lsListaNegra) {
		this.lsListaNegra = lsListaNegra;
	}
	
}
