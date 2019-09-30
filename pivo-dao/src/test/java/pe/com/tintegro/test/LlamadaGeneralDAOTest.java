package pe.com.tintegro.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dao.LlamadaGeneralDAO;
import pe.com.tintegro.dominio.LlamadaGeneral;
import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.response.ListaLlamadaGeneralResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class LlamadaGeneralDAOTest {
	@Autowired
	LlamadaGeneralDAO llamadaGeneralDAO;

	// @Test
	public void testLlamadaGeneralListReporte() {
		try {
			// SimpleDateFormat dateFormatter = new
			// SimpleDateFormat("yyyy-MM-dd");
			// Date fechaIni = dateFormatter.parse("2016-01-01");
			// Date fechaFin = dateFormatter.parse("2017-01-01");
			ListaLlamadaGeneralRequest request = new ListaLlamadaGeneralRequest();
			request.setpNoSrc("");
			request.setpNoDst("");
			request.setpNoDis("");
			request.setpFeIni("2016-01-01");
			request.setpFeFin("2017-09-01");
			request.setpHorai("00:00:00");
			request.setpHoraf("23:59:00");
			request.setpTipLlamada(0);
			request.setpRanInitie(null);
			request.setpRanFintie(null);
			request.setpIdOrden(1);
			ListaLlamadaGeneralResponse response = llamadaGeneralDAO.listaReportellamadaGeneral("192.168.3.202", request);
			System.out.println(response.getListaLlamadaGeneralList().size());
			for (LlamadaGeneral general : response.getListaLlamadaGeneralList()) {
				System.out.println(general.getDst() + "   " + general.getFeLlamado());
			}
		}
		/*
		 * ListarReporteAtencionClienteCallCenterRequest request = new
		 * ListarReporteAtencionClienteCallCenterRequest();
		 * request.setTiReport("123"); request.setVaTab(3); request.setVaNsv(4);
		 * request.setFeReport("123"); request.setNoQueue("123");
		 * System.out.println("LLEGO LINEA 33");
		 * ListarReporteAtencionClienteCallCenterResponse response =
		 * listareporteCallCenterDao.ListaReporteCallCenter("192.168.3.202",
		 * request); for (ReporteAtencionClienteCallCenter general :
		 * response.getLsreporte()) { System.out.println(general.getFeLlamad() +
		 * "." + general.getLlaEntra() + "." + general.getLlaAtendi()
		 * +general.getLlaAtetab
		 * ()+"."+general.getLlaAbando()+"."+general.getLlaAbatab
		 * ()+"."+general.getLlaDisuac()
		 * +general.getLlaAtens()+"."+general.getTiProcon
		 * ()+"."+general.getTiProesp
		 * ()+"."+general.getTiEma()+"."+general.getTiAbando()); }
		 */
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testlistallamadaGeneral() {
		try {
			// SimpleDateFormat dateFormatter = new
			// SimpleDateFormat("yyyy-MM-dd");
			// Date fechaIni = dateFormatter.parse("2016-01-01");
			// Date fechaFin = dateFormatter.parse("2017-01-01");
			ListaLlamadaGeneralRequest request = new ListaLlamadaGeneralRequest();
			request.setpNoSrc("");
			request.setpNoDst("");
			request.setpNoDis("");
			request.setpFeIni("2016-01-01");
			request.setpFeFin("2017-12-29");
			request.setpHorai("00:00:00");
			request.setpHoraf("23:59:59");
			request.setpTipLlamada(0);
			request.setpRanInitie(0);
			request.setpRanFintie(0);
			request.setNumPagina(1);
			request.setCantidadxPag(50);
			ListaLlamadaGeneralResponse response = llamadaGeneralDAO.listallamadaGeneral("192.168.3.202", request);
			System.out.println(response.getListaLlamadaGeneralList().size());
			for (LlamadaGeneral general : response.getListaLlamadaGeneralList()) {
				System.out.println("Indice: " + general.getIndice() + " Dato1: " + general.getDst() + " Dato2: " + general.getFeLlamado());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
