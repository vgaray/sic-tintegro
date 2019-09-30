package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.SipTrunk;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;
import pe.com.tintegro.services.SipTrunkServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SipTrunkServicesTest
{
	@Autowired
	SipTrunkServices sipTrunkServices;

	// @Test
	public void listarSipTrunk()
	{
		try
		{
			ListaSipTrunkRequest request = new ListaSipTrunkRequest();
			request.setIdSipTrunk(8);
			ListaSipTrunkResponse response = sipTrunkServices.listaSipTrunk("cli", "jPfFl7Jg2rg", request);

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

	 @Test
	public void generarSipTrunkTxtTest()
	{
		try
		{
			String cont = sipTrunkServices.generarSipTrunkTxt("cli", "jPfFl7Jg2rg");
			System.out.print(cont);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
}
