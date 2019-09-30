package pe.com.tintegro.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;




import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import pe.com.tintegro.dto.request.SendMessageRequest;
import pe.com.tintegro.dto.response.SendMessageResponse;
import pe.com.tintegro.services.MessagesServerServices;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AudUtil
{
	@Resource (name="messageServerServices")
	protected MessagesServerServices messageServerServices;
	
	public String obtenerCabeceras(AudUtilWrapper requestWrapper)
	{

		String cabeceraJSON = "";
		try
		{
			Enumeration<String> cabeceras = requestWrapper.getHeaderNames();

			Map<String, String> cabecerasMapper = new HashMap<String, String>();
			while (cabeceras.hasMoreElements())
			{
				String nombreCabecera = cabeceras.nextElement();
				cabecerasMapper.put(nombreCabecera, requestWrapper.getHeader(nombreCabecera));

			}

			ObjectMapper obm = new ObjectMapper();
			cabeceraJSON = obm.writeValueAsString(cabecerasMapper);

		}
		catch (Exception e)
		{
			// TODO: handle exception
		}

		return cabeceraJSON;
	}
	
	public SendMessageResponse obtenerMensajes (AudUtilWrapper requestWrapper) {
		SendMessageResponse responseT = new SendMessageResponse();

		SendMessageRequest requestT = new SendMessageRequest();
		
		requestT.setCodUsuario(requestWrapper.getHeader("codUsuario"));
		requestT.setNombreApp("PIVO");
		requestT.setServicio(requestWrapper.getRequestURI());
		requestT.setHeaders(obtenerCabeceras(requestWrapper));
		requestT.setRequests(requestWrapper.getBody());
		
		//responseT = messageServerServices.enviarMensajeCola(requestT);
		return responseT;
		
	}
	
	
}
