package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.RankingLlamadasDAO;
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class RankingLlamadasDAOTest {
	@Autowired
	RankingLlamadasDAO RankingLlamadasDAO;

	// @Test
	public void listarReporteRankingLlamadasTest() {
		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			RankingLlamadasResponse response = new RankingLlamadasResponse();
			RankingLlamadasRequest objRanking = new RankingLlamadasRequest();

			// Date feIni = format.parse("2013-01-01");
			// Date feFin = format.parse("2016-02-21");
			objRanking.setFeIni("2013-01-01");
			objRanking.setFeFin("2016-02-21");
			objRanking.setHoraIni("00:00:00");
			objRanking.setHorafin("00:00:00");

			response = RankingLlamadasDAO.listarReporteRankingLlamadas("192.168.3.202", objRanking);
			System.out.println(response.getListRanking().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void listarRankingLlamadasTest() {
		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

			RankingLlamadasResponse response = new RankingLlamadasResponse();
			RankingLlamadasRequest objRanking = new RankingLlamadasRequest();

			// Date feIni = format.parse("2013-01-01");
			// Date feFin = format.parse("2016-02-21");
			objRanking.setFeIni("2017-01-01");
			objRanking.setFeFin("2017-06-27");
			objRanking.setHoraIni("0:00");
			objRanking.setHorafin("23:45");
			objRanking.setNumPagina(1);
			objRanking.setCantidadxPag(20);
			objRanking.setpIdOrden(2);

			response = RankingLlamadasDAO.listarRankingLlamadas("192.168.3.254", objRanking);
			System.out.println(response.getListRanking().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
