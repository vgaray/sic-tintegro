package pe.com.tintegro.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.CargaEstadoConfigInstanciaResponse;
import pe.com.tintegro.dto.response.EvaluarInstanciaResponse;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxCasoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/instancia")
public class InstanciaController
{

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaService;

	@RequestMapping(value = "/listaInstanciaxId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaInstanciaxIdResponse listarxIdInstancia(@RequestBody ListaInstanciaxIdRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)

	{
		ListaInstanciaxIdResponse response = new ListaInstanciaxIdResponse();

		try
		{
			response = instanciaService.listarIntanciaxIdInstancia(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Listado por id exitoso");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la Lista de instancia");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;

	}

	@RequestMapping(value = "/listaInstanciaxCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarInstanciaxIdClienteResponse listarInstanciaxIdCliente(@RequestBody ListarInstanciaxIdClienteRequest obj, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia) throws Exception

	{
		ListarInstanciaxIdClienteResponse respuesta = new ListarInstanciaxIdClienteResponse();

		try
		{

			respuesta = instanciaService.listarIntanciaxIdCliente(codUsuario, obj);
			respuesta.setEstado(Constantes.ESTADO_TRAMA_OK);
			respuesta.setMensaje("Listado por id exitoso");
		}
		catch (Exception e)
		{
			respuesta.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			respuesta.setCodError(codError);
			respuesta.setMensaje("No ha sido posible mostrar la Lista de instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return respuesta;

	}

	@RequestMapping(value = "/listaInstanciaxCaso", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarInstanciaxCasoResponse listarInstanciaxCaso(@RequestBody ListarInstanciaxCasoRequest obj, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia) throws Exception

	{
		ListarInstanciaxCasoResponse respuesta = new ListarInstanciaxCasoResponse();

		try
		{

			respuesta = instanciaService.listarIntanciaxCaso(codUsuario, obj);
			respuesta.setEstado(Constantes.ESTADO_TRAMA_OK);
			respuesta.setMensaje("Listado por id exitoso");
		}
		catch (Exception e)
		{
			respuesta.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			respuesta.setCodError(codError);
			respuesta.setMensaje("No ha sido posible mostrar la Lista de instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return respuesta;

	}

	@RequestMapping(value = "/insertarInstancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertarInstanciaResponse InsertarInstancia(@RequestBody InsertarInstanciaRequest obj, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstancia) throws Exception
	{
		InsertarInstanciaResponse respuesta = new InsertarInstanciaResponse();
		respuesta.setEstado(Constantes.ESTADO_TRAMA_OK);
		respuesta.setMensaje("Instancia Guardada");
		respuesta.setInserto(respuesta.getInserto());
		try
		{
			respuesta = instanciaService.insertarInstancia(codUsuario, obj);
		}
		catch (Exception e)
		{
			respuesta.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			respuesta.setCodError(codError);
			respuesta.setMensaje("No ha sido posible mostrar la Lista de instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return respuesta;
	}
	@RequestMapping(value = "/insertarN", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertarInstanciaNResponse insertarInstanciaN(@RequestBody InsertarInstanciaNRequest obj, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token) throws Exception
	{
		InsertarInstanciaNResponse respuesta = new InsertarInstanciaNResponse();

		try
		{
			respuesta = instanciaService.insertarInstanciaN(codUsuario, obj);
		}
		catch (Exception e)
		{
			respuesta.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			respuesta.setCodError(codError);
			respuesta.setMensaje("No ha sido posible registrar Instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}

		return respuesta;

	}

	@RequestMapping(value = "/listaInstancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaInstanciaResponse listaInstancia(@RequestBody ListaInstanciaRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token) throws Exception

	{
		ListaInstanciaResponse response = new ListaInstanciaResponse();
		try
		{
			response = instanciaService.listaInstancia(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Se cargo correctamente las instancias");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible consultar la lista de instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/evaluaInstancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EvaluarInstanciaResponse evaluarInstancia(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)
	{
		EvaluarInstanciaResponse response = new EvaluarInstanciaResponse();
		try
		{
			System.out.println("evalua instancia de: " + codUsuario);
			response = instanciaService.evaluarInstancia(codUsuario);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Evaluación de instancia exitosa");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible consultar la lista de instancia");
			Log.error( codError, e );
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		
		return response;
	}

	@RequestMapping(value = "/actualizarInstancia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ActualizarInstanciaResponse actualizarInstancia(@RequestBody ActualizarInstanciaRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)
	{
		ActualizarInstanciaResponse response = new ActualizarInstanciaResponse();

		try
		{
			response = instanciaService.actualizarInstancia(codUsuario, request);
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible la actualización de la instancia");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}

		return response;
	}

	@RequestMapping(value = "/cargar-estado-configuracion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CargaEstadoConfigInstanciaResponse loadStatusConfigInitialInstance(@RequestHeader("codUsuario") String codUser, @RequestHeader("token") String token,
			@RequestHeader("idInstancia") String idInstance) throws Exception
	{
		CargaEstadoConfigInstanciaResponse response = new CargaEstadoConfigInstanciaResponse();

		try
		{
			response = instanciaService.loadStatusConfigInitialInstance(codUser, idInstance);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Listado del estado de configuración de la instancia exitoso.");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("Error al listar el estado de configuración de la instancia.");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}

		return response;
	}
	
	@RequestMapping(value = "/listaInstanciasEmpresa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaInstanciasPorEmpresaResponse listaInstanciasPorEmpresa(@RequestBody ListaInstanciasPorEmpresaRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)

	{
		ListaInstanciasPorEmpresaResponse response = new ListaInstanciasPorEmpresaResponse();

		try
		{
			response = instanciaService.listaInstanciasPorEmpresa(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Listado exitoso");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible mostrar la Lista de instancia");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;

	}

}
