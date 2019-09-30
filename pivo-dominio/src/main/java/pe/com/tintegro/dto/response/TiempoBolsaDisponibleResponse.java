package pe.com.tintegro.dto.response;

public class TiempoBolsaDisponibleResponse extends ResponseBase
{
	private Integer resultado;
	private String minDisponible;

	public Integer getResultado()
	{
		return resultado;
	}

	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	public String getMinDisponible()
	{
		return minDisponible;
	}

	public void setMinDisponible(String minDisponible)
	{
		this.minDisponible = minDisponible;
	}

}
