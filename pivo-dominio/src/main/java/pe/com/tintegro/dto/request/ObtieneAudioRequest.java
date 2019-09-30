package pe.com.tintegro.dto.request;

public class ObtieneAudioRequest extends RequestBase
{
	private String	nameFile;

	public String getNameFile()
	{
		return nameFile;
	}

	public void setNameFile( String nameFile )
	{
		this.nameFile = nameFile;
	}
}
