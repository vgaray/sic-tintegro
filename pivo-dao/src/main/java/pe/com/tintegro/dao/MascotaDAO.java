package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarMascotaRequest;
import pe.com.tintegro.dto.request.EliminarMascotaRequest;
import pe.com.tintegro.dto.request.ListarMascotaRequest;
import pe.com.tintegro.dto.request.RegistrarMascotaRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarMascotaResponse;

public interface MascotaDAO {
	public ListarMascotaResponse listarMascota(ListarMascotaRequest request)throws Exception;
	public CRUDResponse registrarMascota(RegistrarMascotaRequest request)throws Exception;
	public CRUDResponse actualizarMascota(ActualizarMascotaRequest request)throws Exception;
	public CRUDResponse eliminarMascota(EliminarMascotaRequest request)throws Exception;
}
