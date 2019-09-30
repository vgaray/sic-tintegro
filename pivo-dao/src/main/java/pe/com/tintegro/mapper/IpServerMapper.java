package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.IpServer;

public interface IpServerMapper {
	public List<IpServer> listaipserver(@Param("p_id_tipodetalle") Integer pIdTipodetalle);

}
