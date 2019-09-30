package pe.com.tintegro.dto.response;

public class EliminaBolsaUsuarioResponse extends ResponseBase
{
	private Integer resultado;
	private String mensajeBD;

	public Integer getResultado()
	{
		return resultado;
	}

	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	public String getMensajeBD()
	{
		return mensajeBD;
	}

	public void setMensajeBD(String mensajeBD)
	{
		this.mensajeBD = mensajeBD;
	}

}
