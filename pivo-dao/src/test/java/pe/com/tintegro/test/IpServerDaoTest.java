package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.IpServerDAO;
import pe.com.tintegro.dominio.IpServer;
import pe.com.tintegro.dto.request.ListarIpServerRequest;
import pe.com.tintegro.dto.response.ListarIpServerResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class IpServerDaoTest {
	@Autowired
	IpServerDAO ipserverDao;
	@Test
	public void testIpServerListar() throws Exception {
		int contador = 1;
		ListarIpServerRequest request=new ListarIpServerRequest();
		request.setpIdTipodetalle(1);
			ListarIpServerResponse response = ipserverDao.listaipserver(request);
			System.out.println("Tamaño de lista"
					+ response.getIpServerLis().size());
			for (IpServer general : response.getIpServerLis()) {
				System.out.println("fila:" + contador);
				System.out.println(general.getNoIpServer());
				contador++;
				System.out.println("*****************************************************");
				
		}
	}
}
