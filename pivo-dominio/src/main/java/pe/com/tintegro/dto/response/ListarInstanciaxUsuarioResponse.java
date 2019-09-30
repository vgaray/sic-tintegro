package pe.com.tintegro.dto.response;


import java.util.List;

import pe.com.tintegro.dominio.InstanciaServicioxUsuario;

public class ListarInstanciaxUsuarioResponse
{
	private List<InstanciaServicioxUsuario> InstanciaxUsuario;

	public List<InstanciaServicioxUsuario> getInstanciaxUsuario()
	{
		return InstanciaxUsuario;
	}

	public void setInstanciaxUsuario(List<InstanciaServicioxUsuario> instanciaxUsuario)
	{
		InstanciaxUsuario = instanciaxUsuario;
	}
		
}
