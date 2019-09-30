package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.FaxDAO;
import pe.com.tintegro.dominio.Fax;
import pe.com.tintegro.dto.request.ListarFaxRequest;
import pe.com.tintegro.dto.response.ListarFaxResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class FaxDAOTest {
	@Autowired
	private FaxDAO FaxDAO;

	@Test
	public void listarFax() {
		try {
			ListarFaxRequest request = new ListarFaxRequest();
			request.setIdFax(null);
			ListarFaxResponse response = FaxDAO.listarFax("192.168.3.202", request);
			for (Fax fax : response.getListado()) {
				System.out.println(fax.getIdFax() + " " + fax.getNoFaxVirtual());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
