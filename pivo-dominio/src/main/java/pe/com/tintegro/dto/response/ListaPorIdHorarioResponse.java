package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Horario;

public class ListaPorIdHorarioResponse extends ResponseBase
{
	private List<Horario> listaPorIdHorario;

	public List<Horario> getListaPorIdHorario()
	{
		return listaPorIdHorario;
	}

	public void setListaPorIdHorario(List<Horario> listaPorIdHorario)
	{
		this.listaPorIdHorario = listaPorIdHorario;
	}

}
