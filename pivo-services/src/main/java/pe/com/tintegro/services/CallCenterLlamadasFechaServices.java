package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;

public interface CallCenterLlamadasFechaServices {

	public ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadaAtendidasAbandonadas(String codUsuario, String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception;
	
	public ListaLlamadasContestadasResponse listaLlamadaContestada( String codUsuario, String idInstancia , ListaLlamadasContestadasRequest request) throws Exception;
	
	public ListaLlamadaAgenteResponse listaLlamadaAgente ( String codUsuario, String idInstancia, ListaLlamadaAgenteRequest request) throws Exception;
	
	public ListaReporteAbandonosResponse listaReporteAbandonos (String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception;

	//Reportes
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaReporteLlamadaAtendidasAbandonadas(String codUsuario, String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception;
	public ListaLlamadasContestadasResponse listaReporteLlamadasContestadas(String codUsuario, String idInstancia, ListaLlamadasContestadasRequest request) throws Exception;	
	public ListaReporteAbandonosResponse listaReporteEAbandonos(String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception;
	
}
