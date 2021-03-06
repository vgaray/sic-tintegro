package pe.com.tintegro.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaConsolidadaAgenteCallCenterResponse;
import pe.com.tintegro.dto.response.ListarReporteLlamadaDiaHoraCallCenterResponse;
import pe.com.tintegro.services.CallCenterReporteServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/call-center-reporte")
public class CallCenterReporteController {
	
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "callCenterService")
	protected CallCenterReporteServices callCenterService;	
	//--------------------------------------------------------------------------------------
		@RequestMapping(value = "/listarAtencionCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseStatus(value = HttpStatus.OK)	
		public ListarReporteAtencionClienteCallCenterResponse listarAtencionCliente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
				@RequestBody ListarReporteAtencionClienteCallCenterRequest request){
			ListarReporteAtencionClienteCallCenterResponse response =new ListarReporteAtencionClienteCallCenterResponse();
			try
			{
				response = callCenterService.listaReporteAtencionCliente(codUsuario, idInstancia,request);
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje("Consulta de Reporte CallCenter Exitosa");
			}
			catch (Exception ex)
			{
				response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
				String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
				response.setCodError(codError);
				response.setMensaje("No se ha podido Consultar Reporte CallCenter");
				System.out.println(ex.getMessage());
				LOGGER.error(codError, ex);
			}		
			return response;
		}	
		//-----------------------------------------------------------------------
	@RequestMapping(value = "/listarLlamadaDiaHora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	
	
	public ListarReporteLlamadaDiaHoraCallCenterResponse listarLlamadaDiaHora(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarReporteLlamadaDiaHoraCallCenterRequest request){
		
		ListarReporteLlamadaDiaHoraCallCenterResponse response =new ListarReporteLlamadaDiaHoraCallCenterResponse();
		try
		{
			response = callCenterService.listaReporteLlamadaDiaHora(codUsuario, idInstancia,request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Reporte CallCenter Exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido Consultar Reporte CallCenter");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
	
	//-----------------------------------------------------------------------------------------------
	@RequestMapping(value = "/listarLlamadaConsolidadaAgente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	
	
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse listarLlamadaConsolidadaAgente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request){
		
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response =new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		try
		{
			response = callCenterService.listaReporteLlamadaConsolidadaAgente(codUsuario, idInstancia,request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("No se ha podido Consultar Reporte CallCenter");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido Consultar Reporte CallCenter");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}
	
	//-----------------------------------------------------------------------------------------------
	@RequestMapping(value = "listarConsolidadoLlamadaRecibida", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	
	
		
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse listarConsolidadoLlamadaRecibida(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request){
		ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response =new ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse();
		try
		{
			response = callCenterService.listaReporteConsolidadoLlamada(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("No se ha podido Consultar Reporte CallCenter");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido Consultar Reporte CallCenter");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}
}
