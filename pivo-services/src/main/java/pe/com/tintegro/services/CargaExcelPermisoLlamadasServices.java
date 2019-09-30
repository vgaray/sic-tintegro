package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dto.request.CargaExcelPermisoLlamadasRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ValidaExcelResponse;

public interface CargaExcelPermisoLlamadasServices {
	InsertarUsuarioResponse SubirExcelPermisoLlamadas(String codUsuario,String idInstancia, CargaExcelPermisoLlamadasRequest request ) throws Exception;
	InsertarUsuarioResponse CargaExcelPermisoLlamadas(String codUsuario,String idInstancia, List<InsertarUsuarioRequest> ListPermisoLlamada) throws Exception;
	
	ValidaExcelResponse validaExcelPermisoLlamada(String fileExcel64)throws Exception;
	ValidaExcelResponse validaPines(List<InsertarUsuarioRequest> listausuario) throws Exception;
}
