package pe.com.tintegro.dto.request;

public class TiempoBolsaDisponibleAreaRequest extends RequestBase
{
	private Integer idCentro;
	private Integer idTipTel;
	private Integer idClave;
	private String feIni;
	private String feFin;

	public Integer getIdCentro()
	{
		return idCentro;
	}

	public void setIdCentro(Integer idCentro)
	{
		this.idCentro = idCentro;
	}

	public Integer getIdTipTel()
	{
		return idTipTel;
	}

	public void setIdTipTel(Integer idTipTel)
	{
		this.idTipTel = idTipTel;
	}

	public Integer getIdClave()
	{
		return idClave;
	}

	public void setIdClave(Integer idClave)
	{
		this.idClave = idClave;
	}

	public String getFeIni()
	{
		return feIni;
	}

	public void setFeIni(String feIni)
	{
		this.feIni = feIni;
	}

	public String getFeFin()
	{
		return feFin;
	}

	public void setFeFin(String feFin)
	{
		this.feFin = feFin;
	}

}
