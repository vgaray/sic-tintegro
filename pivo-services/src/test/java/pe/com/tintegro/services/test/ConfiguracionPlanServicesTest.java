package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;
import pe.com.tintegro.services.ConfiguracionPlanServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ConfiguracionPlanServicesTest
{
	@Autowired
	private ConfiguracionPlanServices configuracionPlanServices;

	@Test
	public void cargarAnexosInicialesTest()
	{
		try
		{
			InsertaSipBuddieResponse response = configuracionPlanServices.cargarAnexosIniciales("codusuariox","1");
			System.out.println( "Insertados con éxito: " + response.getInsertado() );
		}
		catch (Exception e)
		{
			System.out.println( e.getMessage() );
		}
	}
}
