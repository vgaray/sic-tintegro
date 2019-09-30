package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Fax;

public class ListarFaxResponse extends ResponseBase
{
	private List<Fax> listado;

	public List<Fax> getListado()
	{
		return listado;
	}

	public void setListado(List<Fax> listado)
	{
		this.listado = listado;
	}
	
	
}
