package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.PedidoPorCliente;
import pe.com.tintegro.dominio.Usuario;

public interface PedidoPorClienteMapper
{

	public List<PedidoPorCliente> pedidosPorcliente(
			@Param("pNoRazonSocial") String pNoRazonSocial, 
			@Param("pNuDocide") String pNuDocide, 
			@Param("pDireccion") String pDireccion,
			@Param("pTelefono") String pTelefono, 
			@Param("pCorreo") String pCorreo, 
			@Param("pPersonaReferencia") String pPersonaReferencia, 
			@Param("pEstado") Boolean pEstado,
			@Param("pIdTipDoc") Integer pIdTipDoc, 
			@Param("pIdEstadoPedido") Integer pIdEstadoPedido);
	


	public List<Integer> insertarInstanciaPorDetallePedido(
			@Param("pNoDetaPedido") String pNoDetaPedido,
			@Param("pIdTipoPedido") Integer pIdTipoPedido,
			@Param("pIdPedido") Integer pIdPedido,
			@Param("pIdTipoDetalle") Integer pIdTipoDetalle,
			@Param("pIdPlan") Integer pIdPlan,
			@Param("pIdCliente") Integer pIdCliente,
			@Param("pIpAsterisk") String pIpAsterisk,
			@Param("pNomMascaraRedLan") String pNomMascaraRedLan ,
			@Param("pNomMascaraOpenVpn") String pNomMascaraOpenVpn ,
			@Param("pIlEstado") boolean pIlEstado,
			@Param("pIlLibre") boolean pIlLibre,
			@Param("pIpAsteriskBash") String pIpAsteriskBash,
			@Param("pPuerto_ssh_asterisk") Integer pPuerto_ssh_asterisk,
			// pPuertoAsteriskBashCertificadoExt ,
			@Param("pPuertoOpenVpn") String pPuertoOpenVpn,
			@Param("pPamConfInicial") String pPamConfInicial,
			@Param("pSimPais") String pSimPais, 
			@Param("pSimProvincia") String pSimProvincia,
			@Param("pFullProvincia") String pFullProvincia,
			@Param("pNoOrgani") String pNoOrgani,
			@Param("pNoEmail") String pNoEmail, 
			@Param("pIdModelo") Integer pIdModelo,
			@Param("pIdMarca") Integer pIdMarca, 
			@Param("pNoModelo") String pNoModelo,
			@Param("pNoMarca") String pNoMarca,
			@Param("pInicial") Integer pInicial, 
			@Param("pIdEstadoInst") Integer pIdEstadoInst);

	public List<Usuario> asignarInstanciaUsuario(
			@Param("pIdinstancia") Integer pIdinstancia, 
			@Param("pNologin") String pNologin, 
			@Param("pNopasswo") String pNopasswo,
			@Param("pNonombre") String pNonombre, 
			@Param("pNoapellido") String pNoapellido, 
			@Param("pNoemail") String pNoemail, 
			@Param("pNoProfe") String pNoProfe);
}
