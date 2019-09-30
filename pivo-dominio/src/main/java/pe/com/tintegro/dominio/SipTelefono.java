package pe.com.tintegro.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SipTelefono
{
	private int			telefonoSipId;
	private String		nomUsuario;
	private String		claveUsuario;
	private Integer	marcaId;
	private Integer	modeloId;
	private String		nomMarca;
	private String		nomModelo;
	private String		nomMac;
	private String		nomIpDominio;
	private String		nomRuta;
	private String		callerId;
	private String		mailbox;
	private String		email;

	public String getClaveUsuario()
	{
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario)
	{
		this.claveUsuario = claveUsuario;
	}

	public String getMailbox()
	{
		return mailbox;
	}

	public void setMailbox(String mailbox)
	{
		this.mailbox = mailbox;
	}

	public String getCallerId()
	{
		return callerId;
	}

	public void setCallerId(String callerId)
	{
		this.callerId = callerId;
	}

	public int getTelefonoSipId()
	{
		return telefonoSipId;
	}

	public void setTelefonoSipId(int telefonoSipId)
	{
		this.telefonoSipId = telefonoSipId;
	}

	public String getNomUsuario()
	{
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario)
	{
		this.nomUsuario = nomUsuario;
	}

	public Integer getMarcaId()
	{
		return marcaId;
	}

	public void setMarcaId(Integer marcaId)
	{
		this.marcaId = marcaId;
	}

	public Integer getModeloId()
	{
		return modeloId;
	}

	public void setModeloId(Integer modeloId)
	{
		this.modeloId = modeloId;
	}

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

	public String getNomMac()
	{
		return nomMac;
	}

	public void setNomMac(String nomMac)
	{
		this.nomMac = nomMac;
	}

	public String getNomIpDominio()
	{
		return nomIpDominio;
	}

	public void setNomIpDominio(String nomIpDominio)
	{
		this.nomIpDominio = nomIpDominio;
	}

	public String getNomRuta()
	{
		return nomRuta;
	}

	public void setNomRuta(String nomRuta)
	{
		this.nomRuta = nomRuta;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
