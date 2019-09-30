package pe.com.tintegro.dominio;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class InstanciaServerAsterisk implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer idInstancia;
	private String ipAsterisk;
	private String nomMascaraRedLan;
	private String nomMascaraOpenVpn;
	private Integer idCliente;
	private Boolean ilEstado;
	private Boolean ilLibre;
	private String ipAsteriskBash;
	private Integer puerto_ssh_asterisk;
	private String puertoOpenVPN;
	private String pamConfInicial;
	private String simPais;
	private String simProvincia;
	private String fullProvincia;
	private String noOrgani;
	private String email;
	private Integer idModelo;
	private Integer idMarca;
	private String noModelo;
	private String noMarca;
	private Integer inicial;
	private String idInstanciaEncryp;
	private Integer idEstadoInstancia;
	private String noEstadoInstancia;
	private String noRazonSocial;
	private String nuDocide;
	private String direccion;
	private String telefono;
	private String correo;
	private String personaReferencia;
	private String noPlan;
	private String idMostrar;
	private String fePedido;
	private String noInstancia;
	private List<Usuario> usuarioList;
	private Integer result;
	private String mensaje;
	private Integer tipoInstancia;
	private Boolean isTls;
	private String zonaHoraria;
	private Integer caAnexos;
	
	
	public Integer getCaAnexos() {
		return caAnexos;
	}

	public void setCaAnexos(Integer caAnexos) {
		this.caAnexos = caAnexos;
	}

	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public Boolean getIsTls() {
		return isTls;
	}

	public void setIsTls(Boolean isTls) {
		this.isTls = isTls;
	}

	private String noPasswordLdap;
	public Integer getTipoInstancia() {
		return tipoInstancia;
	}

	public void setTipoInstancia(Integer tipoInstancia) {
		this.tipoInstancia = tipoInstancia;
	}

	public Integer getIdInstancia()
	{
		return idInstancia;
	}

	public void setIdInstancia(Integer idInstancia)
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

	public Integer getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(Integer idCliente)
	{
		this.idCliente = idCliente;
	}

	public Boolean getIlEstado()
	{
		return ilEstado;
	}

	public void setIlEstado(Boolean ilEstado)
	{
		this.ilEstado = ilEstado;
	}

	public Boolean getIlLibre()
	{
		return ilLibre;
	}

	public void setIlLibre(Boolean ilLibre)
	{
		this.ilLibre = ilLibre;
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

	public String getNoModelo()
	{
		return noModelo;
	}

	public void setNoModelo(String noModelo)
	{
		this.noModelo = noModelo;
	}

	public String getNoMarca()
	{
		return noMarca;
	}

	public void setNoMarca(String noMarca)
	{
		this.noMarca = noMarca;
	}

	public Integer getInicial()
	{
		return inicial;
	}

	public void setInicial(Integer inicial)
	{
		this.inicial = inicial;
	}

	public String getIdInstanciaEncryp()
	{
		return idInstanciaEncryp;
	}

	public void setIdInstanciaEncryp(String idInstanciaEncryp)
	{
		this.idInstanciaEncryp = idInstanciaEncryp;
	}

	public Integer getIdEstadoInstancia()
	{
		return idEstadoInstancia;
	}

	public void setIdEstadoInstancia(Integer idEstadoInstancia)
	{
		this.idEstadoInstancia = idEstadoInstancia;
	}

	public String getNoEstadoInstancia()
	{
		return noEstadoInstancia;
	}

	public void setNoEstadoInstancia(String noEstadoInstancia)
	{
		this.noEstadoInstancia = noEstadoInstancia;
	}

	public String getNoRazonSocial()
	{
		return noRazonSocial;
	}

	public void setNoRazonSocial(String noRazonSocial)
	{
		this.noRazonSocial = noRazonSocial;
	}

	public String getNuDocide()
	{
		return nuDocide;
	}

	public void setNuDocide(String nuDocide)
	{
		this.nuDocide = nuDocide;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	public String getPersonaReferencia()
	{
		return personaReferencia;
	}

	public void setPersonaReferencia(String personaReferencia)
	{
		this.personaReferencia = personaReferencia;
	}

	public String getNoPlan()
	{
		return noPlan;
	}

	public void setNoPlan(String noPlan)
	{
		this.noPlan = noPlan;
	}

	public String getIdMostrar()
	{
		return idMostrar;
	}

	public void setIdMostrar(String idMostrar)
	{
		this.idMostrar = idMostrar;
	}

	public String getFePedido()
	{
		return fePedido;
	}

	public void setFePedido(String fePedido)
	{
		this.fePedido = fePedido;
	}

	public String getNoInstancia()
	{
		return noInstancia;
	}

	public void setNoInstancia(String noInstancia)
	{
		this.noInstancia = noInstancia;
	}

	public List<Usuario> getUsuarioList()
	{
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList)
	{
		this.usuarioList = usuarioList;
	}

	public Integer getResult()
	{
		return result;
	}

	public void setResult(Integer result)
	{
		this.result = result;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getNoPasswordLdap()
	{
		return noPasswordLdap;
	}

	public void setNoPasswordLdap(String noPasswordLdap)
	{
		this.noPasswordLdap = noPasswordLdap;
	}

	
}
