package pe.com.tintegro.services.transformers;

import java.util.ArrayList;
import java.util.List;

import pe.com.tintegro.dominio.Graficos;
import pe.com.tintegro.dominio.Mascota;
import pe.com.tintegro.services.util.Transformer;

public class TransformerMascota extends Transformer<List<Mascota>, Graficos> {

	@Override
	public Graficos transformerTo(List<Mascota> lsMascota) {
		// TODO Auto-generated method stub
		Graficos grafico = new Graficos();
		List<String> labelList = new ArrayList<String>();
		List<Number> dataList = new ArrayList<Number>();
			// LABEL LIST NOMBRE AREAS
			labelList.add("Especie Canina");
			labelList.add("Especie Felina");
			labelList.add("Especie Aracnido");
			labelList.add("Especie Anfibia");
			labelList.add("Reptiles");
			// DATA LIST CANTIDAD LLAMADAS
			dataList.add(lsMascota.get(0).getCaCani());
			dataList.add(lsMascota.get(0).getCaFeli());
			dataList.add(lsMascota.get(0).getCaArac());
			dataList.add(lsMascota.get(0).getCaAnfi());
			dataList.add(lsMascota.get(0).getCaRep());
		grafico.setLabelList(labelList);
		grafico.setDataUnicaNumber(dataList);
		return grafico;
	}

	@Override
	public void getTipo(int request) {
		// TODO Auto-generated method stub
		
	}



}
