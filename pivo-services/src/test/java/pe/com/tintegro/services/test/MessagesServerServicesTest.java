package pe.com.tintegro.services.test;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.SendMessageRequest;
import pe.com.tintegro.dto.response.SendMessageResponse;
import pe.com.tintegro.services.MessagesServerServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MessagesServerServicesTest
{
    
	@Autowired
   protected MessagesServerServices messagesServerServices;
	
	
	@Test
	//@Ignore
	public void testEnviar (){
		SendMessageRequest request= new SendMessageRequest();
		request.setNombreApp("app8");
		request.setCodUsuario("codu8");
		request.setServicio("serv8");
		request.setRequests("req8");
		request.setHeaders("head8");
		//request.setFecha(new Date());
		SendMessageResponse response = new SendMessageResponse();
		try
		{
			response=messagesServerServices.enviarMensajeCola(request);	
			
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
}
