package pe.com.tintegro.dto.request;

public class ListaClienteAutoCompletarRequest extends RequestBase
{
   private String noRazon;

	public String getNoRazon()
	{
		return noRazon;
	}

	public void setNoRazon(String noRazon)
	{
		this.noRazon = noRazon;
	}
   
}
