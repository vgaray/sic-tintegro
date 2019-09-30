package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ListadoProblema;

public class ListarListadoProblemaResponse extends ResponseBase {

	private List<ListadoProblema> lsListadoProblema;

	public List<ListadoProblema> getLsListadoProblema() {
		return lsListadoProblema;
	}

	public void setLsListadoProblema(List<ListadoProblema> lsListadoProblema) {
		this.lsListadoProblema = lsListadoProblema;
	}

}
