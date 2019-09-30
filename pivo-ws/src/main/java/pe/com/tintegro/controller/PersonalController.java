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
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.PersonalServices;
import pe.com.tintegro.services.util.Util;
@RestController
@RequestMapping("/personal")
public class PersonalController {

	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "personalServices")
	protected PersonalServices personalService;	
	//--------------------------------------------------------------------------------------
		@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseStatus(value = HttpStatus.OK)		
		public ListarPersonalResponse listarPersonal(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
				@RequestBody ListarPersonalRequest request){
			ListarPersonalResponse response =new ListarPersonalResponse();
			try
			{
				response = personalService.listarPersonal(codUsuario, idInstancia,request);
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje("Consulta de Personal Exitosa");
			}
			catch (Exception ex)
			{
				response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
				String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
				response.setCodError(codError);
				response.setMensaje("No se ha podido Personal");
				System.out.println(ex.getMessage());
				LOGGER.error(codError, ex);
			}		
			return response;
		}	
		@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseStatus(value = HttpStatus.OK)		
		public CRUDResponse eliminarPersonal(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
				@RequestBody EliminarPersonalRequest request){
			CRUDResponse response =new CRUDResponse();
			try
			{
				response = personalService.eliminarPersonal(codUsuario, idInstancia,request);
				
			}
			catch (Exception ex)
			{
				response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
				String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
				response.setCodError(codError);
				response.setMensaje("No se ha podido eliminar Personal");
				System.out.println(ex.getMessage());
				LOGGER.error(codError, ex);
			}		
			return response;
		}
		@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseStatus(value = HttpStatus.OK)		
		public CRUDResponse registrarPersonal(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
				@RequestBody RegistrarPersonalRequest request){
			CRUDResponse response =new CRUDResponse();
			try
			{
				response = personalService.registrarPersonal(codUsuario, idInstancia,request);
			
			}
			catch (Exception ex)
			{
				response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
				String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
				response.setCodError(codError);
				response.setMensaje("No se ha podido registrar el Personal");
				System.out.println(ex.getMessage());
				LOGGER.error(codError, ex);
			}		
			return response;
		}
		@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseStatus(value = HttpStatus.OK)		
		public CRUDResponse actualizarPersonal(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
				@RequestBody ActualizarPersonalRequest request){
			CRUDResponse response =new CRUDResponse();
			try
			{
				response = personalService.actualizarPersonal(codUsuario, idInstancia,request);
			
			}
			catch (Exception ex)
			{
				response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
				String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
				response.setCodError(codError);
				response.setMensaje("No se ha podido actualizar el Personal");
				System.out.println(ex.getMessage());
				LOGGER.error(codError, ex);
			}		
			return response;
		}
}
