package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Territorio;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.services.TerritorioServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class TerritorioServicesTest {
	@Autowired
	TerritorioServices territorioServices;
	@Test
	public void testClientesList() throws Exception{
		int contador = 1;
		ListaTerritorioRequest request = new ListaTerritorioRequest();
		request.setpCoPais(null);
			ListaTerritorioResponse response = territorioServices.listaTerritorio(request);
			for (Territorio general : response.getTerritoriolist()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getCodigo());
				System.out.println(general.getNombre());
				contador++;
				System.out.println("*****************************************************");
			}
	}
}
