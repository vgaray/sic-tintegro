package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Permit;

public class ListaPermitResponse extends ResponseBase
{
	private List<Permit> listaPermit;

	public List<Permit> getListaPermit()
	{
		return listaPermit;
	}

	public void setListaPermit(List<Permit> listaPermit)
	{
		this.listaPermit = listaPermit;
	}
	
	
}
