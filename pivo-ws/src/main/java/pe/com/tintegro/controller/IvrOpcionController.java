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
import pe.com.tintegro.dto.request.BuscarIVRPorNombreRequest;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;
import pe.com.tintegro.services.IvrOpcionServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/ivrOpcion")
public class IvrOpcionController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "ivrOpcionServices")
	protected IvrOpcionServices ivrOpcionServices;

	@RequestMapping(value = "/crear", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertarIvrOpcionResponse insertarIvrOpcionResponse(@RequestBody InsertarIvrOpcionRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		InsertarIvrOpcionResponse response = new InsertarIvrOpcionResponse();
		try
		{
			response = ivrOpcionServices.insertarIvrResponse(codUsuario, idInstancia, request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse eliminarIvrOpcionResponse(@RequestBody EliminarIvrOpcionRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		CRUDResponse response = new CRUDResponse();
		try
		{
			response = ivrOpcionServices.eliminarIvrResponse(codUsuario, idInstancia, request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se puede Eliminar El IVR Opcion");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse editarIvrOpcionResponse(@RequestBody EditarIvrOpcionRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		CRUDResponse response = new CRUDResponse();
		try
		{

			response = ivrOpcionServices.editarIvrResponse(codUsuario, idInstancia, request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido guardar la modificacion de IVR Opcion");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarIvrOpcionResponse listarIvrOpcionResponse(@RequestBody ListarIvrOpcionRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{
		ListarIvrOpcionResponse response = new ListarIvrOpcionResponse();
		try
		{
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response = ivrOpcionServices.listarIvrResponse(codUsuario, idInstancia, request);
			response.setMensaje("Lista IvrOpcion consultada");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("backend: error en carga de archivos");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;
	}

	@RequestMapping(value = "/buscar-por-nombre", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse buscarIVRPorNombre(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody BuscarIVRPorNombreRequest request)
	{
		CRUDResponse response = new CRUDResponse();

		try
		{
			response = ivrOpcionServices.buscarIVRPorNombre(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("IVR buscado correctamente.");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("Hubo un error al buscar el IVR.");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;
	}
}
