package pe.com.tintegro.dto.request;

public class InsertarUsuarioEstandarRequest extends RequestBase
{
	private String noLogin;
	private String noPasswo;
	private String noNombre;
	private String noApelli;
	private String email;
	private String noProfe;
	private Integer idRol;
	private String noLoginCreador;
	private String idInstancia;
	private Integer idInstanciadesc;

	public String getNoLogin()
	{
		return noLogin;
	}

	public void setNoLogin(String noLogin)
	{
		this.noLogin = noLogin;
	}

	public String getNoPasswo()
	{
		return noPasswo;
	}

	public void setNoPasswo(String noPasswo)
	{
		this.noPasswo = noPasswo;
	}

	public String getNoNombre()
	{
		return noNombre;
	}

	public void setNoNombre(String noNombre)
	{
		this.noNombre = noNombre;
	}

	public String getNoApelli()
	{
		return noApelli;
	}

	public void setNoApelli(String noApelli)
	{
		this.noApelli = noApelli;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getNoProfe()
	{
		return noProfe;
	}

	public void setNoProfe(String noProfe)
	{
		this.noProfe = noProfe;
	}

	public Integer getIdRol()
	{
		return idRol;
	}

	public void setIdRol(Integer idRol)
	{
		this.idRol = idRol;
	}

	public String getNoLoginCreador()
	{
		return noLoginCreador;
	}

	public void setNoLoginCreador(String noLoginCreador)
	{
		this.noLoginCreador = noLoginCreador;
	}

	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}


	public Integer getIdInstanciadesc()
	{
		return idInstanciadesc;
	}

	public void setIdInstanciadesc(Integer idInstanciadesc)
	{
		this.idInstanciadesc = idInstanciadesc;
	}


	

}
