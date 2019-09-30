package pe.com.tintegro.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Territorio;
import pe.com.tintegro.dominio.UsuarioXCita;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;
import pe.com.tintegro.services.TerritorioServices;
import pe.com.tintegro.services.UsuarioCitaServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class UsuarioCitaServicesTest {
	@Autowired
	UsuarioCitaServices usuarioCitaServices;
	@Test
	public void testClientesList() throws Exception{
		ListarUsuarioCitaRequest request = new ListarUsuarioCitaRequest();
		request.setpNuDocumento("71542088");
			ListarUsuarioCitaResponse response = usuarioCitaServices.listaUsuarioCita(request);
			for (UsuarioXCita usu : response.getUsuarioCitaList()) {
				System.out.println("Cita:"+usu.toString());
			}
	}
}
