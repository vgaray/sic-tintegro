package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;

public class ListaInstanciaResponse extends ResponseBase
{
   private List<InstanciaServerAsterisk> instancias;

	public List<InstanciaServerAsterisk> getInstancias()
	{
		return instancias;
	}

	public void setInstancias(List<InstanciaServerAsterisk> instancias)
	{
		this.instancias = instancias;
	}
   
   
}
