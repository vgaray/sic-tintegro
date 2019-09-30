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
import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.EliminarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.EliminarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;
import pe.com.tintegro.services.PlanSalienteServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/planSaliente")
public class PlanSalienteController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "planSalienteServices")
	protected PlanSalienteServices planSalienteServices;	

	@RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	public InsertarPlanSalienteResponse insertarPlanSaliente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody InsertarPlanSalienteRequest request){
		
		InsertarPlanSalienteResponse response =new InsertarPlanSalienteResponse();
		try
		{
			response = planSalienteServices.insertarPlanSaliente(codUsuario, idInstancia, request);
			response.setInsertado(response.getInsertado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido insertar Saliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	public ActualizarPlanSalienteResponse actualizarPlanSaliente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ActualizarPlanSalienteRequest request){
		
		ActualizarPlanSalienteResponse response =new ActualizarPlanSalienteResponse();
		try
		{
			response = planSalienteServices.actualizarPlanSaliente(codUsuario, idInstancia, request);
			response.setActualizado(response.getActualizado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar Saliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	public EliminarPlanSalienteResponse eliminarPlanSaliente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody EliminarPlanSalienteRequest request){
		
		EliminarPlanSalienteResponse response =new EliminarPlanSalienteResponse();
		try
		{
			response = planSalienteServices.eliminarPlanSaliente(codUsuario, idInstancia, request);
			response.setEliminado(response.getEliminado());
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido eliminar Saliente");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}	
	
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)	
	public ListarPlanSalienteResponse listarPlanSaliente(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListarPlanSalienteRequest request){
		
		ListarPlanSalienteResponse response =new ListarPlanSalienteResponse();
		try
		{
			response = planSalienteServices.listarPlanSaliente(codUsuario, idInstancia,request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Plan Salieste realizada");
		}
		catch (Exception ex)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}		
		return response;
	}		
}
