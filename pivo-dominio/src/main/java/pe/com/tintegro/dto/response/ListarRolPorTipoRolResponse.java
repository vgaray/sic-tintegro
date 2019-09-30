package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Rol;

public class ListarRolPorTipoRolResponse extends ResponseBase
{
   private List<Rol> listaRoles;

	public List<Rol> getListaRoles()
	{
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles)
	{
		this.listaRoles = listaRoles;
	}
   
}
