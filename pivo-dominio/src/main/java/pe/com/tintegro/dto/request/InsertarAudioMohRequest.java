package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.MusicaOnHold;

public class InsertarAudioMohRequest extends RequestBase
{
	private String pNoAudio;
	private MusicaOnHold musica;
	private String base64Audio;

	public String getpNoAudio()
	{
		return pNoAudio;
	}

	public void setpNoAudio(String pNoAudio)
	{
		this.pNoAudio = pNoAudio;
	}

	public MusicaOnHold getMusica()
	{
		return musica;
	}

	public void setMusica(MusicaOnHold musica)
	{
		this.musica = musica;
	}

	public String getBase64Audio()
	{
		return base64Audio;
	}

	public void setBase64Audio(String base64Audio)
	{
		this.base64Audio = base64Audio;
	}
	
}
