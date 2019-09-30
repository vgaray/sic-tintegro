package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;

public interface ModeloTelefonoDAO
{
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(String ip,ListaModeloTelefonoPorMarcaRequest request)
			throws Exception;
}
