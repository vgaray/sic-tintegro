package pe.com.tintegro.dto.response;

public class ObtieneAudioResponse extends ResponseBase
{
	private String	audioBase64;

	public String getAudioBase64()
	{
		return audioBase64;
	}

	public void setAudioBase64( String audioBase64 )
	{
		this.audioBase64 = audioBase64;
	}
}
