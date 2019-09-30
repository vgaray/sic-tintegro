package pe.com.tintegro.dto.request;

public class ListarPersonalRequest extends RequestBase {

	private String pIdPersonal;
	private String pNuDocumento;
	private String pNoNombreApellido;
	private Integer pIdTipoDocumento;
	private Boolean pIlActivo;
	private Integer pTiFun;
	private Integer tipoFile;
	
	public String getpIdPersonal() {
		return pIdPersonal;
	}
	public void setpIdPersonal(String pIdPersonal) {
		this.pIdPersonal = pIdPersonal;
	}
	public String getpNuDocumento() {
		return pNuDocumento;
	}
	public void setpNuDocumento(String pNuDocumento) {
		this.pNuDocumento = pNuDocumento;
	}
	public String getpNoNombreApellido() {
		return pNoNombreApellido;
	}
	public void setpNoNombreApellido(String pNoNombreApellido) {
		this.pNoNombreApellido = pNoNombreApellido;
	}
	public Integer getpIdTipoDocumento() {
		return pIdTipoDocumento;
	}
	public void setpIdTipoDocumento(Integer pIdTipoDocumento) {
		this.pIdTipoDocumento = pIdTipoDocumento;
	}
	public Boolean getpIlActivo() {
		return pIlActivo;
	}
	public void setpIlActivo(Boolean pIlActivo) {
		this.pIlActivo = pIlActivo;
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