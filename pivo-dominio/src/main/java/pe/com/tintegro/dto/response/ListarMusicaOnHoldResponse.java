package pe.com.tintegro.dto.response;

import java.util.List;
import pe.com.tintegro.dominio.MusicaOnHold;

public class ListarMusicaOnHoldResponse extends ResponseBase
{
	private List<MusicaOnHold> lsMusicaOnHold;

	public List<MusicaOnHold> getLsMusicaOnHold()
	{
		return lsMusicaOnHold;
	}

	public void setLsMusicaOnHold(List<MusicaOnHold> lsMusicaOnHold)
	{
		this.lsMusicaOnHold = lsMusicaOnHold;
	}

}
