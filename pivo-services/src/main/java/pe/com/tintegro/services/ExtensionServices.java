package pe.com.tintegro.services;

import pe.com.tintegro.dto.response.ListaExtensionResponse;

public interface ExtensionServices {

	public ListaExtensionResponse listaextension(String codUsuario,String idInstancia)throws Exception;
}
