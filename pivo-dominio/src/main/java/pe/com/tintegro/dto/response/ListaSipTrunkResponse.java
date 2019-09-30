package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.SipTrunk;

public class ListaSipTrunkResponse extends ResponseBase
{
	private List<SipTrunk> listaSipTrunk;

	public List<SipTrunk> getListaSipTrunk()
	{
		return listaSipTrunk;
	}

	public void setListaSipTrunk(List<SipTrunk> listaSipTrunk)
	{
		this.listaSipTrunk = listaSipTrunk;
	}

}
