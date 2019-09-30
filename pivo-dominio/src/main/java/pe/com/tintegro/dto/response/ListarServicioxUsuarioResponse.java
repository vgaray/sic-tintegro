package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.InstanciaServicioxUsuario;

public class ListarServicioxUsuarioResponse extends ResponseBase 
{
	private List<InstanciaServicioxUsuario> ServicioxUsuario;

	public List<InstanciaServicioxUsuario> getServicioxUsuario()
	{
		return ServicioxUsuario;
	}

	public void setServicioxUsuario(List<InstanciaServicioxUsuario> servicioxUsuario)
	{
		ServicioxUsuario = servicioxUsuario;
	}


	
	
}
