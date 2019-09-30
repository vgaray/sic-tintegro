package pe.com.tintegro.dto.response;

public class ActualizarRingGroupResponse extends ResponseBase
{
	private int idRasultEstado;
	private String mensajeValidacion;
	public int getIdRasultEstado()
	{
		return idRasultEstado;
	}
	public void setIdRasultEstado(int idRasultEstado)
	{
		this.idRasultEstado = idRasultEstado;
	}
	public String getMensajeValidacion()
	{
		return mensajeValidacion;
	}
	public void setMensajeValidacion(String mensajeValidacion)
	{
		this.mensajeValidacion = mensajeValidacion;
	}
	
		
}
