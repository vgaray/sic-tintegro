package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.ListaReporteCallCenterDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.ReporteConsolidadoLlamadaRecibidaCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaConsolidadaAgenteCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;


@Repository("listaReporteCallCenterDAO")
public class ListaReporteCallCenterDAOImpl implements ListaReporteCallCenterDAO {

	@Override
	public ListarReporteAtencionClienteCallCenterResponse listaReporteAtencionClienteCallCenter(String ip, ListarReporteAtencionClienteCallCenterRequest request) throws Exception {
		ListarReporteAtencionClienteCallCenterResponse response = new ListarReporteAtencionClienteCallCenterResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.respuesta_operador";
			Object[][] params = { 
					{ request.getTiReport(), String.class }, 
					{ request.getVaTab(), Integer.class }, 
					{ request.getVaNsv(), Integer.class }, 
					{ request.getFeReport(), String.class }, 
					{ request.getNoQueue(), String.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("fe_llamad", "feLlamad");
			mapColumnToAttributte.put("lla_entra", "llaEntra");
			mapColumnToAttributte.put("lla_atendi", "llaAtendi");
			mapColumnToAttributte.put("lla_atetab", "llaAtetab");
			mapColumnToAttributte.put("lla_abando", "llaAbando");
			mapColumnToAttributte.put("lla_abatab", "llaAbatab");
			// -------------------extras x bd--------------------
			mapColumnToAttributte.put("lla_disuac", "llaDisuac");
			mapColumnToAttributte.put("lla_atens", "llaAtens");
			mapColumnToAttributte.put("ti_abando", "tiAbando");
			// ///////////////////////////////////////////////////
			mapColumnToAttributte.put("porcentaje_total_abandonos", "porcentajeTotalAbandonos");
			mapColumnToAttributte.put("porcentaje_tab_abandonos", "porcentajeTabAbandonos");
			mapColumnToAttributte.put("porcentaje_ro_eficacia", "porcentajeRoEficacia");
			mapColumnToAttributte.put("porcentaje_nsv_eficacia", "porcentajeNsvEficacia");
			mapColumnToAttributte.put("ti_ema", "tiEma");
			mapColumnToAttributte.put("ti_proesp", "tiProesp");
			mapColumnToAttributte.put("ti_procon", "tiProcon");

			Response<ReporteAtencionClienteCallCenter> responseA = BaseDao.baseData(storedProcedureName, params, db.con, ReporteAtencionClienteCallCenter.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsreporteAtencionCliente(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarReporteLlamadaDiaHoraCallCenterResponse listaReporteLlamadaDiaHoraCallCenter(String ip, ListarReporteLlamadaDiaHoraCallCenterRequest request) throws Exception {
		ListarReporteLlamadaDiaHoraCallCenterResponse response = new ListarReporteLlamadaDiaHoraCallCenterResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_dia_hora";
			Object[][] params = { 
					{ request.getNoCola(), String.class }, 
					{ request.getFeInicon(), String.class }, 
					{ request.getFeFincon(), String.class }, };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("dia", "dia");
			mapColumnToAttributte.put("llama00", "llama00");
			mapColumnToAttributte.put("llama01", "llama01");
			mapColumnToAttributte.put("llama02", "llama02");
			mapColumnToAttributte.put("llama03", "llama03");
			mapColumnToAttributte.put("llama04", "llama04");
			mapColumnToAttributte.put("llama05", "llama05");
			mapColumnToAttributte.put("llama06", "llama06");
			mapColumnToAttributte.put("llama07", "llama07");
			mapColumnToAttributte.put("llama08", "llama08");
			mapColumnToAttributte.put("llama09", "llama09");
			mapColumnToAttributte.put("llama10", "llama10");
			mapColumnToAttributte.put("llama11", "llama11");
			mapColumnToAttributte.put("llama12", "llama12");
			mapColumnToAttributte.put("llama13", "llama13");
			mapColumnToAttributte.put("llama14", "llama14");
			mapColumnToAttributte.put("llama15", "llama15");
			mapColumnToAttributte.put("llama16", "llama16");
			mapColumnToAttributte.put("llama17", "llama17");
			mapColumnToAttributte.put("llama18", "llama18");
			mapColumnToAttributte.put("llama19", "llama19");
			mapColumnToAttributte.put("llama20", "llama20");
			mapColumnToAttributte.put("llama21", "llama21");
			mapColumnToAttributte.put("llama22", "llama22");
			mapColumnToAttributte.put("llama23", "llama23");

			Response<ReporteLlamadaDiaHoraCallCenter> responseA = BaseDao.baseData(storedProcedureName, params, db.con, ReporteLlamadaDiaHoraCallCenter.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsreporteLlamadaDiaHora(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse listarReporteLlamadaConsolidadaAgenteCallCenter(String ip, ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request) throws Exception {
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_consolidado_new";
			Object[][] params = { 
					{ request.getFeInicon(), String.class }, 
					{ request.getFeFincon(), String.class }, 
					{ request.getpHorai(), String.class }, 
					{ request.getpHoraf(), String.class }, 
					{ request.getpNuPagina(), Integer.class }, 
					{ request.getpNuRegMostras(), Integer.class } };
			
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("anexo", "anexo");
			mapColumnToAttributte.put("e_contestada", "eContestada");
			mapColumnToAttributte.put("e_nocontestada", "eNoContestada");
			mapColumnToAttributte.put("e_fallida", "eFallida");
			mapColumnToAttributte.put("total_entrante", "totalEntrante");
			mapColumnToAttributte.put("total_inhablando", "totalInhablando");
			mapColumnToAttributte.put("total_inhablando2", "totalInhablando2");
			mapColumnToAttributte.put("s_contestada", "sContestada");
			mapColumnToAttributte.put("s_nocontestada", "sNocontestada");
			mapColumnToAttributte.put("s_fallida", "sFallida");
			mapColumnToAttributte.put("total_saliente", "totalSaliente");
			mapColumnToAttributte.put("total_outhablando", "totalOuthablando");
			mapColumnToAttributte.put("total_outhablando2", "totalOuthablando2");
			mapColumnToAttributte.put("total_registros", "totalRegistros");

			Response<ReporteLlamadaConsolidadaAgenteCallCenter> responseA = BaseDao.baseData(storedProcedureName, params, db.con, ReporteLlamadaConsolidadaAgenteCallCenter.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsreporteLlamadaConsolidadaAgente(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse listarReporteConsolidadoLlamadaRecibidaCallCenter(String ip, ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request) throws Exception {
		ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = new ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.consolidado_llamadas_recibidas";
			Object[][] params = { 
					{ request.getQueueName(), String.class }, 
					{ request.getFeIni(), String.class }, 
					{ request.getFeFin(), String.class } };
			
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("no_queuename", "noQueuename");
			mapColumnToAttributte.put("no_mes", "noMes");
			mapColumnToAttributte.put("no_dia", "noDia");
			mapColumnToAttributte.put("no_dia_semana", "noDiaSemana");
			mapColumnToAttributte.put("nu_cantidad", "nuCantidad");
			mapColumnToAttributte.put("nu_año", "nuAnio");

			Response<ReporteConsolidadoLlamadaRecibidaCallCenter> responseA = BaseDao.baseData(storedProcedureName, params, db.con, ReporteConsolidadoLlamadaRecibidaCallCenter.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsreporteConsolidadoLlamadaRecibida(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidadaAgenteCallCenter(String ip, ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request) throws Exception {
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_consolidado_new";
			Object[][] params = { 
					{ request.getFeInicon(), String.class }, 
					{ request.getFeFincon(), String.class }, 
					{ request.getpHorai(), String.class }, 
					{ request.getpHoraf(), String.class }, };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("anexo", "anexo");
			mapColumnToAttributte.put("e_contestada", "eContestada");
			mapColumnToAttributte.put("e_nocontestada", "eNoContestada");
			mapColumnToAttributte.put("e_fallida", "eFallida");
			mapColumnToAttributte.put("total_entrante", "totalEntrante");
			mapColumnToAttributte.put("total_inhablando", "totalInhablando");
			mapColumnToAttributte.put("total_inhablando2", "totalInhablando2");
			mapColumnToAttributte.put("s_contestada", "sContestada");
			mapColumnToAttributte.put("s_nocontestada", "sNocontestada");
			mapColumnToAttributte.put("s_fallida", "sFallida");
			mapColumnToAttributte.put("total_saliente", "totalSaliente");
			mapColumnToAttributte.put("total_outhablando", "totalOuthablando");
			mapColumnToAttributte.put("total_outhablando2", "totalOuthablando2");

			Response<ReporteLlamadaConsolidadaAgenteCallCenter> responseA = BaseDao.baseData(storedProcedureName, params, db.con, ReporteLlamadaConsolidadaAgenteCallCenter.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsreporteLlamadaConsolidadaAgente(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}