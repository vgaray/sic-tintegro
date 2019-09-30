package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaModeloTelefonoPorMarcaRequest;
import pe.com.tintegro.dto.response.ListaModeloTelefonoPorMarcaResponse;

public interface ModeloTelefonoServices
{
	public ListaModeloTelefonoPorMarcaResponse listaModeloTelefonoPorMarca(
			String codUsuario,String idInstancia,ListaModeloTelefonoPorMarcaRequest request) throws Exception;
}
