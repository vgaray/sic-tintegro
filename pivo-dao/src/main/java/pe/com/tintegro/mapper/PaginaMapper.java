package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Pagina;

public interface PaginaMapper {
	public List<Pagina> listarPagina();
	public List<Pagina> listarPaginaGP();
	public List<Pagina> listaPaginaUrl(@Param("p_no_componente") String pNoComponente);	
}