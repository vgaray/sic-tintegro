package pe.com.tintegro.services.transformers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHora;
import pe.com.tintegro.dominio.LlamadasEntrantesPorHoraGrafico;
import pe.com.tintegro.services.util.Transformer;

@Component
public class TransformerCallCenterReporteAgente extends Transformer<List<LlamadasEntrantesPorHora>, LlamadasEntrantesPorHoraGrafico> {
	
	@Override
	public void getTipo(int request) {

	}

	@Override
	public LlamadasEntrantesPorHoraGrafico transformerTo(List<LlamadasEntrantesPorHora> lsLlamadasEntrantesPorHora) {
		LlamadasEntrantesPorHoraGrafico grafico = new LlamadasEntrantesPorHoraGrafico();
		List<String> lsLabel = new ArrayList<String>();
		List<String> lsSerie = new ArrayList<String>();
		List<List<Integer>> data = new ArrayList<List<Integer>>();

		List<Integer> lsLlamadaAtendida = new ArrayList<Integer>();
		List<Integer> lsLlamadaAbandoanda = new ArrayList<Integer>();
		List<Integer> lsLlamadaEntrante = new ArrayList<Integer>();

		String hora = null;
		for (LlamadasEntrantesPorHora reporte : lsLlamadasEntrantesPorHora) {
			if (!reporte.getHora().equals(hora)) {
				// Genera el label para el gráfico
				lsLabel.add(reporte.getHora());
				// Genera el arreglo para la data que se usará en el gráfico
				lsLlamadaAtendida.add((reporte.getAbandono()));
				lsLlamadaAbandoanda.add((reporte.getAtendido()));
				lsLlamadaEntrante.add((reporte.getEntrante()));
			}
			hora = reporte.getHora();
		}
		lsSerie.add("ATENDIDO");
		lsSerie.add("ABANDONADO");
		lsSerie.add("ENTRANTE");

		data.add(lsLlamadaAbandoanda);
		data.add(lsLlamadaAtendida);
		data.add(lsLlamadaEntrante);

		grafico.setData(data);
		grafico.setLsLabel(lsLabel);
		grafico.setLsSerial(lsSerie);
		return grafico;
	}
}
