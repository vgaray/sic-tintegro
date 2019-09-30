package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;

public class ListaInstanciaxIdResponse extends ResponseBase 
{

	/**
	 * 
	 */
	private List<InstanciaServerAsterisk> listarInstanciaxId;

	public List<InstanciaServerAsterisk> getListarInstanciaxId()
	{
		return listarInstanciaxId;
	}

	public void setListarInstanciaxId(List<InstanciaServerAsterisk> listarInstanciaxId)
	{
		this.listarInstanciaxId = listarInstanciaxId;
	}

}
