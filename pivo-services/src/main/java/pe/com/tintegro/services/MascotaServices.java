package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarMascotaRequest;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;

public interface MascotaServices {

	public ListarMascotaResponse listarMascota(String codUsuario,ListarMascotaRequest request)throws Exception;
	public CRUDResponse registrarMascota(String codUsuario,RegistrarMascotaRequest request)throws Exception;
	public CRUDResponse actualizarMascota(String codUsuario,ActualizarMascotaRequest request)throws Exception;
	public CRUDResponse eliminarMascota(String codUsuario,EliminarMascotaRequest request)throws Exception;
}
