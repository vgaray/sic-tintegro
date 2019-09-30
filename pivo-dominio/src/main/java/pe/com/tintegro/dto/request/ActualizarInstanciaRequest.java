package pe.com.tintegro.dto.request;

public class ActualizarInstanciaRequest extends RequestBase
{
	private Integer idInstanciaDesc;

	private String idInstancia;
	private String ipAsterisk;//listo
	private String nomMascaraRedLan;//listo
	private String nomMascaraOpenVpn;//listo
	// private Integer idCliente;
	private Boolean ilEstado;//listo
	// private Boolean ilLibre;
	private String ipAsteriskBash;
	private Integer puerto_ssh_asterisk;//listo
	private String puertoOpenVPN;//listo
	private String pamConfInicial;
	private String simPais;//listo
	private String simProvincia;//listo
	private String fullProvincia;//listo
	private String noOrgani;//listo
	private String email;//listo
	private Integer idModelo;
	private Integer idMarca;
	// private Integer inicial;
	// private Integer idEstadoInstancia;
	private String nomInstancia;//listo

	public Boolean getIlEstado() {
		return ilEstado;
	}

	public void setIlEstado(Boolean ilEstado) {
		this.ilEstado = ilEstado;
	}
	public Integer getIdInstanciaDesc()
	{
		return idInstanciaDesc;
	}

	public void setIdInstanciaDesc(Integer idInstanciaDesc)
	{
		this.idInstanciaDesc = idInstanciaDesc;
	}

	public String getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(String idInstancia)
	{
		this.idInstancia = idInstancia;
	}

	public String getIpAsterisk()
	{
		return ipAsterisk;
	}

	public void setIpAsterisk(String ipAsterisk)
	{
		this.ipAsterisk = ipAsterisk;
	}

	public String getNomMascaraRedLan()
	{
		return nomMascaraRedLan;
	}

	public void setNomMascaraRedLan(String nomMascaraRedLan)
	{
		this.nomMascaraRedLan = nomMascaraRedLan;
	}

	public String getNomMascaraOpenVpn()
	{
		return nomMascaraOpenVpn;
	}

	public void setNomMascaraOpenVpn(String nomMascaraOpenVpn)
	{
		this.nomMascaraOpenVpn = nomMascaraOpenVpn;
	}

	public String getIpAsteriskBash()
	{
		return ipAsteriskBash;
	}

	public void setIpAsteriskBash(String ipAsteriskBash)
	{
		this.ipAsteriskBash = ipAsteriskBash;
	}

	public Integer getPuerto_ssh_asterisk()
	{
		return puerto_ssh_asterisk;
	}

	public void setPuerto_ssh_asterisk(Integer puerto_ssh_asterisk)
	{
		this.puerto_ssh_asterisk = puerto_ssh_asterisk;
	}

	public String getPuertoOpenVPN()
	{
		return puertoOpenVPN;
	}

	public void setPuertoOpenVPN(String puertoOpenVPN)
	{
		this.puertoOpenVPN = puertoOpenVPN;
	}

	public String getPamConfInicial()
	{
		return pamConfInicial;
	}

	public void setPamConfInicial(String pamConfInicial)
	{
		this.pamConfInicial = pamConfInicial;
	}

	public String getSimPais()
	{
		return simPais;
	}

	public void setSimPais(String simPais)
	{
		this.simPais = simPais;
	}

	public String getSimProvincia()
	{
		return simProvincia;
	}

	public void setSimProvincia(String simProvincia)
	{
		this.simProvincia = simProvincia;
	}

	public String getFullProvincia()
	{
		return fullProvincia;
	}

	public void setFullProvincia(String fullProvincia)
	{
		this.fullProvincia = fullProvincia;
	}

	public String getNoOrgani()
	{
		return noOrgani;
	}

	public void setNoOrgani(String noOrgani)
	{
		this.noOrgani = noOrgani;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Integer getIdModelo()
	{
		return idModelo;
	}

	public void setIdModelo(Integer idModelo)
	{
		this.idModelo = idModelo;
	}

	public Integer getIdMarca()
	{
		return idMarca;
	}

	public void setIdMarca(Integer idMarca)
	{
		this.idMarca = idMarca;
	}

	public String getNomInstancia()
	{
		return nomInstancia;
	}

	public void setNomInstancia(String nomInstancia)
	{
		this.nomInstancia = nomInstancia;
	}

}
