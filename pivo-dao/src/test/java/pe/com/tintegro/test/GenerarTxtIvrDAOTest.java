package pe.com.tintegro.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.GenerarTxtIvrDAO;
import pe.com.tintegro.dominio.GenerarTxtIvr;
import pe.com.tintegro.dto.request.GenerarTxtIvrReques;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GenerarTxtIvrDAOTest
{
	@Autowired
	private GenerarTxtIvrDAO generarTxtIvrDAO;
	
	@Test
	public void listarGenerarTxtIvrTest()
	{
		try
		{
			List<GenerarTxtIvr> lsGenerarTxtIvrs = generarTxtIvrDAO.listarGenerarTxtIvr( "192.168.3.254", new GenerarTxtIvrReques() ).getListGenerarTxtIvr();
			
			for ( GenerarTxtIvr generarTxtIvr : lsGenerarTxtIvrs )
			{
				System.out.println( String.format( "Grupo Horario: %s --> IVR: %s", generarTxtIvr.getNoGurpoHor(), generarTxtIvr.getNoIVR() ) );
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
