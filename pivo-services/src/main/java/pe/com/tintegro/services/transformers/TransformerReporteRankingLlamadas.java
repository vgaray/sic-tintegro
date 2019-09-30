package pe.com.tintegro.services.transformers;

import java.util.ArrayList;
import java.util.List;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.RankingLlamadas;
import pe.com.tintegro.services.util.Transformer;

public class TransformerReporteRankingLlamadas extends Transformer<List<RankingLlamadas>, Graficos> {
	int tipo;

	@Override
	public void getTipo(int request) {
		tipo = request;
	}

	@Override
	public Graficos transformerTo(List<RankingLlamadas> lsRanking) {
		Graficos grafico = new Graficos();
		List<String> labelList = new ArrayList<String>();
		List<String> serieList = new ArrayList<String>();
		List<List<Number>> data = new ArrayList<List<Number>>();
		List<Number> lsTotal = new ArrayList<Number>();
		String serial = "";
		// //////////////////////////
		if (tipo == 1) {
			for (RankingLlamadas reporte : lsRanking) {
				// LABEL LIST FECHAS
				labelList.add(reporte.getNoUsuario());
				// DATA LIST CANTIDAD LLAMADAS X TIPO
				lsTotal.add(reporte.getCaLlamad());
			}
			serial = "Cantidad de LLamadas";
		}
		if (tipo == 2) {
			for (RankingLlamadas reporte : lsRanking) {
				// LABEL LIST FECHAS
				labelList.add(reporte.getNoUsuario());
				// DATA LIST CANTIDAD LLAMADAS X TIPO
				lsTotal.add(reporte.getNuTotalMin());
			}
			serial = "Total Tiempo Hablado (Min)";
		}
		data.add(lsTotal);
		serieList.add(serial);
		grafico.setLabelList(labelList);
		grafico.setSerieList(serieList);
		grafico.setDataNumber(data);
		return grafico;
	}

}