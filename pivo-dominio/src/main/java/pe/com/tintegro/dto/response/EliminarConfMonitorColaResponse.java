package pe.com.tintegro.dto.response;

public class EliminarConfMonitorColaResponse extends ResponseBase
{
	private Integer eliminado;
	private String mensaje;
	
	public Integer getEliminado()
	{
		return eliminado;
	}
	public void setEliminado(Integer eliminado)
	{
		this.eliminado = eliminado;
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
