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
import pe.com.tintegro.dto.request.ActualizarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.EliminarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarConstanteFisiologicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.ListarListadoProblemaResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.dto.response.ListarVacunaResponse;
import pe.com.tintegro.services.HistoriaClinicaServices;
import pe.com.tintegro.services.MascotaServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/historia-clinica-service")
public class HistoriaClinicaServiceController {
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "historiaClinicaServices")
	protected HistoriaClinicaServices historiaClinicaService;

	@RequestMapping(value = "/listarHC", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarHistoriaClinicaServiceResponse listarHistoriaClinica(@RequestHeader("idInstancia") String idInstancia,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody ListarHistoriaClinicaServiceRequest request) {
		ListarHistoriaClinicaServiceResponse response = new ListarHistoriaClinicaServiceResponse();
		try {
			response = historiaClinicaService.listarHistoriaClinicaService(idInstancia, codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de historia clinica Exitosa");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido historia clinica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listarCF", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarConstanteFisiologicaResponse listarConstanteFisiologica(
			@RequestHeader("idInstancia") String idInstancia, @RequestHeader("codUsuario") String codUsuario,
			@RequestHeader("token") String token, @RequestBody ListarHistoriaClinicaServiceRequest request) {
		ListarConstanteFisiologicaResponse response = new ListarConstanteFisiologicaResponse();
		try {
			response = historiaClinicaService.listarConstanteFisiologicaService(idInstancia, codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Constante Fisiologica");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar Constante Fisiologica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listarLP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarListadoProblemaResponse listarListadoProblema(@RequestHeader("idInstancia") String idInstancia,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody ListarHistoriaClinicaServiceRequest request) {
		ListarListadoProblemaResponse response = new ListarListadoProblemaResponse();
		try {
			response = historiaClinicaService.listarListadoProblemaService(idInstancia, codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de listado Problema Exitosa");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar listado Problema");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "/listarV", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarVacunaResponse listarVacuna(@RequestHeader("idInstancia") String idInstancia,
			@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody ListarHistoriaClinicaServiceRequest request) {
		ListarVacunaResponse response = new ListarVacunaResponse();
		try {
			response = historiaClinicaService.listarVacunaService(idInstancia, codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Vacuna Exitosa");
		} catch (Exception ex) {
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar Vacuna");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

}
