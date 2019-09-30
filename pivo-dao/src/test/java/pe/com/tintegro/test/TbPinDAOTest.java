package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dao.TbPinDAO;
import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class TbPinDAOTest {

	@Autowired
	TbPinDAO TbPinDAO;

	public void testModificarFlagPin() {
		try {
			FlagTbPinRequest request = new FlagTbPinRequest();
			request.setIdUsupin(875);
			request.setIdClave(3);
			request.setIdTiptel(1);

			request.setEstado(0);

			FlagTbPinResponse response = TbPinDAO.modificarflagTbPin("192.168.3.206", request);
			System.out.println(response.getConfirma());
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	@Test
	public void buscaPin() {
		try {
			BuscaPinRequest request = new BuscaPinRequest();
			request.setNumPin("1111");
			BuscaPinResponse response = TbPinDAO.BuscaPin("192.168.3.202", request);
			System.out.println(response.getMensaje());
			System.out.println(response.getIlExistePin());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
