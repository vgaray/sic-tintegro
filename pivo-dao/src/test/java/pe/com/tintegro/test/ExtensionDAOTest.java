package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import pe.com.tintegro.dao.ExtensionDAO;
import pe.com.tintegro.dto.response.ListaExtensionResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class ExtensionDAOTest {
	
	
	
	@Autowired
	ExtensionDAO extensionDAO;
	
	@Test
	public void testListarExtesionList() {
		try {
			ListaExtensionResponse response = extensionDAO.listaExtension("192.168.3.206");
			System.out.println(response.getExtensionList().size());
			
			for (pe.com.tintegro.dominio.Extension extension : response.getExtensionList()) {

				System.out.println("extension: "
						+ extension.getNombre()+" "+extension.getCallerId());

			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
