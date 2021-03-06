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
import pe.com.tintegro.dto.request.EditaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.EliminaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.InsertaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaPorIdGrupoHorarioRequest;
import pe.com.tintegro.dto.response.EditaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.EliminaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.InsertaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdGrupoHorarioResponse;
import pe.com.tintegro.services.GrupoHorarioServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/grupoHorario")
public class GrupoHorarioController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "grupoHorarioServices")
	protected GrupoHorarioServices grupoHorarioServices;

	@RequestMapping(value = "insertaGrupoHorario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public InsertaGrupoHorarioResponse insertaGrupoHorario(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody InsertaGrupoHorarioRequest request)
	{
		InsertaGrupoHorarioResponse response = new InsertaGrupoHorarioResponse();
		try
		{
			response = grupoHorarioServices.insertaGrupoHorario(codUsuario, idInstancia, request);
			response.setResultado(response.getResultado());
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido agregar grupo horario ");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "editaGrupoHorario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EditaGrupoHorarioResponse editaGrupoHorario(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody EditaGrupoHorarioRequest request)
	{
		EditaGrupoHorarioResponse response = new EditaGrupoHorarioResponse();
		try
		{
			response = grupoHorarioServices.editaGrupoHorario(codUsuario, idInstancia, request);
			response.setResultado(response.getResultado());
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido actualizar  grupo horario ");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "eliminaGrupoHorario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public EliminaGrupoHorarioResponse eliminaGrupoHorario(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody EliminaGrupoHorarioRequest request)
	{
		EliminaGrupoHorarioResponse response = new EliminaGrupoHorarioResponse();
		try
		{
			response = grupoHorarioServices.eliminaGrupoHorario(codUsuario, idInstancia, request);
			response.setResultado(response.getResultado());
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido Eliminar grupo horario ");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "listaGrupoHorario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaGrupoHorarioResponse listaGrupoHorario(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListaHorariosLibresRequest request)
	{
		ListaGrupoHorarioResponse response = new ListaGrupoHorarioResponse();
		try
		{
			response = grupoHorarioServices.listaGrupoHorario(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de Grupo Horario exitosa");
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido  mostrar grupo horario ");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}

	@RequestMapping(value = "listaPorIdGrupoHorario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaPorIdGrupoHorarioResponse listaPorIdGrupoHorario(@RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token, @RequestHeader("idInstancia") String idInstancia,
			@RequestBody ListaPorIdGrupoHorarioRequest request)
	{
		ListaPorIdGrupoHorarioResponse response = new ListaPorIdGrupoHorarioResponse();
		try
		{
			response = grupoHorarioServices.listaPorIdGrupoHorario(codUsuario, idInstancia, request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Consulta de grupo horario exitosa");
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido  mostrar grupo horario ");
			System.out.println(ex.getMessage());
			LOGGER.error(codError, ex);
		}
		return response;
	}
}
