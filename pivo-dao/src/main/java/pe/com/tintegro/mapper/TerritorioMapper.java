package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Territorio;

public interface TerritorioMapper {

	public List<Territorio> listarTerritorio(@Param("p_co_pais")String pCoPais);

}
