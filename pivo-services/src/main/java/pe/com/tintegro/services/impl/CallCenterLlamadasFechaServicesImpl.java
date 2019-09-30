package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.CallCenterLlamadasFechaDAO;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.CallCenterLlamadasFechaServices;

@Service("callCenterLlamadasFechaServices")
@Transactional
public class CallCenterLlamadasFechaServicesImpl implements CallCenterLlamadasFechaServices {
	
	@Autowired
	private CallCenterLlamadasFechaDAO callCenterLlamadasFechaDAO;
	@Autowired
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "reporteServices")
	protected ReporteServicesImpl reporteServices;

	@Override
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadaAtendidasAbandonadas(String codUsuario, String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception {
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaLlamadasAbandonadas(ip, request);
		return response;
	}

	@Override
	public ListaLlamadasContestadasResponse listaLlamadaContestada(String codUsuario, String idInstancia, ListaLlamadasContestadasRequest request) throws Exception {
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaLlamadasContestadas(ip, request);
		return response;
	}

	@Override
	public ListaLlamadaAgenteResponse listaLlamadaAgente(String codUsuario, String idInstancia, ListaLlamadaAgenteRequest request) throws Exception {
		ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaLlamadaAgente(ip, request);
		return response;
	}

	@Override
	public ListaReporteAbandonosResponse listaReporteAbandonos(String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception {
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaReporteAbandono(ip, request);
		return response;
	}

	// Reportes

	@Override
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaReporteLlamadaAtendidasAbandonadas(String codUsuario, String idInstancia, ListaLlamadasAtendidasAbandonadasFechaRequest request) throws Exception {
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaReporteLlamadasAtAbFecha(ip, request);
		return response;
	}

	@Override
	public ListaLlamadasContestadasResponse listaReporteLlamadasContestadas(String codUsuario, String idInstancia, ListaLlamadasContestadasRequest request) throws Exception {
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaReporteLlamadasContestadas(ip, request);
		return response;
	}

	@Override
	public ListaReporteAbandonosResponse listaReporteEAbandonos(String codUsuario, String idInstancia, ListaReporteAbandonosRequest request) throws Exception {
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = callCenterLlamadasFechaDAO.listaReporteEAbandonos(ip, request);
		return response;
	}
}
