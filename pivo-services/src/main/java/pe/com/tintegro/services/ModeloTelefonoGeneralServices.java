package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;

public interface ModeloTelefonoGeneralServices
{
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(String codUsuario, ListaModeloTelefonoPorMarcaRequest request) throws Exception;
}
