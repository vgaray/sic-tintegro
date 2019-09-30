package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.ListaNegra;

public class ListarListaNegraResponse extends ResponseBase
{
	private List<ListaNegra> listasNegras;

	public List<ListaNegra> getListasNegras()
	{
		return listasNegras;
	}

	public void setListasNegras(List<ListaNegra> listasNegras)
	{
		this.listasNegras = listasNegras;
	}

}
