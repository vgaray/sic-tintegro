package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.EliminarPersonalRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

public interface PersonalServices {
	
	public ListarPersonalResponse listarPersonal(String codUsuario, String idInstancia,ListarPersonalRequest request)throws Exception;
	public CRUDResponse eliminarPersonal(String codUsuario,String idInstancia,EliminarPersonalRequest request)throws Exception;
	public CRUDResponse registrarPersonal(String codUsuario,String idInstancia,RegistrarPersonalRequest request) throws Exception;
	public CRUDResponse actualizarPersonal(String codUsuario,String idInstancia,ActualizarPersonalRequest request) throws Exception;
}
