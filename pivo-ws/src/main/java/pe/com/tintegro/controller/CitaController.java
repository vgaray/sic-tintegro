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
import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.EliminarPersonalRequest;
import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarCitaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.CitaServices;
import pe.com.tintegro.services.PersonalServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/cita")
public class CitaController {

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "citaServices")
	protected CitaServices citaService;

	// --------------------------------------------------------------------------------------
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarCitaResponse listarCita(@RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarCitaRequest request) {
		ListarCitaResponse response = new ListarCitaResponse();
		try {
			response = citaService.listaCita(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Citas Exitosa");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido Personal");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

}
