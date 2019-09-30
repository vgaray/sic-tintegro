package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;;

public interface GrabacionDAO {
	
	public GrabacionResponse listarGrabaciones(String ip, GrabacionRequest request) throws Exception;
	
}
