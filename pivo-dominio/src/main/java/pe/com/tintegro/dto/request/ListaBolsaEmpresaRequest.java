package pe.com.tintegro.dto.request;

public class ListaBolsaEmpresaRequest extends RequestBase
{
	private Integer idEmpare;
	private String noFiltro;
	private Integer tipoFiltro;
	private Boolean ilActivo;

	public Integer getIdEmpare()
	{
		return idEmpare;
	}

	public void setIdEmpare(Integer idEmpare)
	{
		this.idEmpare = idEmpare;
	}

	public String getNoFiltro() {
		return noFiltro;
	}

	public void setNoFiltro(String noFiltro) {
		this.noFiltro = noFiltro;
	}

	public Integer getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(Integer tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public Boolean getIlActivo() {
		return ilActivo;
	}

	public void setIlActivo(Boolean ilActivo) {
		this.ilActivo = ilActivo;
	}

}
