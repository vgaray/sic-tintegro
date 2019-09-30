package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.SipBuddie;

public class ListarAnexoResponse extends ResponseBase
{
	private List<SipBuddie> listado;

	public List<SipBuddie> getListado()
	{
		return listado;
	}

	public void setListado(List<SipBuddie> listado)
	{
		this.listado = listado;
	}
	
	
	
	
}
