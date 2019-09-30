package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.GrabacionDAO;
import pe.com.tintegro.dominio.Grabacion;
import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GrabacionDAOTest {
	@Autowired
	GrabacionDAO listargrabaciones;
	@Test
	public void testListaGrabacion()
	{
		try
		{	GrabacionRequest request = new GrabacionRequest();
				request.setAgente(null);
				request.setTipo("EXTEN_OUT");
				request.setOrigen(null);
				request.setDestino(null);
				request.setFeInicon("2017-01-10");
				request.setFeFincon("2018-10-10");
				request.setpHorai("06:00:00");
				request.setpHoraf("18:00:00");
				request.setTipoFun(2);
				
				GrabacionResponse response = listargrabaciones.listarGrabaciones("192.168.3.202", request);
			System.out.println("Tamaño de lista"+response.getLsAudioA().size());
			for (Grabacion general : response.getLsAudioA())
			{
				System.out.println(general.getTipo());
			}
		}
		catch (Exception e)
		{
			System.out.println(""+e.getMessage());
		}
	  }
}
