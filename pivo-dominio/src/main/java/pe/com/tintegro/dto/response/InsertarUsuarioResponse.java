package pe.com.tintegro.dto.response;

import java.util.List;

public class InsertarUsuarioResponse extends ResponseBase 
{

	private int insertado;
	private List<String> listaErrores;

	public int getInsertado()
	{
		return insertado;
	}

	public void setInsertado(int insertado)
	{
		this.insertado = insertado;
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
