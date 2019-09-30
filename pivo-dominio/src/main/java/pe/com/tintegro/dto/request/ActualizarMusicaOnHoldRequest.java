package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.MusicaOnHold;

public class ActualizarMusicaOnHoldRequest extends RequestBase
{
	private Integer pIdClase;
	private String pNoClase;
	private MusicaOnHold musica;

	public Integer getpIdClase()
	{
		return pIdClase;
	}
	public void setpIdClase(Integer pIdClase)
	{
		this.pIdClase = pIdClase;
	}
	public String getpNoClase()
	{
		return pNoClase;
	}
	public void setpNoClase(String pNoClase)
	{
		this.pNoClase = pNoClase;
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
