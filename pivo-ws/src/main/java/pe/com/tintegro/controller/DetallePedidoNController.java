package pe.com.tintegro.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.request.ListarDetallePedidoNRequest;
import pe.com.tintegro.dto.response.ListarDetallePedidoNResponse;
import pe.com.tintegro.services.DetallePedidoNServices;
import pe.com.tintegro.services.util.Util;

@RestController
@RequestMapping("/detallePedidoN")
public class DetallePedidoNController
{
	protected transient final Logger LOGGER = Logger.getLogger(this.getClass());

	@Resource(name = "detallePedidoNServices")
	protected DetallePedidoNServices detallePedidoNServices;

	@RequestMapping(value = "/listar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public ListarDetallePedidoNResponse listardetallePedido(@RequestBody ListarDetallePedidoNRequest request, @RequestHeader("codUsuario") String codUsuario, @RequestHeader("token") String token)
	{
		ListarDetallePedidoNResponse response = new ListarDetallePedidoNResponse();
		try
		{

			response = detallePedidoNServices.listardetallepedido(request);
			response.setEstado(Constantes.ESTADO_TRAMA_OK);
			response.setMensaje("detalle de pedidos obtenidos correctamente");
		}
		catch (Exception e)
		{
			response.setEstado(Constantes.ESTADO_TRAMA_ERROR_APP);
			String codError = Constantes.ID_ERROR_APP + Util.getCodigoErrorByDate();
			response.setCodError(codError);
			response.setMensaje("No se ha podido listar detalle pedido");
			System.out.println(e.getMessage());
			LOGGER.error(codError, e);
		}
		return response;
	}
}
