package pe.com.tintegro.dto.request;

import java.util.List;

public class RolRequest {
	  
	  private String noRol;
	  private String noDescri;
	  private Boolean ilActivo;
	  private Integer idTipoRol;
	  private Integer idInstancia;	  
	  private List<AsignarPaginaRolRequest> listPaginaRol;
	  private String idsPaginas; 
	
	public String getIdsPaginas() {
		return idsPaginas;
	}
	public void setIdsPaginas(String idsPaginas) {
		this.idsPaginas = idsPaginas;
	}
	public List<AsignarPaginaRolRequest> getListPaginaRol() {
		return listPaginaRol;
	}
	public void setListPaginaRol(List<AsignarPaginaRolRequest> listPaginaRol) {
		this.listPaginaRol = listPaginaRol;
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
	
}
