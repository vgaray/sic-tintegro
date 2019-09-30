package pe.com.tintegro.dto.request;

public class ListarLlamadaDestinoRequest extends RequestBase
{
	private Integer pIdArea;
	private Integer pIdCentcos; 
	private String pFeIni;
	private String pHoIni;
	private String pFeFin; 
	private String pHoFin;
	private String nomArea;
	private String nomCentro;
	private int tipoFile;
  	private Integer pIdOrden;
	
	public int getTipoFile()
	{
		return tipoFile;
	}
	public void setTipoFile(int tipoFile)
	{
		this.tipoFile = tipoFile;
	}
	public Integer getpIdArea()
	{
		return pIdArea;
	}
	public void setpIdArea(Integer pIdArea)
	{
		this.pIdArea = pIdArea;
	}
	public Integer getpIdCentcos()
	{
		return pIdCentcos;
	}
	public void setpIdCentcos(Integer pIdCentcos)
	{
		this.pIdCentcos = pIdCentcos;
	}
	public String getpFeIni()
	{
		return pFeIni;
	}
	public void setpFeIni(String pFeIni)
	{
		this.pFeIni = pFeIni;
	}
	public String getpHoIni()
	{
		return pHoIni;
	}
	public void setpHoIni(String pHoIni)
	{
		this.pHoIni = pHoIni;
	}
	public String getpFeFin()
	{
		return pFeFin;
	}
	public void setpFeFin(String pFeFin)
	{
		this.pFeFin = pFeFin;
	}
	public String getpHoFin()
	{
		return pHoFin;
	}
	public void setpHoFin(String pHoFin)
	{
		this.pHoFin = pHoFin;
	}
	public Integer getpIdOrden()
	{
		return pIdOrden;
	}
	public void setpIdOrden(Integer pIdOrden)
	{
		this.pIdOrden = pIdOrden;
	}
	public String getNomArea()
	{
		return nomArea;
	}
	public void setNomArea(String nomArea)
	{
		this.nomArea = nomArea;
	}
	public String getNomCentro()
	{
		return nomCentro;
	}
	public void setNomCentro(String nomCentro)
	{
		this.nomCentro = nomCentro;
	}
	
}
