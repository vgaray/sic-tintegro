package pe.com.tintegro.dto.response;

public class EliminaBolsaEmpresaResponse extends ResponseBase
{
	private Integer resultado;
	private String mensajeResult;

	public Integer getResultado()
	{
		return resultado;
	}

	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	public String getMensajeResult()
	{
		return mensajeResult;
	}

	public void setMensajeResult(String mensajeResult)
	{
		this.mensajeResult = mensajeResult;
	}

}
