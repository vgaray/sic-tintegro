package pe.com.tintegro.dto.response;

import java.util.List;


public class ListaControlRolEstadoResponse extends ResponseBase
{
	private List<String> validarControlResult;

	public List<String> getValidarControlResult()
	{
		return validarControlResult;
	}

	public void setValidarControlResult(List<String> validarControlResult)
	{
		this.validarControlResult = validarControlResult;
	}
}
