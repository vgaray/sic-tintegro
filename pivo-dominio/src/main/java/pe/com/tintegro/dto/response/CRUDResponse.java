package pe.com.tintegro.dto.response;

public class CRUDResponse extends ResponseBase
{
	private Integer idResult;
	private String mensajeValidacion;

	public Integer getIdResult()
	{
		return idResult;
	}

	public void setIdResult(Integer idResult)
	{
		this.idResult = idResult;
	}

	public String getMensajeValidacion()
	{
		return mensajeValidacion;
	}

	public void setMensajeValidacion( String mensajeValidacion)
	{
		this.mensajeValidacion = mensajeValidacion;
	}
}
