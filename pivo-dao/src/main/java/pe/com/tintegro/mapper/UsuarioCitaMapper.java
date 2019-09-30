package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.UsuarioXCita;

public interface UsuarioCitaMapper {
	public List<UsuarioXCita> listaUsuarioCita(@Param("p_nu_documento") String pNuDocumento);

}
