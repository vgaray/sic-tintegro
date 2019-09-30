package pe.com.tintegro.dto.response;

public class ActualizarCentralExternaResponse extends ResponseBase
{
	private Integer idRasult;
	private String mensajeRes;
	public Integer getIdRasult()
	{
		return idRasult;
	}
	public void setIdRasult(Integer idRasult)
	{
		this.idRasult = idRasult;
	}
	public String getMensajeRes()
	{
		return mensajeRes;
	}
	public void setMensajeRes(String mensajeRes)
	{
		this.mensajeRes = mensajeRes;
	}
}
