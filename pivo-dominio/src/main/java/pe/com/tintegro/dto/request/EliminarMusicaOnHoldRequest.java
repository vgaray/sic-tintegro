package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.MusicaOnHold;

public class EliminarMusicaOnHoldRequest extends RequestBase
{
	private Integer pIdClase;
	private MusicaOnHold musica;

	public Integer getpIdClase()
	{
		return pIdClase;
	}

	public void setpIdClase(Integer pIdClase)
	{
		this.pIdClase = pIdClase;
	}

	public MusicaOnHold getMusica()
	{
		return musica;
	}

	public void setMusica(MusicaOnHold musica)
	{
		this.musica = musica;
	}

}
