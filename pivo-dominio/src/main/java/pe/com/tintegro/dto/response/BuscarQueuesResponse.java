package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Queues;

public class BuscarQueuesResponse extends ResponseBase
{
	private List<Queues> buscado;

	public List<Queues> getBuscado()
	{
		return buscado;
	}

	public void setBuscado(List<Queues> buscado)
	{
		this.buscado = buscado;
	}
	
	
}
