package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.EliminaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ActualizarPasswordRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioPorCodigoRequest;
import pe.com.tintegro.dto.request.ValidarLoginUsuarioRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.EliminaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ActualizarPasswordResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioPorCodigoResponse;
import pe.com.tintegro.dto.response.ValidarLoginUsuarioResponse;

public interface UsuarioDAO
{
   public ValidarLoginUsuarioResponse validarUsuario(ValidarLoginUsuarioRequest request)  throws Exception;
   
   public InsertarUsuarioEstandarResponse insertarUsuarioEstandar(InsertarUsuarioEstandarRequest request) throws Exception;

   public ListaUsuarioEstandarResponse listaUsuarioEstandar(ListaUsuarioEstandarRequest request)  throws Exception;
   
   public EliminaUsuarioEstandarResponse eliminarUsuarioEstandar(EliminaUsuarioEstandarRequest request) throws Exception;
   
   public ActualizarUsuarioEstandarResponse actualizarUsuarioEstandar(ActualizarUsuarioEstandarRequest request) throws Exception;
   
   public ActualizarPasswordResponse actualizarPassword(ActualizarPasswordRequest request) throws Exception;
   
   public ListaUsuarioPorCodigoResponse listarUsuarioPorCodigo(ListaUsuarioPorCodigoRequest request);
   
   }
