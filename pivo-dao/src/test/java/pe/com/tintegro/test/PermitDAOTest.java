package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.PermitDAO;
import pe.com.tintegro.dominio.Permit;
import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PermitDAOTest
{
	@Autowired
	PermitDAO permitDAO;

	@Test
	public void listaPermit()
	{
		try
		{
			ListaPermitRequest request = new ListaPermitRequest();
			request.setIdSipTrunk(8);
			ListaPermitResponse response = permitDAO.listaPermit("192.168.3.202", request);

			for (Permit permit : response.getListaPermit())
			{
				System.out.println(permit.getIdPermit() + " " + permit.getIdSipTrunk() + " " + permit.getValor());
			}
			System.out.println(response.getEstado());
			System.out.println(response.getMensaje());
		}
		catch (Exception e)
		{
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
	}
}
