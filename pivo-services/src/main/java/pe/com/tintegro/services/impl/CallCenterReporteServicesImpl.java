package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.ListaReporteCallCenterDAO;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.services.CallCenterReporteServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.transformers.TransformerRespuestaOperador;
import pe.com.tintegro.services.util.Transformer;

@Service("callCenterService")
@Transactional
public class CallCenterReporteServicesImpl implements CallCenterReporteServices {

	@Resource(name = "listaReporteCallCenterDAO")
	protected ListaReporteCallCenterDAO reporteDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@SuppressWarnings("rawtypes")
	@Qualifier("transformerRespuestaOperador")
	private Transformer transformer;

	// @SuppressWarnings("unchecked")
	@Override
	public ListarReporteAtencionClienteCallCenterResponse listaReporteAtencionCliente(String codUsuario, String idInstancia, ListarReporteAtencionClienteCallCenterRequest request) throws Exception {
		ListarReporteAtencionClienteCallCenterResponse response = new ListarReporteAtencionClienteCallCenterResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = reporteDAO.listaReporteAtencionClienteCallCenter(ip, request);
		// implementando el método Transformador
		TransformerRespuestaOperador obj = new TransformerRespuestaOperador();
		Graficos graf = obj.transformerTo(response.getLsreporteAtencionCliente());
		response.setGraficoLlamada(graf);
		return response;
	}

	@Override
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse listaReporteConsolidadoLlamada(String codUsuario, String idInstancia, ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request) throws Exception {
		ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = new ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = reporteDAO.listarReporteConsolidadoLlamadaRecibidaCallCenter(ip, request);
		return response;
	}

	@Override
	public ListarReporteLlamadaDiaHoraCallCenterResponse listaReporteLlamadaDiaHora(String codUsuario, String idInstancia, ListarReporteLlamadaDiaHoraCallCenterRequest request) throws Exception {
		ListarReporteLlamadaDiaHoraCallCenterResponse response = new ListarReporteLlamadaDiaHoraCallCenterResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = reporteDAO.listaReporteLlamadaDiaHoraCallCenter(ip, request);
		return response;
	}

	@Override
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse listaReporteLlamadaConsolidadaAgente(String codUsuario, String idInstancia, ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request) throws Exception {
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = reporteDAO.listarReporteLlamadaConsolidadaAgenteCallCenter(ip, request);
		return response;
	}

	@Override
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidadaAgente(String codUsuario, String idInstancia, ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request) throws Exception {
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = reporteDAO.reporteLlamadaConsolidadaAgenteCallCenter(ip, request);
		return response;
	}
}