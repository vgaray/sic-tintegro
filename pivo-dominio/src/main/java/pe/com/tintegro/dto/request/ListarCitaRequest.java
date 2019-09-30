package pe.com.tintegro.dto.request;

public class ListarCitaRequest {

	private String pNuDocumento;
	private Integer pIdTipoDocumento;
	private Integer pIdEstado;
	private Integer pTiFun;

	public Integer getpIdTipoDocumento() {
		return pIdTipoDocumento;
	}

	public void setpIdTipoDocumento(Integer pIdTipoDocumento) {
		this.pIdTipoDocumento = pIdTipoDocumento;
	}

	public String getpNuDocumento() {
		return pNuDocumento;
	}

	public void setpNuDocumento(String pNuDocumento) {
		this.pNuDocumento = pNuDocumento;
	}

	public Integer getpIdEstado() {
		return pIdEstado;
	}

	public void setpIdEstado(Integer pIdEstado) {
		this.pIdEstado = pIdEstado;
	}

	public Integer getpTiFun() {
		return pTiFun;
	}

	public void setpTiFun(Integer pTiFun) {
		this.pTiFun = pTiFun;
	}
}
