package pe.com.tintegro.dto.response;

public class InsertaBolsaEmpresaResponse extends ResponseBase
{
	private Integer resultado;
	private String nomMensaje;

	public Integer getResultado()
	{
		return resultado;
	}

	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	public String getNomMensaje()
	{
		return nomMensaje;
	}

	public void setNomMensaje(String nomMensaje)
	{
		this.nomMensaje = nomMensaje;
	}

}
