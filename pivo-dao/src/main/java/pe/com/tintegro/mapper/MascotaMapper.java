package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Mascota;
import pe.com.tintegro.dto.response.CRUDResponse;

public interface MascotaMapper {
	
	public List<Mascota> listarMascota(@Param("p_id_mascota") Integer pIdMascota,
									@Param("p_cod_usuario") String codUsuario,
									@Param("p_nu_chip") String pNuChip,
									@Param("p_ti_fun") Integer pTiFun);
	
	public List<CRUDResponse> registrarMascota(@Param("p_no_nombre") String pNoNombre,
										  @Param("p_no_color") String pNoColor,
										  @Param("p_no_senias_particulares") String pNoSeniasParticulares,
										  @Param("p_no_sexo") String pNoSexo,
										  @Param("p_nu_edad") String pNuEdad,
										  @Param("p_nu_chip") String pNuChip,
										  @Param("p_fe_nacimiento") String pFeNacimiento,
										  @Param("p_cod_usuario") String pCodUsuario,
										  @Param("p_id_especie") Integer pIdEspecie,
										  @Param("p_id_raza") Integer pIdRaza);
	
	public List<CRUDResponse> actualizarMascota(@Param("p_id_mascota") Integer pIdMascota,
										  @Param("p_no_nombre") String pNoNombre,
										  @Param("p_no_color") String pNoColor,
										  @Param("p_no_senias_particulares") String pNoSeniasParticulares,
										  @Param("p_no_sexo") String pNoSexo,
										  @Param("p_nu_edad") String pNuEdad,
										  @Param("p_nu_chip") String pNuChip,
										  @Param("p_fe_nacimiento") String pFeNacimiento,
										  @Param("p_cod_usuario") String pCodUsuario,
										  @Param("p_id_especie") Integer pIdEspecie,
										  @Param("p_id_raza") Integer pIdRaza);
	
	public List<CRUDResponse> eliminarMascota(@Param("p_id_mascota") Integer pIdMascota);

}
