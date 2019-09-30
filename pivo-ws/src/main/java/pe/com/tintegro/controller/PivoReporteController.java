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
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.response.ListarMascotaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.PivoReporteServices;
import pe.com.tintegro.services.util.Util;
	@RestController
	@RequestMapping("/pivoReporte")
public class PivoReporteController {
		protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
		@Resource(name = "pivoReporteServices")
		protected PivoReporteServices pivoReporteServices;	
		//--------------------------------------------------------------------------------------
			@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseStatus(value = HttpStatus.OK)		
			public ListarPersonalResponse listarPersonal(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
					@RequestBody ListarPersonalRequest request){
				ListarPersonalResponse response =new ListarPersonalResponse();
				try
				{
					response = pivoReporteServices.reporteListarPersonal(codUsuario, idInstancia,request);
					response.setEstado(Constantes.ESTADO_TRAMA_OK);
					response.setMensaje("Generación de reporte de Personal Exitosa");
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
			//--------------------------------------------------------------------------------------
			@RequestMapping(value = "/listarMascotas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseStatus(value = HttpStatus.OK)		
			public ListarMascotaResponse listarMascotas(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token,
					@RequestBody ListarMascotaRequest request){
				ListarMascotaResponse response =new ListarMascotaResponse();
				try
				{
					response = pivoReporteServices.reporteListarMascota(codUsuario,request);
					response.setEstado(Constantes.ESTADO_TRAMA_OK);
					response.setMensaje("Generación de reporte de Mascota Exitosa");
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
}
