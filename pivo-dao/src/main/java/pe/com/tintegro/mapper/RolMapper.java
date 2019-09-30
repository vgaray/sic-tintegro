package pe.com.tintegro.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dominio.Pagina;
import pe.com.tintegro.dominio.Rol;
import pe.com.tintegro.dto.response.RolResponse;

public interface RolMapper
{    
    public RolResponse crearRol(  
    		  @Param("pNoRol") String pNoRol, 
			  @Param("pNoDescri") String pNoDescri,
			  @Param("pIlActivo") Boolean pIlActivo,
			  @Param("pIdTipoRol") Integer pIdTipoRol,
			  @Param("pIdInstancia") Integer pIdInstancia);
    
    public RolResponse AsignarPaginaPorRol(
    		  @Param("pIdRol") Integer pIdRol,
			  @Param("pIdPagina") Integer pIdPagina);
    
    public RolResponse actualizarRol(
    		  @Param("pIdRol") Integer pIdRol,
    		  @Param("pNoRol") String pNoRol, 
			  @Param("pNoDescri") String pNoDescri,
			  @Param("pIlActivo") Boolean pIlActivo,
			  @Param("pIdTipoRol") Integer pIdTipoRol,
			  @Param("pIdInstancia") Integer pIdInstancia);
    
    public RolResponse eliminarPaginaPorRol(
    		  @Param("pIdRol") Integer pIdRol);

	public List<Rol> listarRolesPorRol(@Param("pIdTipoRol") Integer pIdTipoRol);

	public List<Rol> listaRolesPorInstancia(@Param("pCodUsuario") String pCodUsuario, @Param("pIdInstancia") Integer pIdInstancia);

	public List<Pagina> listaPaginaPorIdRol(@Param("pCodUsuario") String pCodUsuario, @Param("pIdRol") Integer pIdRol);
	
    public List<Rol> listaRolSinInstancia();
    
    public RolResponse eliminarRol(@Param("pIdRol") Integer pIdRol);
    
    public List<Confirmacion> eliminarRol( @Param( "idInstancia" ) Integer idInstancia, @Param( "idRol" ) Integer idRol );
}
