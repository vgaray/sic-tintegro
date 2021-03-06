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
import pe.com.tintegro.dto.request.ConfigAnnexRequest;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.GeneraClaveAnexoSipRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.ConfigAnnexResponse;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.GeneraClaveAnexoSipResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.services.SipBuddieServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/sipBuddie")
public class SipBuddieController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "sipBuddieServices")
	protected SipBuddieServices sipBuddieServices;

	// @Resource(name = "certificadosSIPServices")
	// protected CertificadosSIPServices certificadosSIPServices;

	/**
	 * Metododo para insertar usuario
	 * 
	 * @param request
	 *           los parametros que se van a asignar
	 * @param codUsuario
	 *           el codigo para especificar a que numero se ip se va a logear
	 * @param token
	 * @return
	 */

	@RequestMapping(value = "/insertarAnexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertaSipBuddieResponse insertaSipBuddie(@RequestBody InsertaSipBuddieRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		InsertaSipBuddieResponse response = new InsertaSipBuddieResponse();

		try
		{
			response = sipBuddieServices.insertarSipBuddie(codUsuario, idInstancia, request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);

			String mensaje = "Error en la inserción de Anexo SIP";

			response.setMensaje(mensaje);
			System.out.print(ex.getMessage());
			LOGGER.error(codError, ex);

		}

		return response;
	}

	/**
	 * Editar Anexo de la tabla tb_buddies
	 * 
	 * @param request
	 * @param codUsuario
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/editarAnexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EditaSipBuddieResponse editaSipBuddie(@RequestBody EditaSipBuddieRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		EditaSipBuddieResponse response = new EditaSipBuddieResponse();

		try
		{
			response = sipBuddieServices.editarSipBuddie(codUsuario, idInstancia, request, false);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Modificación de Anexo SIP Correcta");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);

			String mensaje = "Error en modificación de Anexo SIP.";

			response.setMensaje(mensaje);
			System.out.print(ex.getMessage());
			LOGGER.error(codError, ex);

		}
		return response;
	}

	/**
	 * Metodo para eliminar anexo
	 * 
	 * @param request
	 * @param codUsuario
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/eliminarAnexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EliminaSipBuddieResponse eliminaSipBuddie(@RequestBody EliminaSipBuddieRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		EliminaSipBuddieResponse response = new EliminaSipBuddieResponse();

		try
		{
			response = sipBuddieServices.eliminaSipBuddie(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Eliminacion de Anexo SIP Correcta");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);

			String mensaje = "Error en la eliminación de Anexo SIP";

			response.setMensaje(mensaje);
			System.out.print(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/generar-clave-anexo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public GeneraClaveAnexoSipResponse generarClaveAnexo(@RequestBody GeneraClaveAnexoSipRequest request, @RequestHeader String codUsuario, @RequestHeader String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		GeneraClaveAnexoSipResponse response = new GeneraClaveAnexoSipResponse();

		try
		{
			response.setClave(sipBuddieServices.generateAnnexID(codUsuario, idInstancia, request));
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setCodError(null);
			response.setMensaje("Clave generada con éxito.");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			String mensaje = "Error en la generación de clave de anexo SIP.";
			response.setMensaje(mensaje);
			System.out.print(e.getMessage());
			LOGGER.error(codError, e);
		}

		return response;
	}

	@RequestMapping(value = "/obtener-credenciales", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public ConfigAnnexResponse getCredentials(@RequestBody ConfigAnnexRequest request, @RequestHeader String idInstancia, @RequestHeader String codUsuario, @RequestHeader String token)
	{
		ConfigAnnexResponse response = new ConfigAnnexResponse();

		try
		{
			response = sipBuddieServices.getCredentials(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Credenciales obtenidas correctamente.");
		}
		catch (Exception e)
		{
			String codError = Util.getCodigoErrorByDate();
			response.setCodError(Util.getCodigoErrorByDate());
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			response.setMensaje("Error al obtener las credenciales del anexo.");

			LOGGER.error(codError, e);
		}

		return response;
	}
}
