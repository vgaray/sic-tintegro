package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;
import pe.com.tintegro.services.MarcaTelefonoServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MarcaTelefonoServicesTest
{
	@Autowired
	MarcaTelefonoServices marcaTelefonoServices;

	@Test
	public void testMarcaTelefonoList()
	{
		try
		{
			ListaMarcaTelefonoResponse response = marcaTelefonoServices
					.listaMarcaTelefono("codusuariox","1");
			System.out.println(response.getMarcaTelefonoList().size());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
