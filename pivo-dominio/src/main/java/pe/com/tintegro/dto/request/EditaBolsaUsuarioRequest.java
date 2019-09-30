package pe.com.tintegro.dto.request;

public class EditaBolsaUsuarioRequest extends RequestBase
{
	private Integer idUsuari;
	private Integer idTipTel;
	private Integer idClave;
	private Integer caMinBol;
	private Integer caSegBol;
	private Integer caConSeg;
	private Integer caResSeg;
	private String feIniBol;
	private String feFinBol;
	private String feUltMod;
	private String feUltAsi;
	private Boolean ilActMes;
	private Boolean ilActivo;
	
	public Integer getIdUsuari()
	{
		return idUsuari;
	}
	public void setIdUsuari(Integer idUsuari)
	{
		this.idUsuari = idUsuari;
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
	public Integer getCaSegBol()
	{
		return caSegBol;
	}
	public void setCaSegBol(Integer caSegBol)
	{
		this.caSegBol = caSegBol;
	}
	public Integer getCaConSeg()
	{
		return caConSeg;
	}
	public void setCaConSeg(Integer caConSeg)
	{
		this.caConSeg = caConSeg;
	}
	public Integer getCaResSeg()
	{
		return caResSeg;
	}
	public void setCaResSeg(Integer caResSeg)
	{
		this.caResSeg = caResSeg;
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
	public String getFeUltMod()
	{
		return feUltMod;
	}
	public void setFeUltMod(String feUltMod)
	{
		this.feUltMod = feUltMod;
	}
	public String getFeUltAsi()
	{
		return feUltAsi;
	}
	public void setFeUltAsi(String feUltAsi)
	{
		this.feUltAsi = feUltAsi;
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
