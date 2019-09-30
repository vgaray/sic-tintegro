package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Usuario;

public class ListaUsuarioEstandarResponse extends ResponseBase
{
	private List<Usuario> usuarioList;

	public List<Usuario> getUsuarioList()
	{
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList)
	{
		this.usuarioList = usuarioList;
	}

}
