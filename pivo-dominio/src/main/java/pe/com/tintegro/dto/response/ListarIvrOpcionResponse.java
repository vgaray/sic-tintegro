package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.IvrOpcion;

public class ListarIvrOpcionResponse extends ResponseBase
{
	private List<IvrOpcion> listaIvrOpcion ;

	public List<IvrOpcion> getListaIvrOpcion()
	{
		return listaIvrOpcion;
	}

	public void setListaIvrOpcion(List<IvrOpcion> listaIvrOpcion)
	{
		this.listaIvrOpcion = listaIvrOpcion;
	}
	
	

}
