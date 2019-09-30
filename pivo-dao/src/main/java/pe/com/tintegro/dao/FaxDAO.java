package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.EliminarFaxRequest;
import pe.com.tintegro.dto.request.InsertarFaxRequest;
import pe.com.tintegro.dto.request.ListarFaxRequest;
import pe.com.tintegro.dto.response.EliminarFaxResponse;
import pe.com.tintegro.dto.response.InsertarFaxResponse;
import pe.com.tintegro.dto.response.ListarFaxResponse;

public interface FaxDAO
{
	public InsertarFaxResponse insertarFax(String ip,InsertarFaxRequest request) throws Exception;
	
	public ListarFaxResponse listarFax(String ip,ListarFaxRequest request) throws Exception;
	
	public EliminarFaxResponse eliminarFax(String ip, EliminarFaxRequest request) throws Exception;
}
