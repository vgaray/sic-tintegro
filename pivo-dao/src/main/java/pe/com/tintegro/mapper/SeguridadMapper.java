package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Confirmacion;

public interface SeguridadMapper
{
	public List<Confirmacion> validarAccesoAServicio(@Param("p_no_login") String noLogin, @Param("p_no_url") String noUrl, @Param("p_il_istancia") boolean ilIstancia);

	public List<Confirmacion> validarAccesoAInstancia(@Param("p_no_login") String noLogin, @Param("p_id_instancia") Integer idInstancia);
}
