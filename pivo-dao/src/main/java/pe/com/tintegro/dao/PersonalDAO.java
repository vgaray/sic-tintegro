package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.EliminarPersonalRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

public interface PersonalDAO {

	public ListarPersonalResponse listarPersonal(String ip,ListarPersonalRequest request)throws Exception;
	public CRUDResponse eliminarPersonal(String ip,EliminarPersonalRequest request)throws Exception;
	public CRUDResponse registrarPersonal(String ip,RegistrarPersonalRequest request)throws Exception;
	public CRUDResponse actualizarPersonal(String ip,ActualizarPersonalRequest request) throws Exception;
}
