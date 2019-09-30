package pe.com.tintegro.dto.request;

public class BuscaSipBuddieIdRequest extends RequestBase
{
	private String	nomUsuario;

	public String getNomUsuario()
	{
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario)
	{
		this.nomUsuario = nomUsuario;
	}
}
