package pe.com.tintegro.interceptor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pe.com.tintegro.dto.request.SendMessageRequest;
import pe.com.tintegro.dto.response.SendMessageResponse;
import pe.com.tintegro.services.MessagesServerServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component("auditoriaAPISCOL")
public class RequestWrapperFilter implements Filter
{

	@Resource(name = "messageServerServices")
	protected MessagesServerServices messagesServerServices;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{

		SendMessageResponse responseT = new SendMessageResponse();

		AudUtilWrapper requestWrapper = new AudUtilWrapper((HttpServletRequest) request);

		SendMessageRequest requestT = new SendMessageRequest();
		String codUsuario = requestWrapper.getHeader("codUsuario");
	   requestT.setCodUsuario(codUsuario);
		requestT.setNombreApp("PIVO");
		requestT.setServicio(requestWrapper.getRequestURI());
		requestT.setHeaders(obtenerCabeceras(requestWrapper));
		requestT.setRequests(requestWrapper.getBody());

	//	responseT = messagesServerServices.enviarMensajeCola(requestT);

//		ObjectMapper obm= new ObjectMapper();
//		String pedidoJson=obm.writerWithDefaultPrettyPrinter().writeValueAsString(requestT);
		
	//	System.out.println(pedidoJson+"");
	//	System.out.println("\n\nResultado: " + responseT.getEstado() + "--" + responseT.getMensaje() + "\n\n");
		
		//System.out.println(requestT.getHeaders());
		chain.doFilter(requestWrapper, response);

	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

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

	public String  formatJsonString(String json) {
		String prettyJson = "";
      ObjectMapper mapper = new ObjectMapper();
      try {
          Object jsonObject = mapper.readValue(json, Object.class);
          prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
          System.out.println(prettyJson);
      } catch (IOException e) {
          e.printStackTrace();
      }
      return prettyJson;
  }

}
