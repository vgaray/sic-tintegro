package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Cita;
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.response.ListarCitaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;
import pe.com.tintegro.services.CitaServices;
import pe.com.tintegro.services.PersonalServices;
import pe.com.tintegro.services.impl.CitaServicesImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class CitaServicesTest {

	@Autowired
	protected CitaServicesImpl citaServices;

	@Test
	public void personalTest() {
		ListarCitaResponse response = new ListarCitaResponse();
		ListarCitaRequest request = new ListarCitaRequest();
		request.setpNuDocumento("71542088");
		request.setpIdTipoDocumento(null);
		request.setpIdEstado(null);
		request.setpTiFun(0);
		try {
			response = citaServices.listaCita("usuAdminis", "G2+70T286iM=", request);
			for (Cita per : response.getListaCita()) {
				System.out.println("nombre:" + response.getListaCita().toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
