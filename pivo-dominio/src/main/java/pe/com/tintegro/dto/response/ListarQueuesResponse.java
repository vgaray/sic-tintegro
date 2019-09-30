package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Queues;

public class ListarQueuesResponse extends ResponseBase
{
	private List<Queues> colaLista;

	public List<Queues> getColaLista()
	{
		return colaLista;
	}

	public void setColaLista(List<Queues> colaLista)
	{
		this.colaLista = colaLista;
	}


}
