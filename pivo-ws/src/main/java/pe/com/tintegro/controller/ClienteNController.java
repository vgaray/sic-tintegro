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
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.services.ClienteNServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/clienteN")
public class ClienteNController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "ClienteNServices")
	protected ClienteNServices clienteNServices;
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarClienteNResponse listarClienteN(@RequestBody ListarClienteNRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token) throws Exception
	{
		ListarClienteNResponse response = new ListarClienteNResponse();
		try
		{

			response = clienteNServices.listarClienteN(request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("clientes obtenidos correctamente");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("no se ha podido listar cliente");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}

	@RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public RegistrarClienteNResponse registrarClienteN(@RequestBody RegistrarClienteNRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)
			throws Exception
	{
		RegistrarClienteNResponse response = new RegistrarClienteNResponse();

		try
		{
			response = clienteNServices.registrarClienteN(request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible ingresar al cliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;

	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ActualizarClienteNResponse actualizarCliente(@RequestBody ActualizarClienteNRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)
			throws Exception
	{
		ActualizarClienteNResponse response = new ActualizarClienteNResponse();

		try
		{
			response = clienteNServices.actualizarClienteN(request);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible actualizar al cliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EliminarClienteNResponse eliminarCliente(@RequestBody EliminarClienteNRequest obj, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token) throws Exception
	{
		EliminarClienteNResponse response = new EliminarClienteNResponse();

		try
		{
			response = clienteNServices.eliminarClienteN(obj);
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No ha sido posible eliminar el cliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}

		return response;
	}

}
