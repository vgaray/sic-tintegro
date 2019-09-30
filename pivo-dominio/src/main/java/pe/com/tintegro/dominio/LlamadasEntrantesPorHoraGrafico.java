package pe.com.tintegro.dominio;

import java.util.List;

public class LlamadasEntrantesPorHoraGrafico {

	private List<String> lsLabel;
	private List<String> lsSerial;
	private List<List<Integer>> data;
	
	public List<String> getLsLabel() {
		return lsLabel;
	}
	public void setLsLabel(List<String> lsLabel) {
		this.lsLabel = lsLabel;
	}
	public List<String> getLsSerial() {
		return lsSerial;
	}
	public void setLsSerial(List<String> lsSerial) {
		this.lsSerial = lsSerial;
	}
	public List<List<Integer>> getData() {
		return data;
	}
	public void setData(List<List<Integer>> data) {
		this.data = data;
	}
}
