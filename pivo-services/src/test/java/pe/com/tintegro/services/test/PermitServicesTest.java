package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Permit;
import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;
import pe.com.tintegro.services.PermitServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PermitServicesTest
{
	@Autowired
	PermitServices permitServices;

	@Test
	public void listaPermit()
	{
		try
		{
			ListaPermitRequest request = new ListaPermitRequest();
			request.setIdSipTrunk(8);
			ListaPermitResponse response = permitServices.listaPermit("cli", "jPfFl7Jg2rg", request);

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
