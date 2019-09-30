package pe.com.tintegro.dto.request;

public class ListaUsuarioEstandarRequest extends RequestBase
{
	private String nologin;

	private String idInstancia;

	private Integer idInstanciadesenc;
	
	private Integer idUsuario;
	
	private Integer tiOpera;


	public String getNologin()
	{
		return nologin;
	}

	public void setNologin(String nologin)
	{
		this.nologin = nologin;
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

	public Integer getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public Integer getTiOpera()
	{
		return tiOpera;
	}

	public void setTiOpera(Integer tiOpera)
	{
		this.tiOpera = tiOpera;
	}
	
	
	

}
