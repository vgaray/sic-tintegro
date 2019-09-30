package pe.com.tintegro.dto.response;

import java.util.List;



public class AutoCompletarSipTelefonoResponse extends ResponseBase
{
	private List<String> listaAnexos;

	public List<String> getListaAnexos()
	{
		return listaAnexos;
	}

	public void setListaAnexos(List<String> listaAnexos)
	{
		this.listaAnexos = listaAnexos;
	} 

}
