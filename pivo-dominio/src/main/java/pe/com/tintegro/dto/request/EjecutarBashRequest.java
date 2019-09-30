package pe.com.tintegro.dto.request;

import pe.com.tintegro.dominio.StatusBash;

public class EjecutarBashRequest extends RequestBase
{
	private StatusBash statusBash;

	public StatusBash getStatusBash()
	{
		return statusBash;
	}

	public void setStatusBash(StatusBash statusBash)
	{
		this.statusBash = statusBash;
	}
}
