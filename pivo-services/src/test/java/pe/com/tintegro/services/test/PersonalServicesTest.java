package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.PersonalServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class PersonalServicesTest {

	@Autowired
	protected PersonalServices personalServices;

	@Test
	public void personalTest() {
		ListarPersonalResponse response = new ListarPersonalResponse();
		ListarPersonalRequest request = new ListarPersonalRequest();
		request.setpNuDocumento("7");
		request.setpNoNombreApellido("");
		request.setpIdTipoDocumento(2);
		request.setpTiFun(0);
		try {
			response = personalServices.listarPersonal("usuAdminis", "i48tOpWev2Y=", request);
			for (Personal per : response.getLsPersonal()) {
				System.out.println("nombre:" + per.getNoPersonal());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
