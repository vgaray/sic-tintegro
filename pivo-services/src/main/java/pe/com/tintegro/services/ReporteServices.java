package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAbandonadasPorMinutoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAtendidasAbandonadasRequest;
import pe.com.tintegro.dto.request.ListarLlamadasEntrantesPorHoraRequest;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadaGeneralResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;
import pe.com.tintegro.dto.response.ListarLlamadaDestinoResponse;
import pe.com.tintegro.dto.response.ListarLlamadasAbandonadasPorMinutoResponse;
import pe.com.tintegro.dto.response.ListarLlamadasAtendidasAbandonadasResponse;
import pe.com.tintegro.dto.response.ListarLlamadasEntrantesPorHoraResponse;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;

public interface ReporteServices
{
	//Listar
	public ListaLlamadaGeneralResponse ListallamadaGeneral(String codUsuario,String idInstancia, ListaLlamadaGeneralRequest request) throws Exception;
	public ListaLlamadaUsuarioResponse listaLlamadaUsuario(String codUsuario,String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception;
	public ListarLlamadaDestinoResponse listaLlamadaDestino(String codUsuario, String idInstancia,ListarLlamadaDestinoRequest request)throws Exception;
	//Listas Usadas en los reportes
	public ListaLlamadaGeneralResponse ListaReportellamadaGeneral(String codUsuario,String idInstancia, ListaLlamadaGeneralRequest request) throws Exception;
	public ListaLlamadaUsuarioResponse listaReporteLlamadaUsuario(String codUsuario,String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception;
	//Reporte
	public ListaLlamadaGeneralResponse reporteLlamadaGeneral(String codUsuario,String idInstancia, ListaLlamadaGeneralRequest request) throws Exception;
	public ListaLlamadaUsuarioResponse reporteLlamadaUsuario(String codUsuario,String idInstancia, ListaLlamadaUsuarioRequest request) throws Exception;
	public RankingLlamadasResponse reporteRankingLlamadas(String codUsuario,String idInstancia, RankingLlamadasRequest request) throws Exception;
	public ListarLlamadaDestinoResponse reporteLlamadaDestino(String codUsuario,String idInstancia, ListarLlamadaDestinoRequest request) throws Exception;



	//CallCenter
	public ListaLlamadasAtendidasAbandonadasFechaResponse reporteLlamadaAtendidaAbandonadaFecha(String codUsuario,String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception;
    public ListaLlamadasContestadasResponse reporteLlamadasContestadas(String codUsuario, String idInstancia, ListaLlamadasContestadasRequest request) throws Exception;
    public ListaLlamadaAgenteResponse reporteListaLlamadasAgente(String codUsuario, String idInstancia, ListaLlamadaAgenteRequest request) throws Exception;
    public ListaReporteAbandonosResponse reporteListaReporteAbandonos(String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception;


    public ListarLlamadasAtendidasAbandonadasResponse listarReporteLlamadasAtendidasAbandonadas(String codUsuario, String instancia, ListarLlamadasAtendidasAbandonadasRequest request) throws Exception;
	public ListarLlamadasEntrantesPorHoraResponse listarReporteLlamadasEntrantesPorHora(String codUsuario, String instancia, ListarLlamadasEntrantesPorHoraRequest request) throws Exception;
	public ListarLlamadasAbandonadasPorMinutoResponse listarReporteLlamadasAbandonadasPorMinuto(String codUsuario, String instancia, ListarLlamadasAbandonadasPorMinutoRequest request) throws Exception;


	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidadaAgente(String codUsuario, String idInstancia,ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request)throws Exception;
	
	public ListarReporteAtencionClienteCallCenterResponse reporteAtencionCliente(String codUsuario, String idInstancia,ListarReporteAtencionClienteCallCenterRequest request)throws Exception;
	
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse reporteConsolidadoLlamadaRecibida(String codUsuario, String idInstancia,ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request)throws Exception;

	public ListarReporteLlamadaDiaHoraCallCenterResponse reporteLlamadaDia (String codUsuario, String idInstancia,ListarReporteLlamadaDiaHoraCallCenterRequest request)throws Exception;
	

}
