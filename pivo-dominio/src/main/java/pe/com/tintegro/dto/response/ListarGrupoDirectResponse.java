package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.GrupoDirectorio;

public class ListarGrupoDirectResponse extends ResponseBase
{
	private List<GrupoDirectorio> listado;

	public List<GrupoDirectorio> getListado()
	{
		return listado;
	}

	public void setListado(List<GrupoDirectorio> listado)
	{
		this.listado = listado;
	}
	
	
	
}
