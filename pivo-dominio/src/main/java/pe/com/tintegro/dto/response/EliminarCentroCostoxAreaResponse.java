package pe.com.tintegro.dto.response;


public class EliminarCentroCostoxAreaResponse extends ResponseBase
{
	private int eliminar;
	private String validar;

	public int getEliminar()
	{
		return eliminar;
	}

	public void setEliminar(int eliminar)
	{
		this.eliminar = eliminar;
	}

	public String getValidar()
	{
		return validar;
	}

	public void setValidar(String validar)
	{
		this.validar = validar;
	}

}
