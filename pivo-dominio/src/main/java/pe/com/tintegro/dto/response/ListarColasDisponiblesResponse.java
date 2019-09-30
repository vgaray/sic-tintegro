package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Queues;

public class ListarColasDisponiblesResponse extends ResponseBase
{
	private List<Queues> listado;

	public List<Queues> getListado()
	{
		return listado;
	}

	public void setListado(List<Queues> listado)
	{
		this.listado = listado;
	}


}
