package pe.com.tintegro.services;

import pe.com.tintegro.dominio.EnvioMail;
import pe.com.tintegro.dto.request.ActualizarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.EliminaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ActualizarPasswordRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ValidarLoginUsuarioRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.EliminaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ActualizarPasswordResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ValidarLoginUsuarioResponse;

public interface UsuarioServices
{
   public ValidarLoginUsuarioResponse validaLoginUsuarioServices(ValidarLoginUsuarioRequest request) throws Exception;
   
   public InsertarUsuarioEstandarResponse insertarUsuarioEstandarServices(InsertarUsuarioEstandarRequest request) throws Exception;
   
   public ListaUsuarioEstandarResponse listaUsuarioServices(ListaUsuarioEstandarRequest request) throws Exception;
   
   public EliminaUsuarioEstandarResponse eliminaUsuarioEstandarServices(EliminaUsuarioEstandarRequest request) throws Exception;
   
   public ActualizarUsuarioEstandarResponse actualizarUsuarioEstandarServices(ActualizarUsuarioEstandarRequest request) throws Exception;
	
   public String encriptarIdInstancia(int idInstancia) throws Exception;

   public ActualizarPasswordResponse actualizarPassword(ActualizarPasswordRequest request) throws Exception;

   public String enviarMail(EnvioMail request) throws Exception;
}
