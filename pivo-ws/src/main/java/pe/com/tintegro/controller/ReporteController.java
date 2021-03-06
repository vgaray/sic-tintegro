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
import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadasAtendidasAbandonadasFechaRequest;
import pe.com.tintegro.dto.request.ListaLlamadasContestadasRequest;
import pe.com.tintegro.dto.request.ListaReporteAbandonosRequest;
import pe.com.tintegro.dto.request.ListarConsolidadoTiempoEsperaRequest;
import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAbandonadasPorMinutoRequest;
import pe.com.tintegro.dto.request.ListarLlamadasAtendidasAbandonadasRequest;
import pe.com.tintegro.dto.request.ListarLlamadasEntrantesPorHoraRequest;
import pe.com.tintegro.dto.request.ListarReporteAtencionClienteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaConsolidadaAgenteCallCenterRequest;
import pe.com.tintegro.dto.request.ListarReporteLlamadaDiaHoraCallCenterRequest;
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
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;
import pe.com.tintegro.services.RankingLlamadasServices;
import pe.com.tintegro.services.ReporteServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/reporte")
public class ReporteController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Autowired
	private RankingLlamadasServices rankingLlamadasServices;
	@Autowired
	private ReporteServices reporteServices;

	// Lista llamada Destino
	@RequestMapping(value = "/lista-llamada-destino", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarLlamadaDestinoResponse listaLlamadaDestino(@RequestBody ListarLlamadaDestinoRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListarLlamadaDestinoResponse response = new ListarLlamadaDestinoResponse();
		try
		{
			System.out.println(request.getpIdArea() + " | " + request.getpIdCentcos() + " | " + request.getpFeIni() + " | " + request.getpFeFin() + " | " + request.getpHoIni() + " | "
					+ request.getpHoFin() + " | ");

			response = reporteServices.listaLlamadaDestino(codUsuario, idInstancia, request);

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la Lista");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	// Lista llamada General
	@RequestMapping(value = "/lista-llamada-general", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaGeneralResponse listaLlamadaGeneral(@RequestBody ListaLlamadaGeneralRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListaLlamadaGeneralResponse response = new ListaLlamadaGeneralResponse();
		try
		{
			System.out.println(request.getpHorai() + " | " + request.getpHoraf() + " | " + request.getpNoSrc() + " | " + request.getpNoDst() + " | " + request.getpNoDis() + " | " + request.getpFeIni()
					+ " | " + request.getpFeFin() + " | " + request.getpTipLlamada() + " | " + request.getpRanInitie() + " | " + request.getpRanFintie() + " | " + request.getNumPagina() + " | "
					+ request.getCantidadxPag()

			);

			response = reporteServices.ListallamadaGeneral(codUsuario, idInstancia, request);

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la Lista");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	// Lista llamda Usuario
	@RequestMapping(value = "/lista-llamada-usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaUsuarioResponse listaLlamadaUsuario(@RequestBody ListaLlamadaUsuarioRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListaLlamadaUsuarioResponse response = new ListaLlamadaUsuarioResponse();
		try
		{
			response = reporteServices.listaLlamadaUsuario(codUsuario, idInstancia, request);

		}
		catch (Exception exception)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible listar las llamadas");
			System.out.println(exception.getMessage());
			LOGGER.error(codError, exception);
		}
		return response;
	}

	// Reporte Usuario
	@RequestMapping(value = "/reporteLlamadaUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaUsuarioResponse reporteLlamadaUsuario(@RequestBody ListaLlamadaUsuarioRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListaLlamadaUsuarioResponse response = new ListaLlamadaUsuarioResponse();
		try
		{
			response = reporteServices.reporteLlamadaUsuario(codUsuario, idInstancia, request);

		}
		catch (Exception exception)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible listar las llamadas");
			System.out.println(exception.getMessage());
			LOGGER.error(codError, exception);
		}
		return response;
	}

	// Reporte General
	@RequestMapping(value = "/reporteLlamadaGeneral", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaGeneralResponse reporteLlamadaGeneral(@RequestBody ListaLlamadaGeneralRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListaLlamadaGeneralResponse response = new ListaLlamadaGeneralResponse();
		try
		{
			response = reporteServices.reporteLlamadaGeneral(codUsuario, idInstancia, request);

		}
		catch (Exception exception)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible listar las llamadas");
			System.out.println(exception.getMessage());
			LOGGER.error(codError, exception);
		}
		return response;
	}

	// Listar Ranking
	@RequestMapping(value = "/listarRankingLlamadas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public RankingLlamadasResponse listRankingLlamadasResponse(@RequestBody RankingLlamadasRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		RankingLlamadasResponse response = new RankingLlamadasResponse();
		try
		{
			response = rankingLlamadasServices.listarRankingLlamadas(codUsuario, idInstancia, request);

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la Lista!!!");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	// Reporte Ranking
	@RequestMapping(value = "/reporteRankingLlamada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public RankingLlamadasResponse reporteRankingLlamada(@RequestBody RankingLlamadasRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		RankingLlamadasResponse response = new RankingLlamadasResponse();
		try
		{
			response = reporteServices.reporteRankingLlamadas(codUsuario, idInstancia, request);

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	

	// Reporte Llamada Destino
	@RequestMapping(value = "/reporteLlamadaDestino", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarLlamadaDestinoResponse reporteLlamadaDestino(@RequestBody ListarLlamadaDestinoRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListarLlamadaDestinoResponse response = new ListarLlamadaDestinoResponse();
		try
		{
			response = reporteServices.reporteLlamadaDestino(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;

	}

	// Reporte Llamadas Atendidas Abandonadas fecha
	@RequestMapping(value = "/reporte-lista-llamadas-atendidas-abandonadas-fecha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadasAtendidasAbandonadasFechaResponse listaReporteListaLlamadasAtendidasAbandonadas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ListaLlamadasAtendidasAbandonadasFechaRequest request)
	{
		ListaLlamadasAtendidasAbandonadasFechaResponse response = new ListaLlamadasAtendidasAbandonadasFechaResponse();
		try
		{
			response = reporteServices.reporteLlamadaAtendidaAbandonadaFecha(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	// Reporte Llamadas Contestadas
	@RequestMapping(value = "/reporte-lista-llamadas-contestadas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadasContestadasResponse listaReporteLlamadasContestadas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ListaLlamadasContestadasRequest request)
	{
		ListaLlamadasContestadasResponse response = new ListaLlamadasContestadasResponse();
		try
		{
			response = reporteServices.reporteLlamadasContestadas(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codEerror = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codEerror);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codEerror, e);
		}
		return response;
	}

	// Reporte Llamadas Agente
	@RequestMapping(value = "/reporte-lista-llamadas-agente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaLlamadaAgenteResponse listaLlamadaAgente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListaLlamadaAgenteRequest request)
	{
		ListaLlamadaAgenteResponse response = new ListaLlamadaAgenteResponse();
		try
		{
			response = reporteServices.reporteListaLlamadasAgente(codUsuario, idInstancia, request);

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

	// Reporte Llamadas Abandonos
	@RequestMapping(value = "/reporte-lista-llamadas-abandonadas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaReporteAbandonosResponse listaReporteLlamadasAbandonadas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ListaReporteAbandonosRequest request)
	{
		ListaReporteAbandonosResponse response = new ListaReporteAbandonosResponse();
		try
		{
			response = reporteServices.reporteListaReporteAbandonos(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	// Reporte Llamadas Abandonadas Por Minuto
	@RequestMapping(value = "/reporte-llamadas-abandonadas-por-minuto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarLlamadasAbandonadasPorMinutoResponse reporteLlamadasAbandonadasPorMinuto(@RequestBody ListarLlamadasAbandonadasPorMinutoRequest request,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarLlamadasAbandonadasPorMinutoResponse response = new ListarLlamadasAbandonadasPorMinutoResponse();
		try
		{
			response = reporteServices.listarReporteLlamadasAbandonadasPorMinuto(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	// Reporte Consolidado Tiempo Espera
	

	// Reporte Llamadas Atendidas y Abandonadas Por Agente
	@RequestMapping(value = "/reporte-llamadas-atendidas-abandonadas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarLlamadasAtendidasAbandonadasResponse reporteLlamadasAtendidasAbandonadas(@RequestBody ListarLlamadasAtendidasAbandonadasRequest request,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarLlamadasAtendidasAbandonadasResponse response = new ListarLlamadasAtendidasAbandonadasResponse();
		try
		{
			response = reporteServices.listarReporteLlamadasAtendidasAbandonadas(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	// Reporte Llamadas Entrantes Por Hora
	@RequestMapping(value = "/reporte-llamadas-entrante-por-hora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarLlamadasEntrantesPorHoraResponse reporteLlamadasEntrantePorHora(@RequestBody ListarLlamadasEntrantesPorHoraRequest request, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarLlamadasEntrantesPorHoraResponse response = new ListarLlamadasEntrantesPorHoraResponse();
		try
		{
			response = reporteServices.listarReporteLlamadasEntrantesPorHora(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/reporte-atencion-cliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarReporteAtencionClienteCallCenterResponse reporteAtencionCliente(@RequestBody ListarReporteAtencionClienteCallCenterRequest request, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarReporteAtencionClienteCallCenterResponse response = new ListarReporteAtencionClienteCallCenterResponse();
		try
		{
			response = reporteServices.reporteAtencionCliente(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;

	}

	@RequestMapping(value = "/reporte-consolidado-llamada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse reporteConsolidadoLlamada(@RequestBody ListarReporteConsolidadoLlamadaRecibidaCallCenterRequest request,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse response = new ListarReporteConsolidadoLlamadaRecibidaCallCenterResponse();
		try
		{
			response = reporteServices.reporteConsolidadoLlamadaRecibida(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;

	}

	@RequestMapping(value = "/reporte-llamada-dia-hora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarReporteLlamadaDiaHoraCallCenterResponse reporteLlamdaDia(@RequestBody ListarReporteLlamadaDiaHoraCallCenterRequest request, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarReporteLlamadaDiaHoraCallCenterResponse response = new ListarReporteLlamadaDiaHoraCallCenterResponse();
		try
		{
			response = reporteServices.reporteLlamadaDia(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;

	}

	@RequestMapping(value = "/reporte-llamada-consolidada-agente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarReporteLlamadaConsolidadaAgenteCallCenterResponse reporteLlamadaConsolidada(@RequestBody ListarReporteLlamadaConsolidadaAgenteCallCenterRequest request,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		ListarReporteLlamadaConsolidadaAgenteCallCenterResponse response = new ListarReporteLlamadaConsolidadaAgenteCallCenterResponse();
		try
		{
			response = reporteServices.reporteLlamadaConsolidadaAgente(codUsuario, idInstancia, request);

		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar  el reporte!!!");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;

	}
}
