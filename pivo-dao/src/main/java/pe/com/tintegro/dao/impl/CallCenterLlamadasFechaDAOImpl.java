package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.CallCenterLlamadasFechaDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.LlamadaAgente;
import pe.com.tintegro.dominio.LlamadasAtendidasAbandonadasFechas;
import pe.com.tintegro.dominio.LlamadasContestadas;
import pe.com.tintegro.dominio.ReporteAbandonos;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;

@Repository("callCenterLlamadasFechaDAO")
public class CallCenterLlamadasFechaDAOImpl extends DAOTintegroImpl implements CallCenterLlamadasFechaDAO {

	// reportes.llamada_abandonas_minutos_rango_fecha - paginado
	@Override
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadasAbandonadas(String ipUsuario, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception {
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUsuario);
		try {
			String storedProcedureName = "reportes.llamada_abandonas_minutos_rango_fecha";
			Object[][] params = { 
					{ request.getpQueuename(), String.class }, 
					{ request.getpFeIni(), String.class }, 
					{ request.getpFeFin(), String.class }, 
					{ request.getpNuPagina(), Integer.class }, 
					{ request.getpNuReg(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id_llamada", "idLlamada");
			mapCol.put("fe_rango", "fecha");
			mapCol.put("nu_llam", "atendidas");
			mapCol.put("aba_menor", "abandonadasMenor");
			mapCol.put("aba_mayor", "abandonadasMayor");
			mapCol.put("nu_total_reg", "nuTotalReg");

			Response<LlamadasAtendidasAbandonadasFechas> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadasAtendidasAbandonadasFechas.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadasAtendidasAbandonadas(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// reportes.llamada_contestada_ac - paginado
	@Override
	public ListaLlamadasContestadasResponse listaLlamadasContestadas(String ipUsuario, ListaLlamadasContestadasRequest request) throws Exception {
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUsuario);
		try {
			String storedProcedure = "reportes.llamada_contestada_ac";
			Object[][] params = { 
					{ request.getVaQueue(), String.class }, 
					{ request.getIdAgente(), Integer.class }, 
					{ request.getFeIniCon(), String.class }, 
					{ request.getFeFinCon(), String.class }, 
					{ request.getHoraIniC(), String.class }, 
					{ request.getHoraFinC(), String.class },
					{ request.getpNuPagina(), Integer.class }, 
					{ request.getpNuReg(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id", "idLlamadaC");
			mapCol.put("no_queue", "noCola");
			mapCol.put("no_agente", "noAgente");
			mapCol.put("fe_act", "fecha");
			mapCol.put("ho_act", "hora");
			mapCol.put("ti_dur", "duracion");
			mapCol.put("nu_act", "numero");
			mapCol.put("nu_total_reg", "nuTotalReg");

			Response<LlamadasContestadas> responseT = BaseDao.baseData(storedProcedure, params, db.con, LlamadasContestadas.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsLContestadas(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// reportes.llamada_agente - no
	@Override
	public ListaLlamadaAgenteResponse listaLlamadaAgente(String ipUsuario, ListaLlamadaAgenteRequest request) throws Exception {
		ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUsuario);
		try {
			String storedProcedure = "reportes.llamada_agente";
			Object[][] params = { 
					{ request.getIdAgente(), Integer.class }, 
					{ request.getFeIniCon(), String.class }, 
					{ request.getFeFinCon(), String.class }, 
					{ request.getHoraI(), String.class }, 
					{ request.getHoraF(), String.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("fecha_hora", "fechaHora");
			mapCol.put("id_agente", "idAgente");
			mapCol.put("no_agente", "noAgente");
			mapCol.put("nu_llamate", "llamadasAtendidas");
			mapCol.put("nu_llamculcli", "llamadasCulCli");
			mapCol.put("nu_llamculage", "llamadasCulAge");
			mapCol.put("ca_hablad", "tiempoHablado");
			mapCol.put("ca_prohab", "tPromHablado");
			mapCol.put("ca_minhab", "tMinHablado");
			mapCol.put("ca_maxhab", "tMaxHablado");

			Response<LlamadaAgente> responseT = BaseDao.baseData(storedProcedure, params, db.con, LlamadaAgente.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsLAgente(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// reportes.reporte_abandonos - paginado
	@Override
	public ListaReporteAbandonosResponse listaReporteAbandono(String ip, ListaReporteAbandonosRequest request) throws Exception {
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "reportes.reporte_abandonos";
			Object[][] params = { 
					{ request.getNoQueue(), String.class }, 
					{ request.getFeIniCon(), String.class }, 
					{ request.getFeFinCon(), String.class }, 
					{ request.getpNuPagina(), Integer.class }, 
					{ request.getpNuReg(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("uniqueid", "uniqueId");
			mapCol.put("queuename", "queueName");
			mapCol.put("fecha", "fecha");
			mapCol.put("qtime", "qTime");
			mapCol.put("info3", "info3");
			mapCol.put("nu_min", "nuMin");
			mapCol.put("numero", "numero");
			mapCol.put("nu_total_reg", "nuTotalReg");

			Response<ReporteAbandonos> responseT = BaseDao.baseData(storedProcedure, params, db.con, ReporteAbandonos.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsReporteAbandonos(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// Reportes
	// Reporte Lista llamadas aten aban fecha Excel
	@Override
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaReporteLlamadasAtAbFecha(String ip, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception {
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_abandonas_minutos_rango_fecha";
			Object[][] params = { 
					{ request.getpQueuename(), String.class }, 
					{ request.getpFeIni(), String.class }, 
					{ request.getpFeFin(), String.class } };
			
			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id_llamada", "idLlamada");
			mapCol.put("fe_rango", "fecha");
			mapCol.put("nu_llam", "atendidas");
			mapCol.put("aba_menor", "abandonadasMenor");
			mapCol.put("aba_mayor", "abandonadasMayor");
			Response<LlamadasAtendidasAbandonadasFechas> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadasAtendidasAbandonadasFechas.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadasAtendidasAbandonadas(responseT.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	// Reporte Llam Contestadas Excel
	@Override
	public ListaLlamadasContestadasResponse listaReporteLlamadasContestadas(String ip, ListaLlamadasContestadasRequest request) throws Exception {
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "reportes.llamada_contestada_ac";
			Object[][] params = { 
					{ request.getVaQueue(), String.class }, 
					{ request.getIdAgente(), Integer.class }, 
					{ request.getFeIniCon(), String.class },
					{ request.getFeFinCon(), String.class }, 
					{ request.getHoraIniC(), String.class }, 
					{ request.getHoraFinC(), String.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id", "idLlamadaC");
			mapCol.put("no_queue", "noCola");
			mapCol.put("no_agente", "noAgente");
			mapCol.put("fe_act", "fecha");
			mapCol.put("ho_act", "hora");
			mapCol.put("ti_dur", "duracion");
			mapCol.put("nu_act", "numero");

			Response<LlamadasContestadas> responseT = BaseDao.baseData(storedProcedure, params, db.con, LlamadasContestadas.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsLContestadas(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// Reporte Lista Abandonos Excel
	@Override
	public ListaReporteAbandonosResponse listaReporteEAbandonos(String ip, ListaReporteAbandonosRequest request) throws Exception {
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "reportes.reporte_abandonos";
			Object[][] params = { 
					{ request.getNoQueue(), String.class }, 
					{ request.getFeIniCon(), String.class }, 
					{ request.getFeFinCon(), String.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("uniqueid", "uniqueId");
			mapCol.put("queuename", "queueName");
			mapCol.put("fecha", "fecha");
			mapCol.put("qtime", "qTime");
			mapCol.put("info3", "info3");
			mapCol.put("nu_min", "nuMin");
			mapCol.put("numero", "numero");

			Response<ReporteAbandonos> responseT = BaseDao.baseData(storedProcedure, params, db.con, ReporteAbandonos.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsReporteAbandonos(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}