package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.QueuesDAO;
import pe.com.tintegro.dominio.Queues;
import pe.com.tintegro.dto.request.ActualizarQueuesRequest;
import pe.com.tintegro.dto.request.BuscarQueuesRequest;
import pe.com.tintegro.dto.request.EliminarQueuesRequest;
import pe.com.tintegro.dto.request.InsertarQueuesRequest;
import pe.com.tintegro.dto.request.ListarAgenteDisponiblesRequest;
import pe.com.tintegro.dto.request.ListarQueuesRequest;
import pe.com.tintegro.dto.response.ActualizarQueuesResponse;
import pe.com.tintegro.dto.response.BuscarQueuesResponse;
import pe.com.tintegro.dto.response.EliminarQueuesResponse;
import pe.com.tintegro.dto.response.InsertarQueuesResponse;
import pe.com.tintegro.dto.response.ListarAgenteDisponiblesResponse;
import pe.com.tintegro.dto.response.ListarQueuesResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class QueuesDAOTest
{
	@Autowired
	QueuesDAO queuesDAO;
	
	//@Test
	public void listarQueues(){
		try {
			ListarQueuesRequest request=new ListarQueuesRequest();
			ListarQueuesResponse response=queuesDAO.listarQueues("192.168.3.202",request);
			System.out.println(response.getColaLista().size());
			for (Queues queues : response.getColaLista()) {
				System.out.println("Nombre: "+ queues.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//@Test
	public void TestInsertarQueues()
	{
		try{
			InsertarQueuesRequest request=new InsertarQueuesRequest();
			request.setName("COLA9");
			request.setMusiconHold(null);
			request.setAnnounce(null);
			request.setContext("13");
			request.setTimeOut(12);
			request.setMonitorJoin(null);
			request.setMonitorFormat(null);
			request.setQueueYouAreNext(null);
			request.setQueueThereAre(null);
			request.setQueueCallsWaiting(null);
			request.setQueueHoldTime(null);
			request.setQueueMinutes(null);
			request.setQueueSeconds(null);
			request.setQueueLessThan(null);
			request.setQueueThankYou(null);
			request.setQueueReportHold(null);
			request.setAnnounceFrequency(null);
			request.setAnnounceRoundSeconds(null);
			request.setAnnounceHoldtime(null);
			request.setRetry(14);
			request.setWrapuptime(null);
			request.setMaxlen(151);
			request.setServiceLevel(null);
			request.setStrategy("Fewest Calls");
			request.setJoinEmpty(null);
			request.setLeavewhenempty(null);
			request.setEventmemberstatus(null);
			request.setEventwhencalled(null);
			request.setRinginuse("yes");
			InsertarQueuesResponse response=queuesDAO.insertarQueues("192.168.3.202",request);
			System.out.println(response.getInsertado());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
	
	@Test
	public void TestActualizarQueues()
	{
		try{
			ActualizarQueuesRequest request=new ActualizarQueuesRequest();
			request.setIdQueues(47);
			request.setName("COLA9");
			request.setMusiconHold(null);
			request.setAnnounce(null);
			request.setContext("13");
			request.setTimeOut(12);
			request.setMonitorJoin(null);
			request.setMonitorFormat(null);
			request.setQueueYouAreNext(null);
			request.setQueueThereAre(null);
			request.setQueueCallsWaiting(null);
			request.setQueueHoldTime(null);
			request.setQueueMinutes(null);
			request.setQueueSeconds(null);
			request.setQueueLessThan(null);
			request.setQueueThankYou(null);
			request.setQueueReportHold(null);
			request.setAnnounceFrequency(null);
			request.setAnnounceRoundSeconds(null);
			request.setAnnounceHoldtime(null);
			request.setRetry(14);
			request.setWrapuptime(null);
			request.setMaxlen(151);
			request.setServiceLevel(null);
			request.setStrategy("Fewest Calls");
			request.setJoinEmpty(null);
			request.setLeavewhenempty(null);
			request.setEventmemberstatus(null);
			request.setEventwhencalled(null);
			request.setRinginuse("yes");
			ActualizarQueuesResponse response=queuesDAO.actualizarQueues("192.168.3.202",request);
			System.out.println(response.getActualizado());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}		
	
	//@Test
	public void TestEliminarQueues()
	{
		try
		{
			EliminarQueuesRequest request =new EliminarQueuesRequest();
			request.setIdQueues(3);
			EliminarQueuesResponse response=queuesDAO.eliminarQueues("192.168.3.202",request);
			System.out.println(response.getEliminado());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
	
	//@Test
	public void TestBuscarQueues()
	{
		try{
			BuscarQueuesRequest request=new BuscarQueuesRequest();
			request.setIdQueues(1);
			BuscarQueuesResponse response=queuesDAO.buscarQueues("192.168.3.202", request);
			for (Queues queues: response.getBuscado())
			{
				System.out.println(queues.getIdQueues()+" "+queues.getName());
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//@Test
	public void listarAgentes(){
		try {
			ListarAgenteDisponiblesRequest request=new ListarAgenteDisponiblesRequest();
			ListarAgenteDisponiblesResponse response=queuesDAO.listarAgenteDisponible("192.168.3.202",request);
			System.out.println(response.getListado().size());
			for (Queues queues : response.getListado()) {
				System.out.println("Nombre: "+ queues.getIdAgente()+" "+queues.getNoAgente());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}
