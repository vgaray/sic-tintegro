package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.SipTelefono;

public class ListaSipTelefonoResponse extends ResponseBase
{
	private List<SipTelefono> sipTelefonoList;

	public List<SipTelefono> getSipTelefonoList()
	{
		return sipTelefonoList;
	}

	public void setSipTelefonoList(List<SipTelefono> sipTelefonoList)
	{
		this.sipTelefonoList = sipTelefonoList;
	}

}
