package pe.com.tintegro.dto.request;

public class EliminarCustomTrunkRequest extends RequestBase
{
	private int pIdCustomTrunk;
	private String nombre;
	private Integer tipo;
	private String detalle;
   private String context;
    
	public int getpIdCustomTrunk()
	{
		return pIdCustomTrunk;
	}

	public void setpIdCustomTrunk(int pIdCustomTrunk)
	{
		this.pIdCustomTrunk = pIdCustomTrunk;
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
