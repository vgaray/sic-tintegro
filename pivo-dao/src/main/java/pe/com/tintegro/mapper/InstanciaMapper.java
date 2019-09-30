/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface InstanciaMapper
{
	public List<CRUDResponse> insertarInstanciaN(
			@Param("p_ip_asterisk") String ip_asterisk,
			@Param("p_no_mascara_red_lan") String no_mascara_red_lan,
			@Param("p_no_mascara_open_vpn") String no_mascara_open_vpn,
			@Param("p_id_cliente")Integer id_cliente,
			@Param("p_il_estado")boolean il_estado,
			@Param("p_il_libre")boolean il_libre,
			@Param("p_puerto_ssh_asterisk")Integer puerto_ssh_asterisk,
			@Param("p_puerto_openvpn")String puerto_openvpn,
			@Param("p_sim_pais")String sim_pais,
			@Param("p_sim_provincia")String sim_provincia,
			@Param("p_full_provincia")String full_provincia,
			@Param("p_no_organi")String no_organi,
			@Param("p_no_email")String no_email,
			@Param("p_id_estadoinst")Integer id_estadoinst,
			@Param("p_no_instancia")String no_instancia,
			@Param("p_no_password_ldap")String no_password_ldap,
			@Param("p_inicial")Integer id_plan,
			@Param("p_id_detapedido")Integer id_detapedido,
			@Param("p_il_seguridad")boolean il_seguridad
			);
	
	public List<InstanciaServerAsterisk> listaInstancia();
	
	public List<Integer> insertaInstancia(@Param("ip_red") String ip_red, @Param("nro_vlan") Integer nro_vlan, @Param("ip_asterisk") String ip_asterisk, @Param("ip_median") String ip_median,
			@Param("no_mascara") String no_mascara, @Param("no_iprouter") String no_iprouter, @Param("no_dns_1") String no_dns_1, @Param("no_dns_2") String no_dns_2,
			@Param("no_subnet") String no_subnet, @Param("no_broadcast") String no_broadcast, @Param("puerto_asterisk_bash_certificado_ext") Integer puerto_asterisk_bash_certificado_ext,
			@Param("id_cliente") Integer id_cliente, @Param("ipasteriskbash") String ipasteriskbash);

	public List<InstanciaServerAsterisk> listaInstanciaxIdinstancia(@Param("p_id_instancia") Integer idInstancia);

	public List<ListarInstanciaxCasoRequest> listaInstanciaxValor(@Param("valor") int valor);

	public List<ListarInstanciaxCasoRequest> listaInstanciaxCaso(@Param("idCliente") Integer idCliente, @Param("estadoE") Integer estadoE, @Param("ocupadoE") Integer ocupadoE);

	public List<ListarInstanciaxIdClienteRequest> listaInstanciaxIdCliente(@Param("idCliente") int idCliente);

	public List<Integer> asignaInstancia(@Param("idCliente") int idCliente, @Param("id_instancia") int id_instancia, @Param("valor") int valor);

	public List<InstanciaServerAsterisk> listarInstancia(@Param("p_id_tipdoc") Integer idTipoDoc, 
																			@Param("p_nu_docide") String nuDocIde, 
																			@Param("p_id_cliente") Integer idCliente,
																			@Param("p_id_pedido") Integer idPedido, 
																			@Param("p_id_estadoinstancia") Integer idEstadoInstancia, 
																			@Param("p_id_plan") Integer idPlan, 
																			@Param("p_id_tipoestadopedido") Integer idTipoEstadoPedido,
																			@Param("p_id_instanciax") Integer idInstanciax, 
																			@Param("p_id_usuario") Integer idUsuario, 
																			@Param("p_no_login") String noLogin);    
	
	public List<InstanciaServerAsterisk> actualizarInstancia(
			 @Param("pIdinstancia") Integer pIdinstancia, 
			 @Param("pIpAsterisk") String pIpAsterisk , 
			 @Param("pNomMascaraRedLan") String pNomMascaraRedLan , 
			 @Param("pNomMascaraOpenVpn") String pNomMascaraOpenVpn ,
//			 @Param("pIdCliente") Integer pIdCliente , 
//			 @Param("pIlLibre") boolean pIlLibre , 
			 @Param("pIpAsteriskBash") String pIpAsteriskBash,  
			 @Param("pPuerto_ssh_asterisk") Integer pPuerto_ssh_asterisk , 
			 @Param("pPuertoOpenvpn") String pPuertoOpenvpn , 
			 @Param("pPamConfinicial") String pPamConfinicial, 
			 @Param("pSimPais") String pSimPais , 
			 @Param("pSimProvincia") String pSimProvincia, 
			 @Param("pFullProvincia") String pFullProvincia , 
			 @Param("pNoOrgani") String pNoOrgani , 
			 @Param("pNoEmail") String pNoEmail , 
			 @Param("pIdModelo") Integer pIdModelo, 
			 @Param("pIdMarca") Integer pIdMarca, 
//			 @Param("pInicial") Integer pInicial , 
//			 @Param("pIdEstadoinst") Integer pIdEstadoinst,
			 @Param("pNomInstancia")String pNomInstancia,
			 @Param("pIlEstado") boolean pIlEstado);
	
	public List< CRUDResponse > notifyExecuteBashConfigInitial( @Param( "idBash" ) Integer idBash, @Param( "idInstance" ) int idInstance, @Param( "typeNotification" ) Integer typeNotification );

	public List< StatusBash > loadStatusConfigInitialInstance( @Param( "idInstance" ) Integer idInstance );

	public List< CRUDResponse > updateInstanceStatus( @Param( "idInstance" ) Integer idInstance, @Param( "idInstanceStatus" ) Integer idInstanceStatus, @Param( "codUser" ) String codUser );
	
	public List<InstanciaServerAsterisk> listaInstanciasPorEmpresa(@Param("p_id_instancia") Integer idInstancia)throws Exception;
}
