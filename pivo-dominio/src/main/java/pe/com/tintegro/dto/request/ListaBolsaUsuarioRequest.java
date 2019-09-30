package pe.com.tintegro.dto.request;

public class ListaBolsaUsuarioRequest extends RequestBase
{
	private Integer idUsuari;

	private Integer ilActivoFiltro;

	private Integer tipoFiltro;

	public Integer getIdUsuari()
	{
		return idUsuari;
	}

	public void setIdUsuari(Integer idUsuari)
	{
		this.idUsuari = idUsuari;
	}

	public Integer getIlActivoFiltro()
	{
		return ilActivoFiltro;
	}
	
	public void setIlActivoFiltro(Integer ilActivoFiltro)
	{
		this.ilActivoFiltro = ilActivoFiltro;
	}
	
	
	public Integer getTipoFiltro()
	{
		return tipoFiltro;
	}

	public void setTipoFiltro(Integer tipoFiltro)
	{
		this.tipoFiltro = tipoFiltro;
	}

}
