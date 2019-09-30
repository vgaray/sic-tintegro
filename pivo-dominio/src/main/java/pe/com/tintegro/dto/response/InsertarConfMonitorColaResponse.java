package pe.com.tintegro.dto.response;

public class InsertarConfMonitorColaResponse extends ResponseBase
{
	private Integer insertado;
	private String mensaje;
	
	public Integer getInsertado()
	{
		return insertado;
	}
	public void setInsertado(Integer insertado)
	{
		this.insertado = insertado;
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
