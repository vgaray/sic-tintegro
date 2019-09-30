package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.MenuSic;
import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;
import pe.com.tintegro.services.MenuSicServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MenuSicTest
{
	@Autowired
	MenuSicServices menuSicServices;

	@Test
	public void testListaMenuSic()
	{
		try
		{
			MenuSicRequest request = new MenuSicRequest();
			request.setNomLogin("cli");
			request.setTipoMenu(2);
			MenuSicResponse response = menuSicServices.listaMenu("cli", "jPfFl7Jg2rg=", request);
			System.out.println(response.getMenuLista().size());
			for (MenuSic menu : response.getMenuLista())
			{
 				System.out.println(menu.getNomPagina() + " " + menu.getNomComponente()+ " " + menu.getNomIcono());
			}
		}
		catch (Exception ex)
		{
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
