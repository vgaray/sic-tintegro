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
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarHistoriaClinicaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.services.HistoriaClinicaServices;
import pe.com.tintegro.services.MascotaServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/historia-clinica")
public class HistoriaClinicaController {
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "historiaClinicaServices")
	protected HistoriaClinicaServices historiaClinicaService;
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)		
	public ListarHistoriaClinicaResponse listarHistoriaClinica(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody ListarHistoriaClinicaRequest request){
		ListarHistoriaClinicaResponse response =new ListarHistoriaClinicaResponse();
		try
		{
			response = historiaClinicaService.listarHistoriaClinica(codUsuario,request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de historia clinica Exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido historia clinica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)		
	public CRUDResponse registrarHistoriaClinica(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody RegistrarHistoriaClinicaRequest request){
		CRUDResponse response =new CRUDResponse();
		try
		{
			response = historiaClinicaService.registrarHistoriaClininca(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Registro historia clinica Exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido registrar historia clinica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)		
	public CRUDResponse actualizarHistoriaClinica(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody ActualizarHistoriaClinicaRequest request){
		CRUDResponse response =new CRUDResponse();
		try
		{
			response = historiaClinicaService.actualizarHistoriaClininca(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Actualización historia clinica Exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar historia clinica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)		
	public CRUDResponse eliminarHistoriaClinica(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
			@RequestBody EliminarHistoriaClinicaRequest request){
		CRUDResponse response =new CRUDResponse();
		try
		{
			response = historiaClinicaService.eliminarHistoriaClininca(codUsuario, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Eliminación historia clinica Exitosa");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido eliminar historia clinica");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
}
