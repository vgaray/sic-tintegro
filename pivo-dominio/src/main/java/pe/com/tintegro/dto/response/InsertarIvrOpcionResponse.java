package pe.com.tintegro.dto.response;

public class InsertarIvrOpcionResponse extends ResponseBase
{
	Integer idResult;
   String mensaje ;
   Integer id;
   
   public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getIdResult()
	{
		return idResult;
	}
	public void setIdResult(Integer idResult)
	{
		this.idResult = idResult;
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
