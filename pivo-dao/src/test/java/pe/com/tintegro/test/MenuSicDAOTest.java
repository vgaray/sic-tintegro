package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.MenuSicDAO;
import pe.com.tintegro.dominio.MenuSic;
import pe.com.tintegro.dto.request.MenuSicRequest;
import pe.com.tintegro.dto.response.MenuSicResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{ "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class MenuSicDAOTest
{
	@Autowired
	MenuSicDAO menuSicDAO;

	@Test
	public void testMenuSicListar()
	{
		try
		{
			MenuSicRequest request = new MenuSicRequest();
			request.setNomLogin("cli");
			request.setTipoMenu(2);
			List<MenuSic> lista = new ArrayList<MenuSic>();
			MenuSicResponse menuSicResponse = menuSicDAO.listaMenu(request);
			lista = menuSicResponse.getMenuLista();
			System.out.println("cantidad de item: " + menuSicResponse.getMenuLista().size());
			for (MenuSic menuSic : lista)
			{
				System.out.println(menuSic.getNomPagina() + " " + menuSic.getNomComponente() + " " + menuSic.getNomUrl() + " " + menuSic.getNomIcono());

			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
