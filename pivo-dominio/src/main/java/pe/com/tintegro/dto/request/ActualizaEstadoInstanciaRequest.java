package pe.com.tintegro.dto.request;

public class ActualizaEstadoInstanciaRequest extends RequestBase
{
	private Integer idEstadoInstancia;

	public Integer getIdEstadoInstancia()
	{
		return idEstadoInstancia;
	}

	public void setIdEstadoInstancia(Integer idEstadoInstancia)
	{
		this.idEstadoInstancia = idEstadoInstancia;
	}
}
