package pe.com.tintegro.dto.request;

public class ActualizarUsuarioEstandarRequest extends RequestBase
{

	private Integer idUsuario;
	private String noPasswo;
	private String noNombre;
	private String noApellido;
	private String email;
	private String noProfe;
	private Integer idRol;
	private String noLoginCreador;
	private String idInstancia;
	   
	   
	   
   private Integer idInstanciadesenc;
   
	public Integer getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario)
	{
		this.idUsuario = idUsuario;
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

	public String getNoApellido()
	{
		return noApellido;
	}

	public void setNoApellido(String noApellido)
	{
		this.noApellido = noApellido;
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

	public Integer getIdInstanciadesenc()
	{
		return idInstanciadesenc;
	}

	public void setIdInstanciadesenc(Integer idInstanciadesenc)
	{
		this.idInstanciadesenc = idInstanciadesenc;
	}
	
	

}
