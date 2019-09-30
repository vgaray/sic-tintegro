package pe.com.tintegro.dominio;

import java.io.Serializable;

public class InstanciaN implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ip_asterisk;
	private String no_mascara_red_lan;
	private String no_mascara_open_vpn;
	private Integer id_cliente;
	private boolean il_estado;
	private boolean il_seguridad;
	private boolean il_libre;
	private Integer puerto_ssh_asterisk;
	private String puerto_openvpn;
	private String sim_pais;
	private String sim_provincia;
	private String full_provincia;
	private String no_organi;
	private String no_email;
	private Integer id_estadoinst;
	private String no_instancia;
	private String no_password_ldap;
	private Integer inicial;
	private Integer id_detapedido;

	public boolean isIl_seguridad() {
		return il_seguridad;
	}

	public void setIl_seguridad(boolean il_seguridad) {
		this.il_seguridad = il_seguridad;
	}

	public Integer getId_detapedido() {
		return id_detapedido;
	}

	public void setId_detapedido(Integer id_detapedido) {
		this.id_detapedido = id_detapedido;
	}

	public Integer getInicial() {
		return inicial;
	}

	public void setInicial(Integer inicial) {
		this.inicial = inicial;
	}

	public Integer getPuerto_ssh_asterisk() {
		return puerto_ssh_asterisk;
	}

	public void setPuerto_ssh_asterisk(Integer puerto_ssh_asterisk) {
		this.puerto_ssh_asterisk = puerto_ssh_asterisk;
	}

	public String getIp_asterisk() {
		return ip_asterisk;
	}

	public void setIp_asterisk(String ip_asterisk) {
		this.ip_asterisk = ip_asterisk;
	}

	public String getNo_mascara_red_lan() {
		return no_mascara_red_lan;
	}

	public void setNo_mascara_red_lan(String no_mascara_red_lan) {
		this.no_mascara_red_lan = no_mascara_red_lan;
	}

	public String getNo_mascara_open_vpn() {
		return no_mascara_open_vpn;
	}

	public void setNo_mascara_open_vpn(String no_mascara_open_vpn) {
		this.no_mascara_open_vpn = no_mascara_open_vpn;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public boolean isIl_estado() {
		return il_estado;
	}

	public void setIl_estado(boolean il_estado) {
		this.il_estado = il_estado;
	}

	public boolean isIl_libre() {
		return il_libre;
	}

	public void setIl_libre(boolean il_libre) {
		this.il_libre = il_libre;
	}

	public String getPuerto_openvpn() {
		return puerto_openvpn;
	}

	public void setPuerto_openvpn(String puerto_openvpn) {
		this.puerto_openvpn = puerto_openvpn;
	}

	public String getSim_pais() {
		return sim_pais;
	}

	public void setSim_pais(String sim_pais) {
		this.sim_pais = sim_pais;
	}

	public String getSim_provincia() {
		return sim_provincia;
	}

	public void setSim_provincia(String sim_provincia) {
		this.sim_provincia = sim_provincia;
	}

	public String getFull_provincia() {
		return full_provincia;
	}

	public void setFull_provincia(String full_provincia) {
		this.full_provincia = full_provincia;
	}

	public String getNo_organi() {
		return no_organi;
	}

	public void setNo_organi(String no_organi) {
		this.no_organi = no_organi;
	}

	public String getNo_email() {
		return no_email;
	}

	public void setNo_email(String no_email) {
		this.no_email = no_email;
	}

	public Integer getId_estadoinst() {
		return id_estadoinst;
	}

	public void setId_estadoinst(Integer id_estadoinst) {
		this.id_estadoinst = id_estadoinst;
	}

	public String getNo_instancia() {
		return no_instancia;
	}

	public void setNo_instancia(String no_instancia) {
		this.no_instancia = no_instancia;
	}

	public String getNo_password_ldap() {
		return no_password_ldap;
	}

	public void setNo_password_ldap(String no_password_ldap) {
		this.no_password_ldap = no_password_ldap;
	}
}
