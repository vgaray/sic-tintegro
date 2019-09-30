package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.GrupoHorario;

public class ListaGrupoHorarioResponse extends ResponseBase
{
	private List<GrupoHorario> listaGrupoHorario;

	public List<GrupoHorario> getListaGrupoHorario()
	{
		return listaGrupoHorario;
	}

	public void setListaGrupoHorario(List<GrupoHorario> listaGrupoHorario)
	{
		this.listaGrupoHorario = listaGrupoHorario;
	}

}
