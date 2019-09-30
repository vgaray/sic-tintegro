package pe.com.tintegro.dto.request;

public class EliminaBolsaUsuarioRequest extends RequestBase
{
	private Integer idUsuari;
	private Integer idTipTel;
	private Integer idClave;
	private String feIniBol;

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

	public String getFeIniBol()
	{
		return feIniBol;
	}

	public void setFeIniBol(String feIniBol)
	{
		this.feIniBol = feIniBol;
	}
}
