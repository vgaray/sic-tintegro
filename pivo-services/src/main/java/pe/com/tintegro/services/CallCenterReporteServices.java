package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;

public interface CallCenterReporteServices {

	

	ListarReporteAtencionClienteCallCenterResponse listaReporteAtencionCliente(
			String codUsuario, String idInstancia,
			ListarReporteAtencionClienteCallCenterRequest request)
			throws Exception;

	
	ListarReporteLlamadaDiaHoraCallCenterResponse listaReporteLlamadaDiaHora(
			String codUsuario, String idInstancia,
			ListarReporteLlamadaDiaHoraCallCenterRequest request)
			throws Exception;

	ListarReporteLlamadaConsolidadaAgenteCallCenterResponse listaReporteLlamadaConsolidadaAgente(
			String codUsuario, String idInstancia,
			ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request)
			throws Exception;
	
	ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse listaReporteConsolidadoLlamada(
			String codUsuario, String idInstancia,
			ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request)
			throws Exception;
	////////////////////////////////////////////////////////////////////////////////////////////
	ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidadaAgente(
			String codUsuario, String idInstancia,
			ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request)
			throws Exception;

	
	
	
}
