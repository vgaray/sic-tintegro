package pe.com.tintegro.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.*;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.request.ListarPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;
import pe.com.tintegro.dto.response.ListarPaginaResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class PaginaDAOTest
{
	@Autowired
	PaginaDAO paginaDAO;

	// @Test
	public void testListarPagina()
	{
		ListarPaginaRequest request = new ListarPaginaRequest();

		try
		{
			List<Pagina> listPagina = new ArrayList<Pagina>();
			ListarPaginaResponse response = new ListarPaginaResponse();

			response = paginaDAO.listarPagina(request);
			listPagina = response.getListaPagina();
			for (int i = 0; i < listPagina.size(); i++)
			{
				System.out.println(listPagina.get(i).getIdPagina() + " " + listPagina.get(i).getNoPagina() + " " + listPagina.get(i).getIdPadre());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//@Test
	public void testListarPaginaGP()
	{
		ListarPaginaRequest request = new ListarPaginaRequest();
		
		List<Pagina> paginas = new ArrayList<Pagina>();
		try
		{
			ListarPaginaResponse response = new ListarPaginaResponse();
			response = paginaDAO.listarPaginasGP(request);
			paginas = response.getListaPagina();

			for (int i = 0; i < paginas.size(); i++)
			{
				System.out.println(paginas.get(i).getIdPagina() + " " + paginas.get(i).getNoPagina() + " " + paginas.get(i).getIdPadre()+" "+paginas.get(i).isSeleccionado());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListaUrlPagina(){
		System.out.println("asda");
		ListaUrlPaginaRequest request = new ListaUrlPaginaRequest();
		request.setpNoComponente("principal.musicOnHold");
		try {
			List<Pagina> paginas = new ArrayList<Pagina>();
			ListaUrlPaginaResponse response = new ListaUrlPaginaResponse();
			response = paginaDAO.listaUrlPagina(request);
			paginas = response.getLsPaginaUrl();
			for(int i = 0; i< paginas.size(); i++){
				System.out.println(paginas.get(i).getNoComponente() + " " + paginas.get(i).getNoUrl() + " " + paginas.get(i).getIlPadre());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
