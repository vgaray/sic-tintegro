package pe.com.tintegro.services;


import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;

public interface GrabacionServices {
	
	public GrabacionResponse listarDesdeCarpeta(String codUsuario, String idInstancia,GrabacionRequest request ,CredencialesEquipo machine, String folderPath, int typeFiles, String[] allowedExtensions) throws Exception;
	public GrabacionResponse listarGrabaciones(String codUsuario, String idInstancia,GrabacionRequest request) throws Exception;
}
