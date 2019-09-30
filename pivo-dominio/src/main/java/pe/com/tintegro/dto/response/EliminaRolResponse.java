package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Confirmacion;

public class EliminaRolResponse extends ResponseBase 
{
	private List<Confirmacion> confirmacionList;

	public List<Confirmacion> getConfirmacionList() 
	{
		return confirmacionList;
	}

	public void setConfirmacionList(List<Confirmacion> confirmacionList) 
	{
		this.confirmacionList = confirmacionList;
	}
}
