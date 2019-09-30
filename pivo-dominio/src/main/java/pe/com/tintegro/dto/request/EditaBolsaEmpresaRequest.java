package pe.com.tintegro.dto.request;

public class EditaBolsaEmpresaRequest extends RequestBase
{
	private Integer idEmpare;
	private Integer idPadre;
	private Integer idTipTel;
	private Integer idClave;
	private Integer caMinBol;
	// private Integer caConMin;
	// private Integer caResMin;
	private String feIniBol;
	private String feFinBol;
	private String feIniBolActualiza;
	// private String feUltMod;
	private Boolean ilActMes;
	private Boolean ilActivo;

	public Integer getIdEmpare()
	{
		return idEmpare;
	}

	public void setIdEmpare(Integer idEmpare)
	{
		this.idEmpare = idEmpare;
	}

	public Integer getIdPadre()
	{
		return idPadre;
	}

	public void setIdPadre(Integer idPadre)
	{
		this.idPadre = idPadre;
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

	public Integer getCaMinBol()
	{
		return caMinBol;
	}

	public void setCaMinBol(Integer caMinBol)
	{
		this.caMinBol = caMinBol;
	}

	public String getFeIniBol()
	{
		return feIniBol;
	}

	public void setFeIniBol(String feIniBol)
	{
		this.feIniBol = feIniBol;
	}

	public String getFeFinBol()
	{
		return feFinBol;
	}

	public void setFeFinBol(String feFinBol)
	{
		this.feFinBol = feFinBol;
	}

	public String getFeIniBolActualiza()
	{
		return feIniBolActualiza;
	}

	public void setFeIniBolActualiza(String feIniBolActualiza)
	{
		this.feIniBolActualiza = feIniBolActualiza;
	}

 

	public Boolean getIlActMes()
	{
		return ilActMes;
	}

	public void setIlActMes(Boolean ilActMes)
	{
		this.ilActMes = ilActMes;
	}

	public Boolean getIlActivo()
	{
		return ilActivo;
	}

	public void setIlActivo(Boolean ilActivo)
	{
		this.ilActivo = ilActivo;
	}

}
