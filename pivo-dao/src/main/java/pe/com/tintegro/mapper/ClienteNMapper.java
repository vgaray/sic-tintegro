package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface ClienteNMapper {
	
	public List<ClienteN> listarClienteN(@Param("p_id_cliente") Integer idCliente,
											@Param("p_no_razon_social") String noRazonSocial,
											@Param("p_nudocide") String nuDocIde,
											@Param("p_estado")boolean pEstado,
											@Param("p_nu_pagina")Integer pNuPagina,
											@Param("p_nu_reg_mostras")Integer pNuRegMostras);
	
	public List<CRUDResponse> registrarClienteN( @Param("p_no_razon_social") String noRazonSocial,
											@Param("p_nu_docide") String nuDocIde,
											@Param("p_direccion") String direcc,
											@Param("p_telefono") String telef,
											@Param("p_correo") String correoEle,
											@Param("p_personareferencia") String personRef,
											@Param("p_estado") boolean estado,
											@Param("p_id_tipdoc") Integer idTipdoc,
											@Param("p_nu_documento_pref") String nuDocumentoPref,
											@Param("p_id_tipdoc_pref") Integer idTipdocPref,
											@Param("p_nu_celular_pref") String nuCelularPref,
											@Param("nu_fijo_pref") String nuFijoPref);
	
	public List<CRUDResponse> eliminarClienteN(@Param("p_id_cliente") Integer idCliente);
	
	
	public List<CRUDResponse> actualizarClienteN (@Param("p_id_cliente") int idCliente,
			 							@Param("p_no_razon") String noRazonSocial,
			 							@Param("p_nu_docide") String nuDocIde,
			 							@Param("p_direccion") String direcc,
			 							@Param("p_telefono") String telef,
			 							@Param("p_correo") String correoEle,
			 							@Param("p_persref") String personRef,
			 							@Param("p_estado") boolean estado,
			 							@Param("p_id_tipdoc") Integer idTipdoc,
			 							@Param("p_nu_documento_pref") String nuDocumentoPref,
			 							@Param("p_id_tipdoc_pref") Integer idTipdocPref,
			 							@Param("p_nu_celular_pref") String nuCelularPref,
			 							@Param("p_nu_fijo_pref") String nuFijoPref);

}
