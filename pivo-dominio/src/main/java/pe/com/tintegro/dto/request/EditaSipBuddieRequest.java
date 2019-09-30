package pe.com.tintegro.dto.request;

public class EditaSipBuddieRequest extends RequestBase
{
	private int		sipAnexoId;
	private String	nomUsuario;
	private String	claveUsuario;
	private String	callerId;
	private String	buzonBox;
	private String	correoBox;
	private String	mac;
	private String	ipDominio;
	private String	ruta;
	private int		marcaId;
	private int		modeloId;
	private String	nomMarca;
	private String	nomModelo;

	public String getNomMarca()
	{
		return nomMarca;
	}

	public void setNomMarca(String nomMarca)
	{
		this.nomMarca = nomMarca;
	}

	public String getNomModelo()
	{
		return nomModelo;
	}

	public void setNomModelo(String nomModelo)
	{
		this.nomModelo = nomModelo;
	}

	public int getSipAnexoId()
	{
		return sipAnexoId;
	}

	public void setSipAnexoId(int sipAnexoId)
	{
		this.sipAnexoId = sipAnexoId;
	}

	public String getNomUsuario()
	{
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario)
	{
		this.nomUsuario = nomUsuario;
	}

	public String getClaveUsuario()
	{
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario)
	{
		this.claveUsuario = claveUsuario;
	}

	public String getCallerId()
	{
		return callerId;
	}

	public void setCallerId(String callerId)
	{
		this.callerId = callerId;
	}

	public String getBuzonBox()
	{
		return buzonBox;
	}

	public void setBuzonBox(String buzonBox)
	{
		this.buzonBox = buzonBox;
	}

	public String getCorreoBox()
	{
		return correoBox;
	}

	public void setCorreoBox(String correoBox)
	{
		this.correoBox = correoBox;
	}

	public String getMac()
	{
		return mac;
	}

	public void setMac(String mac)
	{
		this.mac = mac;
	}

	public String getIpDominio()
	{
		return ipDominio;
	}

	public void setIpDominio(String ipDominio)
	{
		this.ipDominio = ipDominio;
	}

	public String getRuta()
	{
		return ruta;
	}

	public void setRuta(String ruta)
	{
		this.ruta = ruta;
	}

	public int getMarcaId()
	{
		return marcaId;
	}

	public void setMarcaId(int marcaId)
	{
		this.marcaId = marcaId;
	}

	public int getModeloId()
	{
		return modeloId;
	}

	public void setModeloId(int modeloId)
	{
		this.modeloId = modeloId;
	}
}
