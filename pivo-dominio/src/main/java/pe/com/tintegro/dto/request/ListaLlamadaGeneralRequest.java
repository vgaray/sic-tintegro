package pe.com.tintegro.dto.request;

public class ListaLlamadaGeneralRequest extends RequestBase
{
	private String pNoSrc;
	private String pNoDst;
	private String pNoDis;
	private String pFeIni;
	private String pFeFin;
	private String pHorai;
	private String pHoraf;
	private Integer pTipLlamada;
	private Integer pRanInitie;
	private Integer pRanFintie;
	private int tipoFile;

	
	//Parametros para listar
	
  	private Integer	numPagina; 
  	private Integer	cantidadxPag;
  	private Integer pIdOrden;
	
	public String getpNoDis()
	{
		return pNoDis;
	}

	public void setpNoDis(String pNoDis)
	{
		this.pNoDis = pNoDis;
	}

	public String getpNoSrc()
	{
		return pNoSrc;
	}

	public void setpNoSrc(String pNoSrc)
	{
		this.pNoSrc = pNoSrc;
	}

	public String getpNoDst()
	{
		return pNoDst;
	}

	public void setpNoDst(String pNoDst)
	{
		this.pNoDst = pNoDst;
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

	public Integer getpTipLlamada()
	{
		return pTipLlamada;
	}

	public void setpTipLlamada(Integer pTipLlamada)
	{
		this.pTipLlamada = pTipLlamada;
	}

	public Integer getpRanInitie()
	{
		return pRanInitie;
	}

	public void setpRanInitie(Integer pRanInitie)
	{
		this.pRanInitie = pRanInitie;
	}

	public Integer getpRanFintie()
	{
		return pRanFintie;
	}

	public void setpRanFintie(Integer pRanFintie)
	{
		this.pRanFintie = pRanFintie;
	}

	public int getTipoFile() {
		return tipoFile;
	}

	public void setTipoFile(int tipoFile) {
		this.tipoFile = tipoFile;
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
			
}
