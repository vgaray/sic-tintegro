package pe.com.tintegro.dto.request;

import java.util.List;

public class ActualizarRolRequest {
	private Integer idRol;
	private String noRol;
	private String noDescri;
	private Boolean ilActivo;
	private Integer idTipoRol;
	private Integer idInstancia;
	private List<AsignarPaginaRolRequest> listPaginaRol;
		
	public Integer getIdRol() {
		return idRol;	
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNoRol() {
		return noRol;
	}
	public void setNoRol(String noRol) {
		this.noRol = noRol;
	}
	public String getNoDescri() {
		return noDescri;
	}
	public void setNoDescri(String noDescri) {
		this.noDescri = noDescri;
	}
	public Boolean getIlActivo() {
		return ilActivo;
	}
	public void setIlActivo(Boolean ilActivo) {
		this.ilActivo = ilActivo;
	}
	public Integer getIdTipoRol() {
		return idTipoRol;
	}
	public void setIdTipoRol(Integer idTipoRol) {
		this.idTipoRol = idTipoRol;
	}
	public Integer getIdInstancia() {
		return idInstancia;
	}
	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}
	public List<AsignarPaginaRolRequest> getListPaginaRol() {
		return listPaginaRol;
	}
	public void setListPaginaRol(List<AsignarPaginaRolRequest> listPaginaRol) {
		this.listPaginaRol = listPaginaRol;
	}
 
}
