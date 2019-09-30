package pe.com.tintegro.services.impl;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pe.com.tintegro.dto.request.SendMessageRequest;
import pe.com.tintegro.dto.response.SendMessageResponse;
import pe.com.tintegro.services.MessagesServerServices;

@Service("messageServerServices")
public class MessagesServerServicesImpl implements MessagesServerServices
{

	@Override
	public SendMessageResponse enviarMensajeCola(SendMessageRequest request)
	{
		SendMessageResponse response = new SendMessageResponse();

		try
		{
			RestTemplate restTemplate = new RestTemplate();
			

			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			
			String url = "http://localhost:9090/sic-auditoria-api/queue/envio";

			response = restTemplate.postForObject(url, request, SendMessageResponse.class);
			
//			HttpComponentsClientHttpRequestFactory rf = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
//			//rf.setReadTimeout(1500);
//			rf.setConnectTimeout(4000);
//			rf.setReadTimeout(4000);
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.println("No se pudo Enviar Mensaje de Cola");

		}

		return response;
	}

	public ClientHttpRequestFactory getClientHttpRequestFactory()
	{
		// int timeout = 3000;
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectionRequestTimeout(2000);
		factory.setConnectTimeout(2000);

		return factory;
	}
}
