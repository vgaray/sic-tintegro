package pe.com.tintegro.dto.response;

public class ActualizarConfMonitorColaResponse extends ResponseBase
{
	private Integer actualizado;
	private String mensaje;
	
	public Integer getActualizado()
	{
		return actualizado;
	}
	public void setActualizado(Integer actualizado)
	{
		this.actualizado = actualizado;
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
