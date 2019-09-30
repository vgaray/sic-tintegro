package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.MenuSic;


public interface MenuSicMapper
{
 public List<MenuSic> listaMenuSic(@Param("p_no_login") String nomLogin,@Param("p_ti_menu") Integer tipoMenu);
}
