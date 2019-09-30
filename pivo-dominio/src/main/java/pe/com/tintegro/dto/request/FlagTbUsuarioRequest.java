package pe.com.tintegro.dto.request;

public class FlagTbUsuarioRequest extends RequestBase
{

	private int idUsupin;

	public Integer getEstado()
	{
		return estado;
	}

	public void setEstado(Integer estado)
	{
		this.estado = estado;
	}

	private Integer estado;

	public int getIdUsupin()
	{
		return idUsupin;
	}

	public void setIdUsupin(int idUsupin)
	{
		this.idUsupin = idUsupin;
	}

	public FlagTbUsuarioRequest()
	{
		super();
		// TODO Auto-generated constructor stub
	}

}
