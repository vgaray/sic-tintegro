package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;

public interface CallCenterServices {

	ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadasAbandonadas(String codUsuario, String idInstancia ,ListaLlamadasAtendidasAbandonadasFechaRequest request ) throws Exception;
	
}
