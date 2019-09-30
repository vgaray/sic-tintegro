package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.LlamadaGeneral;
import pe.com.tintegro.dominio.RankingLlamadas;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.ReporteLlamadaDiaHoraCallCenter;
import pe.com.tintegro.dto.response.ListarReporteAtencionClienteCallCenterResponse;
import pe.com.tintegro.services.transformers.TransformerReporteRankingLlamadas;
import pe.com.tintegro.services.transformers.TransformerRespuestaOperador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class GraficoTransformerCallCenterTest {

	//@Test
	public void TestTransformerCallCenter() {
		try {
			// //////////////////////////////////////////////////////////////////////////////////////////////
			List<ReporteAtencionClienteCallCenter> lsCallCenter = new ArrayList<ReporteAtencionClienteCallCenter>();
			ReporteAtencionClienteCallCenter repCall1 = new ReporteAtencionClienteCallCenter();
			ReporteAtencionClienteCallCenter repCall2 = new ReporteAtencionClienteCallCenter();
			ReporteAtencionClienteCallCenter repCall3 = new ReporteAtencionClienteCallCenter();

			// ///////////////////////////
			repCall1.setFeLlamad("2016");
			repCall1.setLlaEntra(9);
			repCall1.setLlaAtendi(5);
			repCall1.setLlaAtetab(0);
			repCall1.setLlaAbando(4);
			repCall1.setLlaAbatab(0);
			repCall1.setLlaDisuac(0);
			repCall1.setLlaAtens(0);
			repCall1.setTiProcon(0);
			repCall1.setTiProesp(100);
			repCall1.setTiEma(0);
			repCall1.setTiAbando(50);
			// ///////////////////////////
			repCall2.setFeLlamad("2017");
			repCall2.setLlaEntra(11);
			repCall2.setLlaAtendi(6);
			repCall2.setLlaAtetab(0);
			repCall2.setLlaAbando(5);
			repCall2.setLlaAbatab(0);
			repCall2.setLlaDisuac(0);
			repCall2.setLlaAtens(0);
			repCall2.setTiProcon(140);
			repCall2.setTiProesp(362);
			repCall2.setTiEma(545);
			repCall2.setTiAbando(900);
			// ////////////////////////////
			repCall3.setFeLlamad("2018");
			repCall3.setLlaEntra(7);
			repCall3.setLlaAtendi(3);
			repCall3.setLlaAtetab(0);
			repCall3.setLlaAbando(4);
			repCall3.setLlaAbatab(0);
			repCall3.setLlaDisuac(0);
			repCall3.setLlaAtens(0);
			repCall3.setTiProcon(0);
			repCall3.setTiProesp(100);
			repCall3.setTiEma(0);
			repCall3.setTiAbando(50);
			// /////////////////////////////
			lsCallCenter.add(repCall1);
			lsCallCenter.add(repCall2);
			lsCallCenter.add(repCall3);

			TransformerRespuestaOperador obj = new TransformerRespuestaOperador();

			Graficos graf = obj.transformerTo(lsCallCenter);

			System.out.println("Labels" + graf.getLabelList());
			System.out.println("Serial" + graf.getSerieList());
			System.out.println("Data" + graf.getData());

		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}


}
