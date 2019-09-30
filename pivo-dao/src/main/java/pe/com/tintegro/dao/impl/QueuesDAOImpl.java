package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.QueuesDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Queues;
import pe.com.tintegro.dto.request.ActualizarQueuesRequest;
import pe.com.tintegro.dto.request.BuscarQueuesRequest;
import pe.com.tintegro.dto.request.EliminarQueuesRequest;
import pe.com.tintegro.dto.request.InsertarQueuesRequest;
import pe.com.tintegro.dto.request.ListarAgenteDisponiblesRequest;
import pe.com.tintegro.dto.request.ListarQueuesRequest;
import pe.com.tintegro.dto.response.ActualizarQueuesResponse;
import pe.com.tintegro.dto.response.BuscarQueuesResponse;
import pe.com.tintegro.dto.response.EliminarQueuesResponse;
import pe.com.tintegro.dto.response.InsertarQueuesResponse;
import pe.com.tintegro.dto.response.ListarAgenteDisponiblesResponse;
import pe.com.tintegro.dto.response.ListarQueuesResponse;

@Repository("queuesDAO")
public class QueuesDAOImpl extends DAOTintegroImpl implements QueuesDAO {

	@Override
	public ListarQueuesResponse listarQueues(String ip, ListarQueuesRequest request) throws Exception {
		ListarQueuesResponse response = new ListarQueuesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_queues";
			Object[][] params = {};
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_queues", "idQueues");
			map.put("name", "name");
			map.put("musiconhold", "musiconHold");
			map.put("announce", "announce");
			map.put("weight", "weight");
			map.put("timeout", "timeOut");

			Response<Queues> responseA = BaseDao.baseData(storedProcedure, params, db.con, Queues.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setColaLista((ArrayList<Queues>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarQueuesResponse insertarQueues(String ip, InsertarQueuesRequest request) throws Exception {
		InsertarQueuesResponse response = new InsertarQueuesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedure = "asterisk.fn_insertar_queues";
			Object[][] params = { 
					{ request.getName(), String.class }, 
					{ request.getMusiconHold(), String.class }, 
					{ request.getAnnounce(), String.class }, 
					{ request.getContext(), String.class }, 
					{ request.getTimeOut(), Integer.class }, 
					{ request.getMonitorJoin(), String.class },
					{ request.getMonitorFormat(), String.class }, 
					{ request.getQueueYouAreNext(), String.class }, 
					{ request.getQueueThereAre(), String.class }, 
					{ request.getQueueCallsWaiting(), String.class }, 
					{ request.getQueueHoldTime(), String.class },
					{ request.getQueueMinutes(), String.class }, 
					{ request.getQueueSeconds(), String.class }, 
					{ request.getQueueLessThan(), String.class }, 
					{ request.getQueueThankYou(), String.class }, 
					{ request.getQueueReportHold(), String.class },
					{ request.getAnnounceFrequency(), Integer.class }, 
					{ request.getAnnounceRoundSeconds(), Integer.class }, 
					{ request.getAnnounceHoldtime(), String.class }, 
					{ request.getRetry(), Integer.class }, 
					{ request.getWrapuptime(), Integer.class }, 
					{ request.getMaxlen(), Integer.class },
					{ request.getServiceLevel(), Integer.class }, 
					{ request.getStrategy(), String.class }, 
					{ request.getJoinEmpty(), String.class }, 
					{ request.getLeavewhenempty(), String.class }, 
					{ request.getEventmemberstatus(), String.class }, 
					{ request.getEventwhencalled(), String.class },
					{ request.getReportholdtime(), String.class }, 
					{ request.getMemberdelay(), Integer.class }, 
					{ request.getWeight(), Integer.class }, 
					{ request.getTimeoutRestart(), String.class }, 
					{ request.getRinginuse(), String.class }, 
					{ request.getAnnouncePeriodic(), String.class },
					{ request.getAnnouncePeriodicTime(), String.class }, 
					{ request.getMonitorJoinSelect(), String.class }, 
					{ request.getEventMemberstatusTime(), String.class }, 
					{ request.getTimeoutRestartTime(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setInsertado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ActualizarQueuesResponse actualizarQueues(String ip, ActualizarQueuesRequest request) throws Exception {
		ActualizarQueuesResponse response = new ActualizarQueuesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_queues";
			Object[][] params = { 
					{ request.getName(), String.class }, 
					{ request.getMusiconHold(), String.class }, 
					{ request.getAnnounce(), String.class }, 
					{ request.getContext(), String.class }, 
					{ request.getTimeOut(), Integer.class }, 
					{ request.getMonitorJoin(), String.class },
					{ request.getMonitorFormat(), String.class }, 
					{ request.getQueueYouAreNext(), String.class }, 
					{ request.getQueueThereAre(), String.class }, 
					{ request.getQueueCallsWaiting(), String.class }, 
					{ request.getQueueHoldTime(), String.class },
					{ request.getQueueMinutes(), String.class }, 
					{ request.getQueueSeconds(), String.class }, 
					{ request.getQueueLessThan(), String.class }, 
					{ request.getQueueThankYou(), String.class }, 
					{ request.getQueueReportHold(), String.class },
					{ request.getAnnounceFrequency(), Integer.class }, 
					{ request.getAnnounceRoundSeconds(), Integer.class }, 
					{ request.getAnnounceHoldtime(), String.class }, 
					{ request.getRetry(), Integer.class }, 
					{ request.getWrapuptime(), Integer.class }, 
					{ request.getMaxlen(), Integer.class },
					{ request.getServiceLevel(), Integer.class }, 
					{ request.getStrategy(), String.class }, 
					{ request.getJoinEmpty(), String.class }, 
					{ request.getLeavewhenempty(), String.class }, 
					{ request.getEventmemberstatus(), String.class }, 
					{ request.getEventwhencalled(), String.class },
					{ request.getReportholdtime(), String.class }, 
					{ request.getMemberdelay(), Integer.class }, 
					{ request.getWeight(), Integer.class }, 
					{ request.getTimeoutRestart(), String.class }, 
					{ request.getRinginuse(), String.class }, 
					{ request.getAnnouncePeriodic(), String.class },
					{ request.getIdQueues(), Integer.class },
					{ request.getAnnouncePeriodicTime(), String.class }, 
					{ request.getMonitorJoinSelect(), String.class }, 
					{ request.getEventMemberstatusTime(), String.class }, 
					{ request.getTimeoutRestartTime(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setActualizado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarQueuesResponse eliminarQueues(String ip, EliminarQueuesRequest request) throws Exception {
		EliminarQueuesResponse response = new EliminarQueuesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_queues";
			Object[][] params = { { request.getIdQueues(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setEliminado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public BuscarQueuesResponse buscarQueues(String ip, BuscarQueuesRequest request) throws Exception {
		BuscarQueuesResponse response = new BuscarQueuesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_buscar_queues_por_id";
			Object[][] params = { { request.getIdQueues(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_queues", "idQueues");
			map.put("name", "name");
			map.put("musiconhold", "musiconHold");
			map.put("announce", "announce");
			map.put("context", "context");
			map.put("timeout", "timeOut");
			map.put("monitor-join", "monitorJoin");
			map.put("monitor-format", "monitorFormat");
			map.put("queue-youarenext", "queueYouAreNext");
			map.put("queue-thereare", "queueThereAre");
			map.put("queue-callswaiting", "queueCallsWaiting");
			map.put("queue-holdtime", "queueHoldTime");
			map.put("queue-minutes", "queueMinutes");
			map.put("queue-seconds", "queueSeconds");
			map.put("queue-lessthan", "queueLessThan");
			map.put("queue-thankyou", "queueThankYou");
			map.put("queue-reporthold", "queueReportHold");
			map.put("announce-frequency", "announceFrequency");
			map.put("announce-round-seconds", "announceRoundSeconds");
			map.put("announce-holdtime", "announceHoldtime");
			map.put("retry", "retry");
			map.put("wrapuptime", "wrapuptime");
			map.put("maxlen", "maxlen");
			map.put("servicelevel", "serviceLevel");
			map.put("strategy", "strategy");
			map.put("joinempty", "joinEmpty");
			map.put("leavewhenempty", "leavewhenempty");
			map.put("eventmemberstatus", "eventmemberstatus");
			map.put("eventwhencalled", "eventwhencalled");
			map.put("reportholdtime", "reportholdtime");
			map.put("memberdelay", "memberdelay");
			map.put("weight", "weight");
			map.put("timeoutrestart", "timeoutRestart");
			map.put("ringinuse", "ringinuse");
			map.put("announce-periodic", "announcePeriodic");

			Response<Queues> responseA = BaseDao.baseData(storedProcedure, params, db.con, Queues.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setBuscado((ArrayList<Queues>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarAgenteDisponiblesResponse listarAgenteDisponible(String ip, ListarAgenteDisponiblesRequest request) throws Exception {
		ListarAgenteDisponiblesResponse response = new ListarAgenteDisponiblesResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_agentes_disponibles";
			Object[][] params = { { request.getIdQueues(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_agente", "idAgente");
			map.put("nombre", "noAgente");

			Response<Queues> responseA = BaseDao.baseData(storedProcedure, params, db.con, Queues.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<Queues>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}
}