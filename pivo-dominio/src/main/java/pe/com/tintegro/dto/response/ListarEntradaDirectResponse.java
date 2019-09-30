package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.EntradaDirectorio;

public class ListarEntradaDirectResponse extends ResponseBase
{
	List<EntradaDirectorio> listado;

	public List<EntradaDirectorio> getListado()
	{
		return listado;
	}

	public void setListado(List<EntradaDirectorio> listado)
	{
		this.listado = listado;
	}
	
	
}
