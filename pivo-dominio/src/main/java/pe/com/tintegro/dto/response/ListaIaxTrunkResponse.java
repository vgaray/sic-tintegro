package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.IaxTrunk;

public class ListaIaxTrunkResponse extends ResponseBase
{
	private List<IaxTrunk> listaIaxTrunk;

	public List<IaxTrunk> getListaIaxTrunk()
	{
		return listaIaxTrunk;
	}

	public void setListaIaxTrunk(List<IaxTrunk> listaIaxTrunk)
	{
		this.listaIaxTrunk = listaIaxTrunk;
	}

}
