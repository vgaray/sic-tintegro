package pe.com.tintegro.dto.request;

public class BuscarIVRPorNombreRequest extends RequestBase
{
	private String	noIVR;

	public String getNoIVR()
	{
		return noIVR;
	}

	public void setNoIVR( String noIVR )
	{
		this.noIVR = noIVR;
	}
}
