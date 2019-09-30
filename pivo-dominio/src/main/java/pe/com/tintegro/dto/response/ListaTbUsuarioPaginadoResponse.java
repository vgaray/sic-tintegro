package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.TbUsuario;

public class ListaTbUsuarioPaginadoResponse extends ResponseBase
{
	private List<TbUsuario> TbUsuarioList;

	public List<TbUsuario> getTbUsuarioList()
	{
		return TbUsuarioList;
	}

	public void setTbUsuarioList(List<TbUsuario> tbUsuarioList)
	{
		TbUsuarioList = tbUsuarioList;
	}

}
