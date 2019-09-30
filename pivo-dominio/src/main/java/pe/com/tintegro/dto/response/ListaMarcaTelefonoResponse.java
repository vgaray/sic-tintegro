package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.MarcaTelefono;

public class ListaMarcaTelefonoResponse extends ResponseBase
{
	private List<MarcaTelefono> marcaTelefonoList;

	public List<MarcaTelefono> getMarcaTelefonoList()
	{
		return marcaTelefonoList;
	}

	public void setMarcaTelefonoList(List<MarcaTelefono> marcaTelefonoList)
	{
		this.marcaTelefonoList = marcaTelefonoList;
	}
}