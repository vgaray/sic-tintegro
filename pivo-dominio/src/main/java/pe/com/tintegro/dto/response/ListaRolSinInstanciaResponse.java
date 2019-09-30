package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Rol;

public class ListaRolSinInstanciaResponse extends ResponseBase
{
	private List<Rol> roles;

	public List<Rol> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Rol> roles)
	{
		this.roles = roles;
	}
}
