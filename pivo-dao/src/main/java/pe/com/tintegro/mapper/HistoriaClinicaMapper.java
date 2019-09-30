package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface HistoriaClinicaMapper {
	public List<HistoriaClinica> listarHistoriaClinica(@Param("p_id_mascota") Integer idMascota,
			@Param("p_no_usuario") String noUsuario, @Param("p_ti_fun") Integer tiFun);

	public List<CRUDResponse> registrarHistoriaClinica(@Param("p_no_alergias") String noAlergias,
			@Param("p_no_ant_familiares") String noAntFamiliares, @Param("p_id_mascota") Integer idMascota,
			@Param("p_id_estado_reproductivo") Integer idEstadoReproductivo,
			@Param("p_id_tipo_alimentacion") Integer idTipoAlimentacion);

	public List<CRUDResponse> actualizarHistoriaClinica(@Param("p_id_historia_clinica") Integer idHistoriaClinica,
			@Param("p_no_alergias") String noAlergias, @Param("p_no_ant_familiares") String noAntFamiliares,
			@Param("p_id_estado_reproductivo") Integer idEstadoReproductivo,
			@Param("p_id_tipo_alimentacion") Integer idTipoAlimentacion);

	public List<CRUDResponse> eliminarHistoriaClinica(@Param("p_id_historia_clinica") Integer idHistoriaClinica);

	//
	
}
