package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarRingGroupRequest;
import pe.com.tintegro.dto.request.EliminarRingGroupRequest;
import pe.com.tintegro.dto.request.InsertarRingGroupRequest;
import pe.com.tintegro.dto.request.ListaRingGroupRequest;
import pe.com.tintegro.dto.request.ListarRingGroupxAnexoRequest;
import pe.com.tintegro.dto.request.ListarVerificacionRingGroupRequest;
import pe.com.tintegro.dto.response.ActualizarRingGroupResponse;
import pe.com.tintegro.dto.response.EliminarRingGroupResponse;
import pe.com.tintegro.dto.response.InsertarRingGroupResponse;
import pe.com.tintegro.dto.response.ListaRingGroupResponse;
import pe.com.tintegro.dto.response.ListarRingGroupxAnexoResponse;
import pe.com.tintegro.dto.response.ListarVerificacionRingGroupResponse;

public interface RingGroupServices
{
   public ListaRingGroupResponse listaGroupServices(String codUsuario, String idInstancia, ListaRingGroupRequest request) throws Exception;
   public InsertarRingGroupResponse insertarRingGroupServices(String codUsuario, String idInstancia, InsertarRingGroupRequest request)throws Exception;
   public ActualizarRingGroupResponse actualizarRingGroupServices(String codUsuario, String idInstancia, ActualizarRingGroupRequest request)throws Exception;
   public EliminarRingGroupResponse eliminarRingGroupServices(String codUsuario, String idInstancia, EliminarRingGroupRequest request)throws Exception;
   public ListarVerificacionRingGroupResponse verificacionRingGroup (String codUsuario, String idInstancia, ListarVerificacionRingGroupRequest request)throws Exception;
   public ListarRingGroupxAnexoResponse filtroRingGroupServices(String codUsuario, String idInstancia, ListarRingGroupxAnexoRequest request)throws Exception;
}
