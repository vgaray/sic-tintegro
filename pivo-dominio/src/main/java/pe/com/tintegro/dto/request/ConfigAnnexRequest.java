package pe.com.tintegro.dto.request;

public class ConfigAnnexRequest extends RequestBase
{
	private String	nomUsuario;
	private String	nomMarca;

	public String getNomUsuario()
	{
		return nomUsuario;
	}

	public void setNomUsuario( String nomUsuario )
	{
		this.nomUsuario = nomUsuario;
	}

	public String getNomMarca()
	{
		return nomMarca;
	}

	public void setNomMarca( String nomMarca )
	{
		this.nomMarca = nomMarca;
	}
}
