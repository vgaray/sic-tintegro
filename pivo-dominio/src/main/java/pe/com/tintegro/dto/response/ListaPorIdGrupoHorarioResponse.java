package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.GrupoHorario;

public class ListaPorIdGrupoHorarioResponse extends ResponseBase
{

	private List<GrupoHorario> listaPorIdGrupoHorario;

	public List<GrupoHorario> getListaPorIdGrupoHorario()
	{
		return listaPorIdGrupoHorario;
	}

	public void setListaPorIdGrupoHorario(List<GrupoHorario> listaPorIdGrupoHorario)
	{
		this.listaPorIdGrupoHorario = listaPorIdGrupoHorario;
	}

}
