package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
public interface ControlMapper
{
  public List<String> listaControlRolEstado(
		@Param("p_no_login") String noLogin,
		@Param("p_ti_elemto") Integer tiElemto,
		@Param("p_id_estadoelemento") Integer idEstadoelemento);
}
