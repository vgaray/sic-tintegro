package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.BuscarIVRPorNombreRequest;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;

public interface IvrOpcionServices
{
	public InsertarIvrOpcionResponse insertarIvrResponse(String codUsuario, String idInstancia, InsertarIvrOpcionRequest request) throws Exception;

	public CRUDResponse eliminarIvrResponse(String codUsuario, String idInstancia, EliminarIvrOpcionRequest request) throws Exception;

	public CRUDResponse editarIvrResponse(String codUsuario, String idInstancia, EditarIvrOpcionRequest request) throws Exception;

	public ListarIvrOpcionResponse listarIvrResponse(String codUsuario, String idInstancia, ListarIvrOpcionRequest request) throws Exception;
	
	public CRUDResponse buscarIVRPorNombre( String codUsuario, String idInstancia, BuscarIVRPorNombreRequest request ) throws Exception;
}
