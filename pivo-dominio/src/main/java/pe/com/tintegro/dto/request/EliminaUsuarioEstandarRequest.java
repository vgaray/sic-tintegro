package pe.com.tintegro.dto.request;

public class EliminaUsuarioEstandarRequest extends RequestBase
{
	private Integer idUsuario;
	private String noLoginCreador;
	private String idInstancia;
	private Integer idInstanciadesc;

	public Integer getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario)
	{
		this.idUsuario = idUsuario;
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
