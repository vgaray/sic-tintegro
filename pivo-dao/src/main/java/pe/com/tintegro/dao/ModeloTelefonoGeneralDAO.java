package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;

public interface ModeloTelefonoGeneralDAO
{
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarcaGeneral(ListaModeloTelefonoPorMarcaRequest request) throws Exception;
}
