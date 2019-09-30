package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.TerritorioDAO;
import pe.com.tintegro.dominio.Territorio;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class TerritorioDAOTest {
	@Autowired
	TerritorioDAO territorioDAO;
	@Test
	public void testTerritorioListar() throws Exception {
		int contador = 1;
		ListaTerritorioRequest request=new ListaTerritorioRequest();
		request.setpCoPais("CM");
			ListaTerritorioResponse response = territorioDAO.listaTerritorio(request);
			System.out.println("Tamaño de lista"
					+ response.getTerritoriolist().size());
			for (Territorio general : response.getTerritoriolist()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getCodigo());
				System.out.println(general.getNombre());
				contador++;
				System.out.println("*****************************************************");
		}
	}

}
