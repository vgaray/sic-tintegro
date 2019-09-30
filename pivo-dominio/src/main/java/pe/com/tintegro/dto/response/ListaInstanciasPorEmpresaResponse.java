package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;

public class ListaInstanciasPorEmpresaResponse extends ResponseBase
{
	private List<InstanciaServerAsterisk> listaInstanciaEmpresa;

	public List<InstanciaServerAsterisk> getListaInstanciaEmpresa()
	{
		return listaInstanciaEmpresa;
	}

	public void setListaInstanciaEmpresa(List<InstanciaServerAsterisk> listaInstanciaEmpresa)
	{
		this.listaInstanciaEmpresa = listaInstanciaEmpresa;
	}

}
