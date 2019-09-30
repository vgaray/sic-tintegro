package pe.com.tintegro.dto.response;


public class EliminarCustomTrunkResponse  extends ResponseBase 
{
	private int idRasult;
	private String mensaje;
	public int getIdRasult()
	{
		return idRasult;
	}
	public void setIdRasult(int idRasult)
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
