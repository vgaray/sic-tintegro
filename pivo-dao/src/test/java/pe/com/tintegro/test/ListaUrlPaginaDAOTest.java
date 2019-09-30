package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.ListaUrlPaginaDAO;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dto.request.ListaUrlPaginaRequest;
import pe.com.tintegro.dto.response.ListaUrlPaginaResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ListaUrlPaginaDAOTest {
	@Autowired
	ListaUrlPaginaDAO listaUrlPaginaDAO;
	
	@Test
	public void testListaUrlPagina(){
		try {
			ListaUrlPaginaRequest request = new ListaUrlPaginaRequest();
			request.setpNoComponente("principal.fax");
			ListaUrlPaginaResponse response = listaUrlPaginaDAO.listaUrlPaginaResponse("192.168.3.202", request);
			for(Pagina pagina : response.getLsPaginaUrl()){
				System.out.println(pagina.getIdPadre() + " " + pagina.getIdPadre() + " " + pagina.getNoComponente() + " " + pagina.getNoPagina());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}