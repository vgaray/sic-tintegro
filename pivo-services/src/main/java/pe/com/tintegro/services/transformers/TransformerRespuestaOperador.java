package pe.com.tintegro.services.transformers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import pe.com.tintegro.dominio.ReporteAtencionClienteCallCenter;
import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.services.util.Transformer;

@Component("transformerRespuestaOperador")
public class TransformerRespuestaOperador extends Transformer<List<ReporteAtencionClienteCallCenter>, Graficos> {
	@Override
	public void getTipo(int request) {
	}

	@Override
	public Graficos transformerTo(List<ReporteAtencionClienteCallCenter> lsCallCenter) {

		Graficos grafico = new Graficos();
		List<String> labelList = new ArrayList<String>();
		List<String> serieList = new ArrayList<String>();
		List<List<Integer>> data = new ArrayList<List<Integer>>();

		List<Integer> lsTipoLlamadasA = new ArrayList<Integer>();
		List<Integer> lsTipoLlamadasAba = new ArrayList<Integer>();
		List<Integer> lsTipoLlamadasT = new ArrayList<Integer>();

		for (ReporteAtencionClienteCallCenter reporte : lsCallCenter) {
			// LABEL LIST FECHAS
			labelList.add(reporte.getFeLlamad());
			// DATA LIST CANTIDAD LLAMADAS X TIPO
			lsTipoLlamadasT.add(reporte.getLlaEntra());
			lsTipoLlamadasA.add((reporte.getLlaAtendi()));
			lsTipoLlamadasAba.add((reporte.getLlaAbando()));
		}
		data.add(lsTipoLlamadasT);
		data.add(lsTipoLlamadasA);
		data.add(lsTipoLlamadasAba);
		//
		//
		serieList.add("Total");
		serieList.add("Atendidas");
		serieList.add("Abandonadas");

		grafico.setLabelList(labelList);
		grafico.setSerieList(serieList);
		grafico.setData(data);
		// //////////////////////////////////////////////////////////////////////////////////////////////////////
		List<String> labelListporc = new ArrayList<String>();
		List<String> serieListporc = new ArrayList<String>();
		List<List<BigDecimal>> dataporc = new ArrayList<List<BigDecimal>>();

		List<BigDecimal> lsTipoLlamadasEfporc = new ArrayList<BigDecimal>();
		List<BigDecimal> lsTipoLlamadasAbaporc = new ArrayList<BigDecimal>();

		for (ReporteAtencionClienteCallCenter reporte : lsCallCenter) {
			// LABEL LIST FECHAS
			labelListporc.add(reporte.getFeLlamad());
			// DATA LIST CANTIDAD LLAMADAS X TIPO
			lsTipoLlamadasEfporc.add(reporte.getPorcentajeRoEficacia());
			lsTipoLlamadasAbaporc.add(reporte.getPorcentajeTotalAbandonos());
		}
		dataporc.add(lsTipoLlamadasEfporc);
		dataporc.add(lsTipoLlamadasAbaporc);
		//
		//
		serieListporc.add("%Eficacia");
		serieListporc.add("%Abandonos");
		/*
		 * grafico.setLabelListporc(labelListporc);
		 * grafico.setSerieListporc(serieListporc);
		 * grafico.setDataDecimal(dataporc);
		 */

		grafico.setLabelList(labelListporc);
		grafico.setSerieListporc(serieListporc);
		grafico.setDataDecimal(dataporc);

		return grafico;
	}

}
