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
import pe.com.tintegro.dto.request.ActualizarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ActualizarGrupoDirectRequest;
import pe.com.tintegro.dto.request.EliminarEntradaDirectRequest;
import pe.com.tintegro.dto.request.EliminarGrupoDirectRequest;
import pe.com.tintegro.dto.request.InsertarEntradaDirectRequest;
import pe.com.tintegro.dto.request.InsertarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ListarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.request.ValidarDirectorioRequest;
import pe.com.tintegro.dto.response.ActualizarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ActualizarGrupoDirectResponse;
import pe.com.tintegro.dto.response.EliminarEntradaDirectResponse;
import pe.com.tintegro.dto.response.EliminarGrupoDirectResponse;
import pe.com.tintegro.dto.response.InsertarEntradaDirectResponse;
import pe.com.tintegro.dto.response.InsertarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ListarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ValidarDirectorioResponse;
import pe.com.tintegro.services.GrupoDirectorioServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/grupoDirectorio")
public class GrupoDirectorioController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "grupoDirectorioServices")
	protected GrupoDirectorioServices grupoDirectorioServices;

	@RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertarGrupoDirectResponse insertarGrupoDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody InsertarGrupoDirectRequest request)
	{

		InsertarGrupoDirectResponse response = new InsertarGrupoDirectResponse();
		try
		{
			response = grupoDirectorioServices.insertarGrupoDirectorio(codUsuario, idInstancia, request);
			response.setInsertado(response.getInsertado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido insertar Grupo Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarGrupoDirectResponse listarGrupoDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarGrupoDirectRequest request)
	{

		ListarGrupoDirectResponse response = new ListarGrupoDirectResponse();
		try
		{
			response = grupoDirectorioServices.listarGrupoDirectorio(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta a grupos de directorios exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ActualizarGrupoDirectResponse actualizarGrupoDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ActualizarGrupoDirectRequest request)
	{

		ActualizarGrupoDirectResponse response = new ActualizarGrupoDirectResponse();
		try
		{
			response = grupoDirectorioServices.actualizarGrupoDirectorio(codUsuario, idInstancia, request);
			response.setActualizado(response.getActualizado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar Grupo Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EliminarGrupoDirectResponse eliminarGrupoDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody EliminarGrupoDirectRequest request)
	{

		EliminarGrupoDirectResponse response = new EliminarGrupoDirectResponse();
		try
		{
			response = grupoDirectorioServices.eliminarGrupoDirectorio(codUsuario, idInstancia, request);
			response.setEliminado(response.getEliminado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido eliminado Grupo Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	// Entrada Directorio

	@RequestMapping(value = "/insertarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertarEntradaDirectResponse insertarEntradaDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody InsertarEntradaDirectRequest request)
	{

		InsertarEntradaDirectResponse response = new InsertarEntradaDirectResponse();
		try
		{
			response = grupoDirectorioServices.insertarEntradaDirectorio(codUsuario, idInstancia, request);
			response.setInsertado(response.getInsertado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido insertar Entrada de Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarEntradaDirectResponse listarEntradaDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarEntradaDirectRequest request)
	{

		ListarEntradaDirectResponse response = new ListarEntradaDirectResponse();
		try
		{
			response = grupoDirectorioServices.listarEntradaDirectorio(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de grupos de Directorio de entrada exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar Entrada de Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/actualizarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ActualizarEntradaDirectResponse actualizarEntradaDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody ActualizarEntradaDirectRequest request)
	{

		ActualizarEntradaDirectResponse response = new ActualizarEntradaDirectResponse();
		try
		{
			response = grupoDirectorioServices.actualizarEntradaDirectorio(codUsuario, idInstancia, request);
			response.setActualizado(response.getActualizado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar Grupo Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/eliminarEntrada", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EliminarEntradaDirectResponse eliminarEntradaDirectorio(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia, @RequestBody EliminarEntradaDirectRequest request)
	{

		EliminarEntradaDirectResponse response = new EliminarEntradaDirectResponse();
		try
		{
			response = grupoDirectorioServices.eliminarEntradaDirectorio(codUsuario, idInstancia, request);
			response.setEliminado(response.getEliminado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido eliminado Entrada de Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/validarDirectorio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ValidarDirectorioResponse validarGrupoDirectorio(@RequestBody ValidarDirectorioRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{

		ValidarDirectorioResponse response = new ValidarDirectorioResponse();

		try
		{
			response = grupoDirectorioServices.validarGrupoDirectorio(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Validacion de Directorios exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido validar Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/validarEntradaDirectorio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ValidarDirectorioResponse validarEntradaDirectorio(@RequestBody ValidarDirectorioRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia)
	{

		ValidarDirectorioResponse response = new ValidarDirectorioResponse();

		try
		{
			response = grupoDirectorioServices.validarEntradaDirectorio(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Validacion de grupos de directorios de entrada exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido validar Entrada Directorio");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}
}
