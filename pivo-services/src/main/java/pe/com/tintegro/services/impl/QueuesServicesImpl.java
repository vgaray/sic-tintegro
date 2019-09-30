package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.QueuesDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.Queues;
import pe.com.tintegro.dominio.TipoServer;
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
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.QueuesServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.UtilFile;

@Service("queuesServices")
@Transactional
public class QueuesServicesImpl implements QueuesServices {
	
	@Resource(name = "queuesDAO")
	protected QueuesDAO queuesDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Autowired
	private ServicesProperties servicesProperties;

	@Override
	public ListarQueuesResponse listarQueues(String codUsuario, String idInstancia, ListarQueuesRequest request) throws Exception {
		ListarQueuesResponse response = new ListarQueuesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.listarQueues(ip, request);
		return response;
	}

	@Override
	public InsertarQueuesResponse insertarQueues(String codUsuario, String idInstancia, InsertarQueuesRequest request) throws Exception {
		InsertarQueuesResponse response = new InsertarQueuesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.insertarQueues(ip, request);
		generarTxtQueue(codUsuario, idInstancia);
		return response;
	}

	@Override
	public ActualizarQueuesResponse actualizarQueues(String codUsuario, String idInstancia, ActualizarQueuesRequest request) throws Exception {
		ActualizarQueuesResponse response = new ActualizarQueuesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.actualizarQueues(ip, request);
		generarTxtQueue(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminarQueuesResponse eliminarQueues(String codUsuario, String idInstancia, EliminarQueuesRequest request) throws Exception {
		EliminarQueuesResponse response = new EliminarQueuesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.eliminarQueues(ip, request);
		generarTxtQueue(codUsuario, idInstancia);
		return response;
	}

	@Override
	public BuscarQueuesResponse buscarQueues(String codUsuario, String idInstancia, BuscarQueuesRequest request) throws Exception {
		BuscarQueuesResponse response = new BuscarQueuesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.buscarQueues(ip, request);
		return response;
	}

	@Override
	public ListarAgenteDisponiblesResponse listarAgenteDisponible(String codUsuario, String idInstancia, ListarAgenteDisponiblesRequest request) throws Exception {
		ListarAgenteDisponiblesResponse response = new ListarAgenteDisponiblesResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = queuesDAO.listarAgenteDisponible(ip, request);
		return response;
	}

	@Override
	public String mantenimientoColasEnAsterisk(String codUsuario, String idInstancia, Integer tipoOperacion, Queues queue) throws Exception {
		// String mensaje ="";
		// InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(
		// codUsuario, idInstancia );
		//
		// String linuxCommand = String.format("sh %s %s "
		// +"%s %s %s %s %s %s %s %s %s %s "
		// +"%s %s %s %s %s %s %s %s %s %s "
		// +"%s %s %s %s %s %s %s %s %s %s "
		// +"%s %s %s %s %s"
		// ,servicesProperties.getBashPathMaintenainceQueues(),tipoOperacion,
		// queue.getIdQueues(),
		// queue.getName(),queue.getStrategy(),queue.getWeight(),queue.getTimeOut(),
		// queue.getRetry(),queue.getMaxlen(),queue.getMusiconHold(),queue.getAnnounce(),
		// queue.getContext(),queue.getMonitorJoin(),queue.getMonitorFormat(),queue.getQueueYouAreNext(),
		// queue.getQueueThereAre(),queue.getQueueCallsWaiting(),queue.getQueueHoldTime(),
		// queue.getQueueMinutes(),queue.getQueueSeconds(),queue.getQueueLessThan(),queue.getQueueThankYou(),
		// queue.getQueueReportHold(),queue.getAnnounceFrequency(),queue.getAnnounceRoundSeconds(),queue.getAnnounceHoldtime(),
		// queue.getWrapuptime(),queue.getServiceLevel(),queue.getJoinEmpty(),queue.getLeavewhenempty(),queue.getEventmemberstatus(),
		// queue.getEventwhencalled(),queue.getReportholdtime(),queue.getMemberdelay(),queue.getTimeoutRestart(),queue.getRinginuse(),
		// queue.getAnnouncePeriodic());
		//
		// LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
		// infraestructuraUtil.instanciaACredencialesEquipo(vm), linuxCommand);
		// mensaje="ok";
		//
		// return mensaje;
		return null;
	}

	@Override
	public String generarTxtQueue(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		ListarQueuesRequest request = new ListarQueuesRequest();
		ListarQueuesResponse lstQueueResponse = listarQueues(codUsuario, idInstancia, request);
		String contenido = writeQueue(codUsuario, idInstancia, lstQueueResponse.getColaLista());
		File file = UtilFile.writeFile(contenido, servicesProperties.getFileNameQueue());
		String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), servicesProperties.getPathFileQueue());
		file.delete();
		System.out.println(fileExport);
		try {
			LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "asterisk -rx 'dialplan reload'");
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo Queues");
		}
		return contenido;
	}

	@Override
	public String writeQueue(String codUsuario, String idInstancia, List<Queues> listado) throws Exception {
		String contenido = "";
		String nomQueue = "";
		try {
			for (Queues queueIdNombre : listado) {
				nomQueue = queueIdNombre.getName();
				contenido += "[" + nomQueue.trim().replace(" ", "-") + "]" + System.getProperty("line.separator");

				BuscarQueuesRequest request = new BuscarQueuesRequest();
				request.setIdQueues(queueIdNombre.getIdQueues());
				BuscarQueuesResponse lstQueueResponse = buscarQueues(codUsuario, idInstancia, request);

				List<Queues> queue = lstQueueResponse.getBuscado();

				contenido += "strategy = " + ((queue.get(0).getStrategy() == null) ? "" : queue.get(0).getStrategy()) + System.getProperty("line.separator");
				contenido += "weight = " + ((queue.get(0).getWeight() == null) ? "" : queue.get(0).getWeight()) + System.getProperty("line.separator");
				contenido += "timeout = " + ((queue.get(0).getTimeOut() == null) ? "" : queue.get(0).getTimeOut()) + System.getProperty("line.separator");
				contenido += "retry = " + ((queue.get(0).getRetry() == null) ? "" : queue.get(0).getRetry()) + System.getProperty("line.separator");
				contenido += "maxlen = " + ((queue.get(0).getMaxlen() == null) ? "" : queue.get(0).getMaxlen()) + System.getProperty("line.separator");
				contenido += ";musiconhold =" + ((queue.get(0).getMusiconHold() == null) ? "" : queue.get(0).getMusiconHold()) + System.getProperty("line.separator");
				contenido += "announce =" + ((queue.get(0).getAnnounce() == null) ? "" : queue.get(0).getAnnounce()) + System.getProperty("line.separator");
				contenido += "context = " + ((queue.get(0).getContext() == null) ? "" : queue.get(0).getContext()) + System.getProperty("line.separator");
				contenido += "monitor-join = " + ((queue.get(0).getMonitorJoin() == null) ? "" : ((queue.get(0).getMonitorJoin().trim().equals("si")) ? "yes" : queue.get(0).getMonitorJoin())) + System.getProperty("line.separator");
				contenido += ";monitor-format = " + ((queue.get(0).getMonitorFormat() == null) ? "" : queue.get(0).getMonitorFormat()) + System.getProperty("line.separator");
				contenido += "queue-youarenext = " + ((queue.get(0).getQueueYouAreNext() == null) ? "" : queue.get(0).getQueueYouAreNext()) + System.getProperty("line.separator");
				contenido += "queue-thereare = " + ((queue.get(0).getQueueThereAre() == null) ? "" : queue.get(0).getQueueThereAre()) + System.getProperty("line.separator");
				contenido += "queue-callswaiting = " + ((queue.get(0).getQueueCallsWaiting() == null) ? "" : queue.get(0).getQueueCallsWaiting()) + System.getProperty("line.separator");
				contenido += "queue-holdtime = " + ((queue.get(0).getQueueHoldTime() == null) ? "" : queue.get(0).getQueueHoldTime()) + System.getProperty("line.separator");
				contenido += "queue-minutes = " + ((queue.get(0).getQueueMinutes() == null) ? "" : queue.get(0).getQueueMinutes()) + System.getProperty("line.separator");
				contenido += "queue-seconds = " + ((queue.get(0).getQueueSeconds() == null) ? "" : queue.get(0).getQueueSeconds()) + System.getProperty("line.separator");
				contenido += "queue-lessthan = " + ((queue.get(0).getQueueLessThan() == null) ? "" : queue.get(0).getQueueLessThan()) + System.getProperty("line.separator");
				contenido += "queue-thankyou = " + ((queue.get(0).getQueueThankYou() == null) ? "" : queue.get(0).getQueueThankYou()) + System.getProperty("line.separator");
				contenido += "queue-reporthold =" + ((queue.get(0).getQueueReportHold() == null) ? "" : queue.get(0).getQueueReportHold()) + System.getProperty("line.separator");
				contenido += "announce-frequency = " + ((queue.get(0).getAnnounceFrequency() == null) ? "" : queue.get(0).getAnnounceFrequency()) + System.getProperty("line.separator");
				contenido += "announce-round-seconds = " + ((queue.get(0).getAnnounceRoundSeconds() == null) ? "" : queue.get(0).getAnnounceRoundSeconds()) + System.getProperty("line.separator");
				contenido += "announce-holdtime = " + ((queue.get(0).getAnnounceHoldtime() == null) ? "" : queue.get(0).getAnnounceHoldtime()) + System.getProperty("line.separator");
				contenido += "wrapuptime = " + ((queue.get(0).getWrapuptime() == null) ? "" : queue.get(0).getWrapuptime()) + System.getProperty("line.separator");
				contenido += "servicelevel = " + ((queue.get(0).getServiceLevel() == null) ? "" : queue.get(0).getServiceLevel()) + System.getProperty("line.separator");
				contenido += "joinempty = " + ((queue.get(0).getJoinEmpty() == null) ? "" : queue.get(0).getJoinEmpty()) + System.getProperty("line.separator");
				contenido += "leavewhenempty = " + ((queue.get(0).getLeavewhenempty() == null) ? "" : ((queue.get(0).getLeavewhenempty().trim().equals("si")) ? "yes" : queue.get(0).getLeavewhenempty())) + System.getProperty("line.separator");
				contenido += "eventmemberstatus = " + ((queue.get(0).getEventmemberstatus() == null) ? "" : ((queue.get(0).getEventmemberstatus().trim().equals("si")) ? "yes" : queue.get(0).getEventmemberstatus())) + System.getProperty("line.separator");
				contenido += "eventwhencalled = " + ((queue.get(0).getEventwhencalled() == null) ? "" : ((queue.get(0).getEventwhencalled().trim().equals("si")) ? "yes" : queue.get(0).getEventwhencalled())) + System.getProperty("line.separator");
				contenido += "reportholdtime = " + ((queue.get(0).getReportholdtime() == null) ? "" : ((queue.get(0).getReportholdtime().trim().equals("si")) ? "yes" : queue.get(0).getReportholdtime())) + System.getProperty("line.separator");
				contenido += "memberdelay = " + ((queue.get(0).getMemberdelay() == null) ? "" : queue.get(0).getMemberdelay()) + System.getProperty("line.separator");
				contenido += "timeoutrestart = " + ((queue.get(0).getTimeoutRestart() == null) ? "" : ((queue.get(0).getTimeoutRestart().trim().equals("si")) ? "yes" : queue.get(0).getTimeoutRestart())) + System.getProperty("line.separator");
				contenido += "ringinuse = " + ((queue.get(0).getRinginuse() == null) ? "" : ((queue.get(0).getRinginuse().trim().equals("si")) ? "yes" : queue.get(0).getRinginuse())) + System.getProperty("line.separator");
				contenido += "periodic-announce = " + ((queue.get(0).getAnnouncePeriodic() == null) ? "" : ((queue.get(0).getAnnouncePeriodic().trim().equals("si")) ? "yes" : queue.get(0).getAnnouncePeriodic())) + System.getProperty("line.separator");
				contenido += "announce-frecuency-time = " + ((queue.get(0).getAnnouncePeriodicTime() == null) ? "" : queue.get(0).getAnnouncePeriodicTime()) + System.getProperty("line.separator");
				contenido += "announce-position-limit = " + ((queue.get(0).getMonitorJoinSelect() == null) ? "" : queue.get(0).getMonitorJoinSelect()) + System.getProperty("line.separator");
				contenido += "memberdelay-time = " + ((queue.get(0).getEventMemberstatusTime() == null) ? "" : queue.get(0).getEventMemberstatusTime()) + System.getProperty("line.separator");
				contenido += "timeoutrestart-time = " + ((queue.get(0).getTimeoutRestartTime() == null) ? "" : queue.get(0).getTimeoutRestartTime()) + System.getProperty("line.separator");

				contenido += System.getProperty("line.separator");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contenido;
	}
}