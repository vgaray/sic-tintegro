package pe.com.tintegro.dto.response;

import java.util.List;

public class ListaAudiosPredeterminadosResponse extends ResponseBase
{
	private List< String > lsAudiosPredeterminados;

	public List< String > getLsAudiosPredeterminados()
	{
		return lsAudiosPredeterminados;
	}

	public void setLsAudiosPredeterminados(List< String > lsAudiosPredeterminados)
	{
		this.lsAudiosPredeterminados = lsAudiosPredeterminados;
	}
}
