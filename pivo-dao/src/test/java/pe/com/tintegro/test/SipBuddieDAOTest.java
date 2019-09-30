package pe.com.tintegro.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.SipBuddieDAO;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class SipBuddieDAOTest {
	@Autowired
	SipBuddieDAO sipBuddieDAO;

	@Test
	@Ignore
	public void testSipBuddieInserta() {
		try {
			InsertaSipBuddieRequest request = new InsertaSipBuddieRequest();

			request.setNomUsuario("5325");
			request.setClaveUsuario("5325");
			request.setCallerId("5325");
			request.setBuzonBox("5325");
			request.setCorreoBox("ejemplo@correo.com");
			request.setMarcaId(5);
			request.setModeloId(4);
			request.setMac("test");
			request.setIpDominio("127.0.0.1");
			request.setRuta("c:/ruta/congig");

			InsertaSipBuddieResponse response = sipBuddieDAO.insertaSipBuddie("192.168.3.202", request);
			System.out.println(response.getInsertado());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testSipBuddieEdita() {
		try {
			EditaSipBuddieRequest request = new EditaSipBuddieRequest();

			request.setNomUsuario("5334");
			request.setClaveUsuario("233");
			request.setCallerId("233");
			request.setBuzonBox("233");
			request.setCorreoBox("editar@testito.com");
			request.setMarcaId(5);
			request.setModeloId(6);
			request.setMac("testito");
			request.setIpDominio("127.0.0.1");
			request.setRuta("c:/ruta/congig");

			EditaSipBuddieResponse response = sipBuddieDAO.editaSipBuddie("192.168.3.206", request);
			System.out.println(response.getEditado());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testSipBuddieElimina() {
		try {
			EliminaSipBuddieRequest request = new EliminaSipBuddieRequest();
			request.setNomUsuario("5334");
			EliminaSipBuddieResponse response = sipBuddieDAO.eliminaSipBuddie("192.168.3.206", request);
			System.out.println(response.getEliminado());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
