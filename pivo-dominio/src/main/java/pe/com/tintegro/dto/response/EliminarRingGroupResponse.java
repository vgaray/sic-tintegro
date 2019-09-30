package pe.com.tintegro.dto.response;

public class EliminarRingGroupResponse extends ResponseBase
{
	private Integer id_rasult;
	private String mensaje;
	public Integer getId_rasult()
	{
		return id_rasult;
	}
	public void setId_rasult(Integer id_rasult)
	{
		this.id_rasult = id_rasult;
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
