package pe.com.tintegro.dto.response;

import pe.com.tintegro.dominio.Confirmacion;

public class ValidaAccesoAInstanciaResponse
{
	private Confirmacion confirmacion;

	public Confirmacion getConfirmacion()
	{
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion)
	{
		this.confirmacion = confirmacion;
	}
}
