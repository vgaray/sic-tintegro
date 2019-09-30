package pe.com.tintegro.dto.request;


public class ListaCentroCostoLlamadaRequest extends RequestBase
{
	private Integer pIdCencos;
	private String pFeIni ;
	private String pFeFin ; 
	private String pHorai;
	private String pHoraf;
	private String area;
	private String centroCosto;
	 private int tipoFile;

//Parametros para listar
	
  	private Integer	numPagina; 
  	private Integer	cantidadxPag;
  	private Integer pIdOrden;
  	
  	
	public int getTipoFile()
	{
		return tipoFile;
	}
	public void setTipoFile(int tipoFile)
	{
		this.tipoFile = tipoFile;
	}
	public Integer getpIdCencos()
	{
		return pIdCencos;
	}
	public void setpIdCencos(Integer pIdCencos)
	{
		this.pIdCencos = pIdCencos;
	}
	public String getpFeIni()
	{
		return pFeIni;
	}
	public void setpFeIni(String pFeIni)
	{
		this.pFeIni = pFeIni;
	}
	public String getpFeFin()
	{
		return pFeFin;
	}
	public void setpFeFin(String pFeFin)
	{
		this.pFeFin = pFeFin;
	}
	public String getpHorai()
	{
		return pHorai;
	}
	public void setpHorai(String pHorai)
	{
		this.pHorai = pHorai;
	}
	public String getpHoraf()
	{
		return pHoraf;
	}
	public void setpHoraf(String pHoraf)
	{
		this.pHoraf = pHoraf;
	}
	public Integer getNumPagina()
	{
		return numPagina;
	}
	public void setNumPagina(Integer numPagina)
	{
		this.numPagina = numPagina;
	}
	public Integer getCantidadxPag()
	{
		return cantidadxPag;
	}
	public void setCantidadxPag(Integer cantidadxPag)
	{
		this.cantidadxPag = cantidadxPag;
	}
	public Integer getpIdOrden()
	{
		return pIdOrden;
	}
	public void setpIdOrden(Integer pIdOrden)
	{
		this.pIdOrden = pIdOrden;
	}
	public String getArea()
	{
		return area;
	}
	public void setArea(String area)
	{
		this.area = area;
	}
	public String getCentroCosto()
	{
		return centroCosto;
	}
	public void setCentroCosto(String centroCosto)
	{
		this.centroCosto = centroCosto;
	}
  	
  	
}
