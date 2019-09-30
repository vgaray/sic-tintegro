package pe.com.tintegro.dto.request;

import java.util.List;

public class InsertarAudiosMohRequest extends RequestBase
{
	private List<InsertarAudioMohRequest> inseAudioMohRequestList;

	public List<InsertarAudioMohRequest> getInseAudioMohRequestList()
	{
		return inseAudioMohRequestList;
	}

	public void setInseAudioMohRequestList(List<InsertarAudioMohRequest> inseAudioMohRequestList)
	{
		this.inseAudioMohRequestList = inseAudioMohRequestList;
	}
}
