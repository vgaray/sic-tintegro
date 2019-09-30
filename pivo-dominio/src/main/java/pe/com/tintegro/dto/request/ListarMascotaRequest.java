package pe.com.tintegro.dto.request;


public class ListarMascotaRequest extends RequestBase{
	
	private Integer pIdMascota;
	private String pCodUsuario;
	private String pNuChip;
	private Integer pTiFun;
	private Integer tipoFile;
	public Integer getpIdMascota() {
		return pIdMascota;
	}
	public void setpIdMascota(Integer pIdMascota) {
		this.pIdMascota = pIdMascota;
	}
	public String getpCodUsuario() {
		return pCodUsuario;
	}
	public void setpCodUsuario(String pCodUsuario) {
		this.pCodUsuario = pCodUsuario;
	}
	public String getpNuChip() {
		return pNuChip;
	}
	public void setpNuChip(String pNuChip) {
		this.pNuChip = pNuChip;
	}
	public Integer getpTiFun() {
		return pTiFun;
	}
	public void setpTiFun(Integer pTiFun) {
		this.pTiFun = pTiFun;
	}
	public Integer getTipoFile() {
		return tipoFile;
	}
	public void setTipoFile(Integer tipoFile) {
		this.tipoFile = tipoFile;
	}
	
}
