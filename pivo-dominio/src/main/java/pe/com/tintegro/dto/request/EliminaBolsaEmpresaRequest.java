package pe.com.tintegro.dto.request;

public class EliminaBolsaEmpresaRequest extends RequestBase
{
	private Integer idEmpare;
	private Integer idPadre;
	private Integer idTipTel;
	private Integer idClave;
	private String feIniBol;

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

	public String getFeIniBol()
	{
		return feIniBol;
	}

	public void setFeIniBol(String feIniBol)
	{
		this.feIniBol = feIniBol;
	}

}
