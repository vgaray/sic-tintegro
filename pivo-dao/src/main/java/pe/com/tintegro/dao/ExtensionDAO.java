package pe.com.tintegro.dao;

import pe.com.tintegro.dto.response.ListaExtensionResponse;

public interface ExtensionDAO {

	public ListaExtensionResponse listaExtension(String ip) throws Exception;
}
