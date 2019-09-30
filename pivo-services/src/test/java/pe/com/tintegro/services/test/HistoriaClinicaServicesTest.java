package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.ListarHistoriaClinicaServiceRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaResponse;
import pe.com.tintegro.dto.response.ListarHistoriaClinicaServiceResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.services.ClienteNServices;
import pe.com.tintegro.services.HistoriaClinicaServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class HistoriaClinicaServicesTest {
	@Autowired
	HistoriaClinicaServices historiaServices;

	@Test
	public void testHistoriaist() {
		int contador = 1;
		ListarHistoriaClinicaServiceRequest request = new ListarHistoriaClinicaServiceRequest();
		request.setpNuChip("70339310-4");
		request.setpNoPass("123452678");
		request.setpIdInstancia(2);
		try {
			ListarHistoriaClinicaServiceResponse response = historiaServices
					.listarHistoriaClinicaService("G2+70T286iM=", "vinvitado", request);
			for (HistoriaClinicaService serv : response.getLsHistoriaClinica()) {
				System.out.println("HC:"+serv.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
