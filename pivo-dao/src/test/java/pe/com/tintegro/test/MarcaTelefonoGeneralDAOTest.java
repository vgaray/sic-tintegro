package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.MarcaTelefonoGeneralDAO;
import pe.com.tintegro.dto.request.ListaMarcaTelefonoRequest;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MarcaTelefonoGeneralDAOTest
{
	@Autowired
	MarcaTelefonoGeneralDAO marcaTelefonoGeneralDAO;

	@Test
	public void testMarcaTelefonoList()
	{
		try
		{
			ListaMarcaTelefonoRequest request = new ListaMarcaTelefonoRequest();
			ListaMarcaTelefonoResponse response = marcaTelefonoGeneralDAO.listaMarcaTelefonoGeneral(request);
			System.out.println(response.getMarcaTelefonoList().size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
