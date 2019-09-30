package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarRolRequest;
import pe.com.tintegro.dto.request.AsignarPaginaRolRequest;
import pe.com.tintegro.dto.request.EliminaRolRequest;
import pe.com.tintegro.dto.request.ListaPaginasRequest;
import pe.com.tintegro.dto.request.ListaRolPorInstanciaRequest;
import pe.com.tintegro.dto.request.ListarRolPorTipoRolRequest;
import pe.com.tintegro.dto.request.RolRequest;
import pe.com.tintegro.dto.response.EliminaRolResponse;
import pe.com.tintegro.dto.response.ListaPaginasResponse;
import pe.com.tintegro.dto.response.ListaRolPorInstanciaResponse;
import pe.com.tintegro.dto.request.ListaRolSinInstanciaRequest;
import pe.com.tintegro.dto.response.ListaRolSinInstanciaResponse;
import pe.com.tintegro.dto.response.ListarRolPorTipoRolResponse;
import pe.com.tintegro.dto.response.RolResponse;

public interface RolServices
{
	public ListarRolPorTipoRolResponse listarRolesServices(ListarRolPorTipoRolRequest request) throws Exception;
   
   public RolResponse crearRol(String codUsuario, String idInstancia, RolRequest request)
		throws Exception;
   
   public RolResponse asignarPaginaPorRol(String codUsuario, String idInstancia, AsignarPaginaRolRequest request) 
   		throws Exception;
   
   public RolResponse asignarPaginaPorRolTotal(String codUsuario, String idInstancia, RolRequest request) throws Exception;
   
   public RolResponse actualizarRol(String codUsuario, String idInstancia, ActualizarRolRequest request)
			throws Exception;
   
   public RolResponse actualizarRolTotal(String codUsuario, String idInstancia, ActualizarRolRequest request) throws Exception;
   
   public RolResponse eliminarPaginaPorRol(String codUsuario, String idInstancia, AsignarPaginaRolRequest request) 
	   		throws Exception;

   public ListaPaginasResponse listaPaginasPorRolServices(ListaPaginasRequest request) throws Exception;
  
   public ListaRolPorInstanciaResponse listarRolPorPaginaServices(ListaRolPorInstanciaRequest request) throws Exception;

   public ListaRolSinInstanciaResponse listarRolSinInstanciaServices(ListaRolSinInstanciaRequest request) throws Exception;
   
   public RolResponse eliminarRol(AsignarPaginaRolRequest request) throws Exception;
   
   public EliminaRolResponse eliminarRol( String idInstancia, EliminaRolRequest request ) throws Exception;
}
