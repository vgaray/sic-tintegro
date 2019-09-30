package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Horario;

public class ListaHorarioResponse extends ResponseBase
{
	private List<Horario> listaHorario;

	public List<Horario> getListaHorario()
	{
		return listaHorario;
	}

	public void setListaHorario(List<Horario> listaHorario)
	{
		this.listaHorario = listaHorario;
	}

}
