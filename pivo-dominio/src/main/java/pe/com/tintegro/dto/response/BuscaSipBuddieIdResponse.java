package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.SipTelefono;

public class BuscaSipBuddieIdResponse extends ResponseBase
{
	private List<SipTelefono> sipTelefonoList;
	
	private boolean existeEx;

	public List<SipTelefono> getSipTelefonoList()
	{
		return sipTelefonoList;
	}

	public void setSipTelefonoList(List<SipTelefono> sipTelefonoList)
	{
		this.sipTelefonoList = sipTelefonoList;
	}

	public boolean isExisteEx()
	{
		return existeEx;
	}

	public void setExisteEx(boolean existeEx)
	{
		this.existeEx = existeEx;
	}

	 

}
