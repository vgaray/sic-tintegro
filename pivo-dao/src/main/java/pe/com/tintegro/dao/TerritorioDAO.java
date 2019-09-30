package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;

public interface TerritorioDAO {
	
public ListaTerritorioResponse listaTerritorio(ListaTerritorioRequest request)throws Exception;

}
