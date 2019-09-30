package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.ModeloTelefono;

public interface ModeloTelefonoGeneralMapper
{
	public List<ModeloTelefono> listaModeloTelefonoPorMarcaGeneral(@Param("pIdMarca") Integer pIdMarca);
}
