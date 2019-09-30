package pe.com.tintegro.dao;


import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.response.ListarLlamadaDestinoResponse;
public interface LlamadaDestinoDAO
{
	public ListarLlamadaDestinoResponse listaLlamadaDestino (String ip,ListarLlamadaDestinoRequest request)
			throws Exception;

	}
