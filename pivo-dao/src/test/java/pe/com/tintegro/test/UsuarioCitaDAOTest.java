package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.TerritorioDAO;
import pe.com.tintegro.dao.UsuarioCitaDAO;
import pe.com.tintegro.dominio.Territorio;
import pe.com.tintegro.dominio.UsuarioXCita;
import pe.com.tintegro.dto.request.ListaTerritorioRequest;
import pe.com.tintegro.dto.request.ListarUsuarioCitaRequest;
import pe.com.tintegro.dto.response.ListaTerritorioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioCitaResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class UsuarioCitaDAOTest {
	@Autowired
	UsuarioCitaDAO usuarioCitaDAO;

	@Test
	public void testTerritorioListar() throws Exception {
		ListarUsuarioCitaRequest request = new ListarUsuarioCitaRequest();
		request.setpNuDocumento("71542088");
		ListarUsuarioCitaResponse response = usuarioCitaDAO.listaUsuarioCita(request);
		for (UsuarioXCita usu : response.getUsuarioCitaList()) {
			System.out.println("UsuarioLista :" + usu.toString());
		}

	}

}
