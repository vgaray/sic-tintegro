package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.Fax;
import pe.com.tintegro.dto.request.EliminarFaxRequest;
import pe.com.tintegro.dto.request.InsertarFaxRequest;
import pe.com.tintegro.dto.request.ListarFaxRequest;
import pe.com.tintegro.dto.response.EliminarFaxResponse;
import pe.com.tintegro.dto.response.InsertarFaxResponse;
import pe.com.tintegro.dto.response.ListarFaxResponse;

public interface FaxServices
{
	public ListarFaxResponse listarFax(String codUsuario,String idInstancia,ListarFaxRequest request) throws Exception;
	
	public InsertarFaxResponse insertarFax(String codUsuario,String idInstancia, InsertarFaxRequest request) throws Exception;
	
	public EliminarFaxResponse eliminarFax(String codUsuario,String idInstancia, EliminarFaxRequest request) throws Exception;
	
	public String generarTxtFax(String codUsuario,String idInstancia)throws Exception;
	
	public String writeFax(String codUsuario,String idInstancia,List<Fax> listado)throws Exception;  	
}
