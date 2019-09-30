package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.IvrOpcion;

public class ListarNoIvrResponse extends ResponseBase
{
	private List<IvrOpcion> listado;

	public List<IvrOpcion> getListado()
	{
		return listado;
	}

	public void setListado(List<IvrOpcion> listado)
	{
		this.listado = listado;
	}
	
	
	
}
