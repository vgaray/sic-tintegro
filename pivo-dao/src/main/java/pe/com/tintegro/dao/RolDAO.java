package pe.com.tintegro.dao;

import java.util.List;

import pe.com.tintegro.dominio.Confirmacion;
import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;

public interface RolDAO
{  
    public RolResponse crearRol(RolRequest request) throws Exception;
    
    public RolResponse AsignarPaginaPorRol(AsignarPaginaRolRequest request)throws Exception; 
    
    //aqui mismo se elimina las paginas por el rol para insertar la nueva lista de paginas por rol.
    public RolResponse actualizarRol(ActualizarRolRequest request) throws Exception;
    
    public RolResponse eliminarPaginaPorRol(AsignarPaginaRolRequest request) throws Exception;
    
    public ListaPaginasResponse listaPaginasPorRol(ListaPaginasRequest request) throws Exception;

    public ListarRolPorTipoRolResponse listarRolPorTipo(ListarRolPorTipoRolRequest request) throws Exception;
    
    public ListaRolPorInstanciaResponse listarRolPorPagina(ListaRolPorInstanciaRequest request) throws Exception;
    
    public ListaRolSinInstanciaResponse listaRolSinInstancia(ListaRolSinInstanciaRequest request) throws Exception;
    
    public RolResponse eliminarRol(AsignarPaginaRolRequest request) throws Exception;
    
    public List<Confirmacion> eliminarRol( Integer idInstancia, Integer idRol ) throws Exception;
}
