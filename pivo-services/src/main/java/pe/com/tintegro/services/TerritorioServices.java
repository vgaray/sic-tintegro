package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;

public interface TerritorioServices {

	public ListaTerritorioResponse listaTerritorio(ListaTerritorioRequest request)throws Exception;
}
