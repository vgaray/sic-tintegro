package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Extension;
import pe.com.tintegro.dto.response.ListaExtensionResponse;
import pe.com.tintegro.services.ExtensionServices;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class ExtensionServicesTest {

	
	@Autowired
	ExtensionServices extensionServices;
	
	 @Test
	 public void testExtensionList() {
		 try {
			ListaExtensionResponse response=extensionServices.listaextension("codusuariox","1");
			System.out.println(response.getExtensionList().size());
			
			for (Extension usuario : response.getExtensionList()) {

				System.out.println("Nombre: "
						+ usuario.getNombre()+" "
								+ usuario.getCallerId());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
