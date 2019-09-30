package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;

public interface IvrOpcionDAO
{
	public InsertarIvrOpcionResponse insertarIvrResponse(String ipUser, InsertarIvrOpcionRequest request) throws Exception;

	public CRUDResponse eliminarIvrResponse(String ipUser, EliminarIvrOpcionRequest request) throws Exception;

	public CRUDResponse editarIvrResponse(String ipUser, EditarIvrOpcionRequest request) throws Exception;

	public ListarIvrOpcionResponse listarIvrResponse(String ipUser, ListarIvrOpcionRequest request) throws Exception;
	
	public CRUDResponse buscarIVRPorNombre( String ipUser , String indicioNombreIVR  ) throws Exception;
}
