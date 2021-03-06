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
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ListaSipTelefonoRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaMailBoxResponse;
import pe.com.tintegro.services.SipTelefonoServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/sipTelefono")
public class SipTelefonoController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "sipTelefonoServices")
	protected SipTelefonoServices sipTelefonoServices;

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaSipTelefonoResponse listar(@RequestBody ListaSipTelefonoRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListaSipTelefonoResponse response = new ListaSipTelefonoResponse();
		try
		{
			response = sipTelefonoServices.listaSipTelefono(codUsuario, idInstancia);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Anexos SIP obtenidos con éxito.");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setMensaje("Ocurrió un error al mostrar anexos SIP.");
			response.setCodError(codError);
			LOGGER.error(codError, ex);
		}

		return response;
	}

	@RequestMapping(value = "/buscaSipId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public BuscaSipBuddieIdResponse bucarId(@RequestBody BuscaSipBuddieIdRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{

		BuscaSipBuddieIdResponse response = new BuscaSipBuddieIdResponse();

		try
		{
			response = sipTelefonoServices.buscaSipBuddieId(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("usuario sip obtenidos con éxito.");
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

	@RequestMapping(value = "/autocompletarLista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public AutoCompletarSipTelefonoResponse autocompletarLista(@RequestBody AutoCompletarSipTelefonoRequest request, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia)
	{
		AutoCompletarSipTelefonoResponse response = new AutoCompletarSipTelefonoResponse();
		try
		{
			response.setListaAnexos(sipTelefonoServices.AutoCompletarSipTelefono(codUsuario, idInstancia, request).getListaAnexos());
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Cargado correctamente. ");
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

	@RequestMapping(value = "/validarMailBox", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ValidaMailBoxResponse validarMailBox(@RequestBody ValidaMailBoxRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{

		ValidaMailBoxResponse response = new ValidaMailBoxResponse();

		try
		{
			response = sipTelefonoServices.validarMailBox(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("validacion de mailbox correcta. ");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido validar mailbox");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}
}
