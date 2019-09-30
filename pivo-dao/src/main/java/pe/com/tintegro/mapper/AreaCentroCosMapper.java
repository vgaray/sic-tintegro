package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AreaCentroCosMapper {
	
	public List<Integer> InsertaAreaCentroCosto(@Param("pNombre") String pNombre, @Param("idPadre")Integer idPadre);
}

