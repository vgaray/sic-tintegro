package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.StatusBash;

public class CargaEstadoConfigInstanciaResponse extends ResponseBase
{
	private List< StatusBash > lsStatusBash;

	public List< StatusBash > getLsStatusBash()
	{
		return lsStatusBash;
	}

	public void setLsStatusBash(List< StatusBash > lsStatusBash)
	{
		this.lsStatusBash = lsStatusBash;
	}
}
