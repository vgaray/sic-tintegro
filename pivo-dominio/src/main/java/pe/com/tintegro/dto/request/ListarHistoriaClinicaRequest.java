package pe.com.tintegro.dto.request;

public class ListarHistoriaClinicaRequest extends RequestBase{
	
	private Integer pIdMascota;
	private String pNoPass;
	private Integer pTiFun;

	

	public String getpNoPass() {
		return pNoPass;
	}

	public void setpNoPass(String pNoPass) {
		this.pNoPass = pNoPass;
	}

	public Integer getpTiFun() {
		return pTiFun;
	}

	public void setpTiFun(Integer pTiFun) {
		this.pTiFun = pTiFun;
	}

	public Integer getpIdMascota() {
		return pIdMascota;
	}

	public void setpIdMascota(Integer pIdMascota) {
		this.pIdMascota = pIdMascota;
	}
	
	

}
