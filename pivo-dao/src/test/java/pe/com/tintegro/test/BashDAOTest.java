package pe.com.tintegro.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.BashDAO;
import pe.com.tintegro.dominio.Bash;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class BashDAOTest
{
	@Autowired
	private BashDAO bashDAO;
	
	@Test
	public void loadBashByIdTest()
	{
		int idBash = 5;
		
		try
		{
			Bash bash = bashDAO.loadBashById( idBash );
			Assert.assertNotNull( bash );
			System.out.println( String.format( "Bash ID: %s\nDescripcion: %s\nRuta: %s\nTipo: %s\nUltimo? %s", bash.getIdBash(), bash.getNoDescrip(), bash.getNoRuta(), bash.getNuTipo(), bash.isIlUltimo() ) );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
