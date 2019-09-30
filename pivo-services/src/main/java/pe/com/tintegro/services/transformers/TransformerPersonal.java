package pe.com.tintegro.services.transformers;

import java.util.ArrayList;
import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.services.util.Transformer;

public class TransformerPersonal extends Transformer<List<Personal>, Graficos> {

	@Override
	public Graficos transformerTo(List<Personal> lsPersonal) {
		// TODO Auto-generated method stub
		Graficos grafico = new Graficos();
		List<String> labelList = new ArrayList<String>();
		List<Number> dataList = new ArrayList<Number>();
			// LABEL LIST NOMBRE AREAS
			labelList.add("Personal Profesional ");
			labelList.add("Personal No Profesional ");
			// DATA LIST CANTIDAD LLAMADAS
			dataList.add(lsPersonal.get(0).getCaProfesional());
			dataList.add(lsPersonal.get(0).getCaNoProfesional());
		grafico.setLabelList(labelList);
		grafico.setDataUnicaNumber(dataList);
		return grafico;
	}

	@Override
	public void getTipo(int request) {
		// TODO Auto-generated method stub
		
	}



}
