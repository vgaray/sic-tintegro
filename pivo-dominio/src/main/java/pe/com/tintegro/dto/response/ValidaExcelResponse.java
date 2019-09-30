package pe.com.tintegro.dto.response;

import java.util.List;

public class ValidaExcelResponse 
{
	private int estado;
	private List<String> listaErrores;
	public int getEstado()
	{
		return estado;
	}
	public void setEstado(int estado)
	{
		this.estado = estado;
	}
	public List<String> getListaErrores()
	{
		return listaErrores;
	}
	public void setListaErrores(List<String> listaErrores)
	{
		this.listaErrores = listaErrores;
	}
	
	
}
