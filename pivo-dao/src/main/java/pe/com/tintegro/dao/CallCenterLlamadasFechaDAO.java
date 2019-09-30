package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;

public interface CallCenterLlamadasFechaDAO {
	
	//Listas
	ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadasAbandonadas (String ip, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception;
	
	ListaLlamadasContestadasResponse listaLlamadasContestadas ( String ip, ListaLlamadasContestadasRequest request ) throws Exception;
	
	ListaLlamadaAgenteResponse listaLlamadaAgente ( String ip , ListaLlamadaAgenteRequest request) throws Exception;
	
	ListaReporteAbandonosResponse listaReporteAbandono (String ip, ListaReporteAbandonosRequest request) throws Exception;
	
	
	//Reportes
	ListaLlamadasAtendidasAbandonadasFechaResponse listaReporteLlamadasAtAbFecha (String ip, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception;
	ListaLlamadasContestadasResponse listaReporteLlamadasContestadas(String ip, ListaLlamadasContestadasRequest request) throws Exception;
	ListaReporteAbandonosResponse listaReporteEAbandonos (String ip, ListaReporteAbandonosRequest request) throws Exception;
	
}
