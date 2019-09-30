package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.CitaDAO;
import pe.com.tintegro.dao.PersonalDAO;
import pe.com.tintegro.dominio.Cita;
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarCitaResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })

public class CitaDAOTest {
	@Autowired
	CitaDAO citaDao;

	@Test
	public void listarTest() {
		ListarCitaResponse response = new ListarCitaResponse();
		ListarCitaRequest request = new ListarCitaRequest();
		request.setpNuDocumento("71542088");
		request.setpIdTipoDocumento(null);
		request.setpIdEstado(null);
		request.setpTiFun(1);

		try {
			response = citaDao.listaCita("127.0.0.1", request);
			for (Cita per : response.getListaCita()) {
				System.out.println("nombre:" + response.getListaCita().toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getCause());
		}
	}

}
