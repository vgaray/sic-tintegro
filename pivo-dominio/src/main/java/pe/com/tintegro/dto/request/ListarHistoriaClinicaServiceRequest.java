package pe.com.tintegro.dto.request;

public class ListarHistoriaClinicaServiceRequest extends RequestBase {

	private String pNuChip;
	private String pNoPass;
	private Integer pIdInstancia;

		

	public String getpNuChip() {
		return pNuChip;
	}

	public void setpNuChip(String pNuChip) {
		this.pNuChip = pNuChip;
	}

	public String getpNoPass() {
		return pNoPass;
	}

	public void setpNoPass(String pNoPass) {
		this.pNoPass = pNoPass;
	}

	public Integer getpIdInstancia() {
		return pIdInstancia;
	}

	public void setpIdInstancia(Integer pIdInstancia) {
		this.pIdInstancia = pIdInstancia;
	}

}
