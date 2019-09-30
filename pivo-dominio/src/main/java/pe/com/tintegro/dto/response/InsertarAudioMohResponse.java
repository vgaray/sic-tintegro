package pe.com.tintegro.dto.response;

public class InsertarAudioMohResponse extends ResponseBase
{
	private Integer idRasult;
	private String mensaje;

	public Integer getIdRasult()
	{
		return idRasult;
	}

	public void setIdRasult(Integer idRasult)
	{
		this.idRasult = idRasult;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

}
