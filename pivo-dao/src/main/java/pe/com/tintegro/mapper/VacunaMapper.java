package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.ConstanteFisiologica;
import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dominio.Vacuna;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface VacunaMapper {

	public List<Vacuna> listarVacuna(@Param("p_nu_chip") String pNuChip,
			@Param("p_no_pass") String pNoPass, @Param("p_id_instancia") Integer pIdInstancia);
}
