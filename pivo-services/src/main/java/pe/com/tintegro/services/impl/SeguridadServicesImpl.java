package pe.com.tintegro.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pe.com.tintegro.dao.SeguridadDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.CheckTokenRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAInstanciaRequest;
import pe.com.tintegro.dto.request.ValidaAccesoAServicioRequest;
import pe.com.tintegro.dto.response.CheckTokenResponse;
import pe.com.tintegro.dto.response.ValidaAccesoAInstanciaResponse;
import pe.com.tintegro.dto.response.ValidaAccesoAServicioResponse;
import pe.com.tintegro.dto.response.ValidaAccessTokenResponse;
import pe.com.tintegro.services.SeguridadServices;
import pe.com.tintegro.services.util.EncriptaUtils;

@Service("seguridadServices")
public class SeguridadServicesImpl implements SeguridadServices {
	
	@Autowired
	private SeguridadDAO seguridadDAO;

	@Override
	public ValidaAccesoAServicioResponse validarAccesoAServicio(ValidaAccesoAServicioRequest request) throws Exception {
		ValidaAccesoAServicioResponse response = new ValidaAccesoAServicioResponse();
		List<Confirmacion> confirmacionList = seguridadDAO.validarAccesoAServicio(request.getNoLogin(), request.getNoUrl(), request.getIlIstancia());
		Confirmacion confirmacion = confirmacionList.get(0);
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public ValidaAccessTokenResponse validarAccessToken(CheckTokenRequest request) throws Exception {
		ValidaAccessTokenResponse vatResponse = new ValidaAccessTokenResponse();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("codUsuario", request.getCodUsuario());

		HttpEntity<Object> entity = new HttpEntity<Object>(request, headers);

		String url = "http://localhost:8080/sic-oauth2-ws/oauth/token/check_token";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("token", request.getToken());

		ResponseEntity<CheckTokenResponse> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entity, CheckTokenResponse.class);
		CheckTokenResponse response = responseEntity.getBody();
		Confirmacion confirmacion = new Confirmacion();

		if (response.getClientId() == null) {
			confirmacion.setID(Constantes.ESTADO_TRAMA_ERROR_NEGOCIO);
			confirmacion.setMensaje("El token de acceso no es valido.");
		} else {
			confirmacion.setID(Constantes.ESTADO_TRAMA_OK);
			confirmacion.setMensaje("Token de acceso valido.");
		}
		
		vatResponse.setConfirmacion(confirmacion);
		return vatResponse;
	}

	@Override
	public ValidaAccesoAInstanciaResponse validarAccesoAInstancia(ValidaAccesoAInstanciaRequest request) throws Exception {
		ValidaAccesoAInstanciaResponse response = new ValidaAccesoAInstanciaResponse();
		Confirmacion confirmacion = null;
		Integer idInstancia = Integer.parseInt(EncriptaUtils.desencriptar(request.getIdInstancia()));
		List<Confirmacion> confirmacionList = seguridadDAO.validarAccesoAInstancia(request.getNoLogin(), idInstancia);
		confirmacion = confirmacionList.get(0);
		response.setConfirmacion(confirmacion);
		return response;
	}

	@Override
	public Confirmacion validarIDInstancia(String idInstancia) throws Exception {
		Confirmacion confirmacion = new Confirmacion();
		Integer ID = Constantes.ESTADO_TRAMA_OK;
		String mensaje = "OK";

		if (idInstancia != null && !idInstancia.equals("null") && !EncriptaUtils.esEcriptacionValida(idInstancia)) {
			ID = Constantes.ESTADO_TRAMA_ERROR_NEGOCIO;
			mensaje = "Error en el ID de instancia. La encriptacion no es valida";
		}

		confirmacion.setID(ID);
		confirmacion.setMensaje(mensaje);
		return confirmacion;
	}
}
