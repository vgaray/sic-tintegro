package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Graficos implements Serializable {

	private static final long serialVersionUID = 1L;

	// ///////////////////////Graficos
	// Cliente(Barras)////////////////////////////////////////////////////
	List<String> labelList;// la lista de los labels(las etiquetas de las barras
							// individuales).
	List<String> serieList; // la lista de series(las etiquetas de cada grupo de
							// barras).
	// Array o Arrray de Datos dependiendo del tipo y modo de dato.
	List<List<Integer>> data; // cuando el array de datos es entero
	List<List<BigDecimal>> dataDecimal; // cuando el array de datos es decimal
	List<Integer> dataunica; // especial para grafico de pie
	List<BigDecimal> dataUnicaDecimal;
	List<Number> dataUnicaNumber;
	public List<Number> getDataUnicaNumber() {
		return dataUnicaNumber;
	}

	public void setDataUnicaNumber(List<Number> dataUnicaNumber) {
		this.dataUnicaNumber = dataUnicaNumber;
	}

	List<List<Number>> dataNumber;
	
	public List<List<Number>> getDataNumber() {
		return dataNumber;
	}

	public void setDataNumber(List<List<Number>> dataNumber) {
		this.dataNumber = dataNumber;
	}

	public List<BigDecimal> getDataUnicaDecimal() {
		return dataUnicaDecimal;
	}

	public void setDataUnicaDecimal(List<BigDecimal> dataUnicaDecimal) {
		this.dataUnicaDecimal = dataUnicaDecimal;
	}

	public List<Integer> getDataunica() {
		return dataunica;
	}

	public void setDataunica(List<Integer> dataunica) {
		this.dataunica = dataunica;
	}

	//
	public List<List<BigDecimal>> getDataDecimal() {
		return dataDecimal;
	}

	public void setDataDecimal(List<List<BigDecimal>> dataDecimal) {
		this.dataDecimal = dataDecimal;
	}

	public List<String> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}

	public List<String> getSerieList() {
		return serieList;
	}

	public void setSerieList(List<String> serieList) {
		this.serieList = serieList;
	}

	public List<List<Integer>> getData() {
		return data;
	}

	public void setData(List<List<Integer>> data) {
		this.data = data;
	}

	List<String> serieListporc;
	
	public List<String> getSerieListporc() {
		return serieListporc;
	}

	public void setSerieListporc(List<String> serieListporc) {
		this.serieListporc = serieListporc;
	}

	
	
}
