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
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.services.TerritorioServices;
import pe.com.tintegro.services.util.Util;

import org.springframework.cache.annotation.CachePut;

@RestController
@RequestMapping("/territorio")

public class TerritorioController {
	
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());
	@Resource(name = "TerritorioServices")
	protected TerritorioServices territorioServices;
	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListaTerritorioResponse listarTerritorio(@RequestBody ListaTerritorioRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token) throws Exception
	{
		ListaTerritorioResponse response = new ListaTerritorioResponse();
		try {
			response=territorioServices.listaTerritorio(request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("Territorios obtenidos correctamente");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar territorio");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		
		return response;
	}

}
