package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.SipTrunkDAO;
import pe.com.tintegro.dominio.SipTrunk;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SipTrunkDAOTest
{
	@Autowired
	SipTrunkDAO sipTrunkDAO;
	
	@Test
	public void listarSipTrunk(){
		try
		{
			ListaSipTrunkRequest request = new ListaSipTrunkRequest();
			request.setIdSipTrunk(8);
			ListaSipTrunkResponse response = sipTrunkDAO.listaSipTrunk("192.168.3.202", request);
			
			for (SipTrunk sipTrunk : response.getListaSipTrunk())
			{
				System.out.println(sipTrunk.getHostSaliente());
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
