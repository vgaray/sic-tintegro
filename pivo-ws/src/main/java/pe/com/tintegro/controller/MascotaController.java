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
import pe.com.tintegro.dto.request.ActualizarMascotaRequest;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.services.MascotaServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "mascotaServices")
	protected MascotaServices mascotaService;

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarMascotaResponse listarMascota(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestBody ListarMascotaRequest request) {
		ListarMascotaResponse response = new ListarMascotaResponse();
		try {
			response = mascotaService.listarMascota(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de mascota Exitosa");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido mascota");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse registrarMascota(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestBody RegistrarMascotaRequest request) {
		CRUDResponse response = new CRUDResponse();
		try {
			response = mascotaService.registrarMascota(codUsuario, request);
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido registrar mascota");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse actualizarMascota(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestBody ActualizarMascotaRequest request) {
		CRUDResponse response = new CRUDResponse();
		try {
			response = mascotaService.actualizarMascota(codUsuario, request);
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar mascota");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public CRUDResponse eliminarMascota(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestBody EliminarMascotaRequest request) {
		CRUDResponse response = new CRUDResponse();
		try {
			response = mascotaService.eliminarMascota(codUsuario, request);

		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido eliminar mascota");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}
}
