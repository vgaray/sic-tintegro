package pe.com.tintegro.dto.request;

public class ActualizarCustomTrunkRequest extends RequestBase
{
	private Integer idCustomTrunk;
	private String nombre;
	private Integer tipo;
	private String detalle;
	 private String context;

	public Integer getIdCustomTrunk()
	{
		return idCustomTrunk;
	}

	public void setIdCustomTrunk(Integer idCustomTrunk)
	{
		this.idCustomTrunk = idCustomTrunk;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Integer getTipo()
	{
		return tipo;
	}

	public void setTipo(Integer tipo)
	{
		this.tipo = tipo;
	}

	public String getDetalle()
	{
		return detalle;
	}

	public void setDetalle(String detalle)
	{
		this.detalle = detalle;
	}

	public String getContext()
	{
		return context;
	}
	
	public void setContext(String context)
	{
		this.context = context;
	}
}
