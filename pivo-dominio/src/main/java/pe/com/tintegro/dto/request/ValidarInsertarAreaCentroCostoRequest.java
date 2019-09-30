package pe.com.tintegro.dto.request;

public class ValidarInsertarAreaCentroCostoRequest extends RequestBase{
	private String noArea;
	private String noCentroCosto;
	
	public String getNoArea() {
		return noArea;
	}
	public void setNoArea(String noArea) {
		this.noArea = noArea;
	}
	public String getNoCentroCosto() {
		return noCentroCosto;
	}
	public void setNoCentroCosto(String noCentroCosto) {
		this.noCentroCosto = noCentroCosto;
	}
}
