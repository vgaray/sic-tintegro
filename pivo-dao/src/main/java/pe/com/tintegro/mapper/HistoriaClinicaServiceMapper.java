package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.HistoriaClinica;
import pe.com.tintegro.dominio.HistoriaClinicaService;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface HistoriaClinicaServiceMapper {
	
	public List<HistoriaClinicaService> listarHistoriaClinicaService(@Param("p_nu_chip") String p_nu_chip,
			@Param("p_no_pass") String pNoPass, @Param("p_id_instancia") Integer pIdInstancia);
}
