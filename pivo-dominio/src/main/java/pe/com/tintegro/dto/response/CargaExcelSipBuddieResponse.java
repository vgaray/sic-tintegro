package pe.com.tintegro.dto.response;

import java.util.List;

public class CargaExcelSipBuddieResponse extends ResponseBase{
    List<String> listaErrores;

	public List<String> getListaErrores()
	{
		return listaErrores;
	}

	public void setListaErrores(List<String> listaErrores)
	{
		this.listaErrores = listaErrores;
	}
    
}
