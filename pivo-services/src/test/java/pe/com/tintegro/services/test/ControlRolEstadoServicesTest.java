package pe.com.tintegro.services.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dto.request.ListaControlRolEstadoRequest;
import pe.com.tintegro.dto.response.ListaControlRolEstadoResponse;
import pe.com.tintegro.services.ControlRolEstadoServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ControlRolEstadoServicesTest
{	
	@Autowired
	ControlRolEstadoServices controlRolEstadoServices;
	@Test
	public void testListarControlRolEstadoServices()
	{
		try{
			ListaControlRolEstadoRequest request = new ListaControlRolEstadoRequest();
			request.setNoLogin("cli");
			request.setTiElemto(1);
			request.setIdEstadoelemento(4);
			ListaControlRolEstadoResponse response = controlRolEstadoServices.listarControlRolEstadoServices("var", request);
			System.out.println(response.getValidarControlResult().get(0));
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
