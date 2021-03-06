package pe.com.tintegro.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dto.request.ListaLlamadaAgenteRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.response.ListaLlamadaAgenteResponse;
import pe.com.tintegro.dto.response.ListaLlamadasAtendidasAbandonadasFechaResponse;
import pe.com.tintegro.dto.response.ListaLlamadasContestadasResponse;
import pe.com.tintegro.dto.response.ListaReporteAbandonosResponse;
import pe.com.tintegro.services.CallCenterLlamadasFechaServices;
import pe.com.tintegro.services.ReporteServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/call-center-reporte")
public class CallCenterLlamadasFechaController
{

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Autowired
	protected CallCenterLlamadasFechaServices callCenterLlamadasFechaServices;

	@Autowired
	protected ReporteServices reporteServices;

	@RequestMapping(value = "/lista-llamadas-atendidas-abandonadas-fecha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaLlamadasAtendidasAbandonadas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ListaLlamadasAtendidasAbandonadasFechaRequest request)
	{
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		try
		{
			response = callCenterLlamadasFechaServices.listaLlamadaAtendidasAbandonadas(codUsuario, idInstancia, request);
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la lista de llamadas atendidas y abandonadas");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/lista-llamadas-contestadas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadasContestadasResponse listaLlamadasContestadas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ListaLlamadasContestadasRequest request)
	{
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		try
		{
			response = callCenterLlamadasFechaServices.listaLlamadaContestada(codUsuario, idInstancia, request);
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la lista de llamadas contestadas");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/lista-llamada-agente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaAgenteResponse listaLlamadaAgente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListaLlamadaAgenteRequest request)
	{
		ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
		try
		{
			response = callCenterLlamadasFechaServices.listaLlamadaAgente(codUsuario, idInstancia, request);
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la lista de agentes");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/lista-reporte-abandonos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaReporteAbandonosResponse listaReporteAbandonos(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListaReporteAbandonosRequest request)
	{
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		try
		{
			response = callCenterLlamadasFechaServices.listaReporteAbandonos(codUsuario, idInstancia, request);
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la lista de reportes de abandonos");
			System.out.println(e.getMessage());
		}
		return response;
	}
}
