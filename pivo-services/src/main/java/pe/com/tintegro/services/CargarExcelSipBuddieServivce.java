package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;

public interface CargarExcelSipBuddieServivce {
	EditaSipBuddieResponse CargarExcelsipBuddie(String codUsuario,String idInstancia, List<EditaSipBuddieRequest> ListSipBuddie) throws Exception; 
}
