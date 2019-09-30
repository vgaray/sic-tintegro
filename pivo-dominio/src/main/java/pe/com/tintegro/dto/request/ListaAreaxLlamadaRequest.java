package pe.com.tintegro.dto.request;


public class ListaAreaxLlamadaRequest extends RequestBase
{
	private int pidarea;
	private String pFeIni;
	private String pFeFin;
	private String pHorai;
	private String pHoraf;
	private String nombreArea;
	
//Parametros para listar
	
  	private Integer	numPagina; 
  	private Integer	cantidadxPag;
  	private Integer pIdOrden; 	  	
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

	private int tipoFile;

	public int getPidarea()
	{
		return pidarea;
	}

	public void setPidarea(int pidarea)
	{
		this.pidarea = pidarea;
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

	public int getTipoFile()
	{
		return tipoFile;
	}

	public void setTipoFile(int tipoFile)
	{
		this.tipoFile = tipoFile;
	}

	public Integer getpIdOrden()
	{
		return pIdOrden;
	}

	public void setpIdOrden(Integer pIdOrden)
	{
		this.pIdOrden = pIdOrden;
	}

	public String getNombreArea()
	{
		return nombreArea;
	}

	public void setNombreArea(String nombreArea)
	{
		this.nombreArea = nombreArea;
	}
	
	

}
