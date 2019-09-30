package pe.com.tintegro.dto.response;

import java.util.List;


public class ListarContextoResponse extends ResponseBase
{
	private List<String> listado;

	public List<String> getListado()
	{
		return listado;
	}

	public void setListado(List<String> listado)
	{
		this.listado = listado;
	}
	
	
	
}
