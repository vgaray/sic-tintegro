package pe.com.tintegro.services.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHora;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHoraGrafico;
import pe.com.tintegro.services.transformers.TransformerCallCenterReporteAgente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/pe/com/tintegro/config/applicationContext.xml" })
public class CallCenterReportesAgenteGraficoServicesTest {

	@Autowired
	TransformerCallCenterReporteAgente transformerCallCenterReporteAgenteServices ;
	
	@Test
	public void testListaLlamadasEntrantesPorHora() {
		try{
			List<LlamadasEntrantesPorHora> lsEntrantePorHora = new ArrayList<LlamadasEntrantesPorHora>();
			
			LlamadasEntrantesPorHora entrante1 = new LlamadasEntrantesPorHora();
			LlamadasEntrantesPorHora entrante2 = new LlamadasEntrantesPorHora();
			
			entrante1.setAbandono(2);
			entrante1.setAnio(2017);
			entrante1.setAtendido(3);
			entrante1.setEntrante(10);
			entrante1.setHora("12:00 - 13:00");
			entrante1.setIdQueueName(1);
			entrante1.setMes(2);
			entrante1.setNoQueueName("EMPRESA1");
			
			entrante2.setAbandono(5);
			entrante2.setAnio(2017);
			entrante2.setAtendido(12);
			entrante2.setEntrante(17);
			entrante2.setHora("12:00 - 13:00");
			entrante2.setIdQueueName(1);
			entrante2.setMes(2);
			entrante2.setNoQueueName("EMPRESA1");
			
			lsEntrantePorHora.add(entrante1);
			lsEntrantePorHora.add(entrante2);
			
			TransformerCallCenterReporteAgente tran = new TransformerCallCenterReporteAgente();
			LlamadasEntrantesPorHoraGrafico grafico = tran.transformerTo(lsEntrantePorHora);
			
			System.out.println("Label "+grafico.getLsLabel());
			System.out.println("Serial "+grafico.getLsSerial());
			System.out.println("Data "+grafico.getData());
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}