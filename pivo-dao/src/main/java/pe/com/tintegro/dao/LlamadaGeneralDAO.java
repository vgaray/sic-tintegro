package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.response.ListaLlamadaGeneralResponse;

public interface LlamadaGeneralDAO
{
	public ListaLlamadaGeneralResponse listallamadaGeneral(String ip, ListaLlamadaGeneralRequest request) throws Exception;
	public ListaLlamadaGeneralResponse listaReportellamadaGeneral(String ip, ListaLlamadaGeneralRequest request) throws Exception;
}
