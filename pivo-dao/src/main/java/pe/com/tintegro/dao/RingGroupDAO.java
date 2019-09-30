package pe.com.tintegro.dao;

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

public interface RingGroupDAO
{
	public ListaRingGroupResponse listaRingGroupDAO(String ip, ListaRingGroupRequest request) throws Exception;
   public InsertarRingGroupResponse insertarRingGroupDAO(String ip, InsertarRingGroupRequest request)throws Exception;
   public ActualizarRingGroupResponse actualizarRingGroupDAO(String ip, ActualizarRingGroupRequest request) throws Exception;
   public EliminarRingGroupResponse eliminarRingGroupDAO(String ip, EliminarRingGroupRequest request)throws Exception;
   public ListarVerificacionRingGroupResponse verificacionRingGroupDAO (String ip, ListarVerificacionRingGroupRequest request)throws Exception;
   public ListarRingGroupxAnexoResponse filtroRingGroupDAO (String ip, ListarRingGroupxAnexoRequest request)throws Exception;
}
