package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.LlamadaDestinoDAO;
import pe.com.tintegro.dominio.LlamadaDestino;
import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.response.ListarLlamadaDestinoResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class LlamadaDestinoDAOTest {
	@Autowired
	LlamadaDestinoDAO llamadaDestinoDAO;

	@Test
	public void testLlamadaDestinoList() {
		try {
			ListarLlamadaDestinoRequest request = new ListarLlamadaDestinoRequest();

			request.setpIdArea(0);
			request.setpIdCentcos(20);
			request.setpFeIni("2017-01-01");
			request.setpHoIni("00:00");
			request.setpFeFin("2017-01-01");
			request.setpHoFin("23:59");
			ListarLlamadaDestinoResponse response = llamadaDestinoDAO.listaLlamadaDestino("192.168.3.202", request);
			System.out.println(response.getListaLLamadasDestino().size());
			for (LlamadaDestino destino : response.getListaLLamadasDestino()) {
				System.out.println(destino.getDestino() + " || " + destino.getMinutos() + " || " + destino.getHoras());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
