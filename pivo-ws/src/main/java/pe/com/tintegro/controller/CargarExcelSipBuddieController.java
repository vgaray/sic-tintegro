package pe.com.tintegro.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import pe.com.tintegro.dao.util.Constantes;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.dto.request.CargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.request.DescargaExcelSipBuddieRequest;
import pe.com.tintegro.dto.response.CargaExcelSipBuddieResponse;
import pe.com.tintegro.dto.response.DescargaSipTelefonoResponse;
import pe.com.tintegro.services.CargarExcelSipBuddieServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/cargaExcelSipBuddie")
public class CargarExcelSipBuddieController
{

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "cargarExcelSipBuddieServices")
	protected CargarExcelSipBuddieServices cargarExcelSipBuddieServices;

	@RequestMapping(value = "/descarga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public DescargaSipTelefonoResponse descargaSipTelefono(@RequestBody DescargaExcelSipBuddieRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		DescargaSipTelefonoResponse response = new DescargaSipTelefonoResponse();
		try
		{
			response = cargarExcelSipBuddieServices.descargaSipTelefono(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Se cargo correctamente");

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("Error en carga");
			response.setMensaje(ex.getMessage());
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/cargar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CargaExcelSipBuddieResponse cargarExcelSipBuddie(@RequestBody CargaExcelSipBuddieRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{

		CargaExcelSipBuddieResponse response = new CargaExcelSipBuddieResponse();
		try
		{
			response = cargarExcelSipBuddieServices.cargarExcelSipBuddie(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Se cargo correctamente");

		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido mostrar usuario sip");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

}
