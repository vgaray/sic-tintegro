package pe.com.tintegro.services.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Queues;
import pe.com.tintegro.dto.request.InsertarQueuesRequest;
import pe.com.tintegro.dto.request.ListarQueuesRequest;
import pe.com.tintegro.dto.response.InsertarQueuesResponse;
import pe.com.tintegro.dto.response.ListarQueuesResponse;
import pe.com.tintegro.services.QueuesServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class QueuesServicesTest
{
	@Autowired
	protected QueuesServices queuesServices;
	
	
	//@Test
	public void TestListarQueues()
	{
		try
		{
			ListarQueuesRequest request=new ListarQueuesRequest();
			ListarQueuesResponse response= queuesServices.listarQueues("cli", "jPfFl7Jg2rg=",request);
			for (Queues queues : response.getColaLista()) {
				System.out.println("Cola: "+ queues.getIdQueues()+" "+queues.getName());
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestInsertarQueues()
	{
		try
		{
			InsertarQueuesRequest request=new InsertarQueuesRequest();
			request.setName("COLA_N1");
			request.setMusiconHold("");
			request.setAnnounce("");
			request.setContext("");
			request.setTimeOut(55);
			request.setMonitorJoin("");
			request.setMonitorFormat("");
			request.setQueueYouAreNext("");
			request.setQueueThereAre("");
			request.setQueueCallsWaiting("");
			request.setQueueHoldTime("");
			request.setQueueMinutes("50");
			request.setQueueSeconds("100");
			request.setQueueLessThan("");
			request.setQueueThankYou("");
			request.setQueueReportHold("");
			request.setAnnounceFrequency(10);
			request.setAnnounceRoundSeconds(20);
			request.setAnnounceHoldtime("");
			request.setRetry(300);
			request.setWrapuptime(80);
			request.setMaxlen(70);
			request.setEventwhencalled("");
			request.setRinginuse("");
			InsertarQueuesResponse response=queuesServices.insertarQueues("192.168.3.202", "jPfFl7Jg2rg", request);
			//InsertarQueuesResponse response=queuesServices.insertarQueues("cli", "jPfFl7Jg2rg=",request);
			System.out.println(response.getInsertado());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
	
}
