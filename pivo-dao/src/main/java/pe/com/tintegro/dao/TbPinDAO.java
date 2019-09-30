package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.request.PinValidar;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;

public interface TbPinDAO {
	
	public FlagTbPinResponse modificarflagTbPin(String ipUser, FlagTbPinRequest request) throws Exception;
	 
	public FlagTbPinResponse valivarPing(String ipUser, PinValidar request) throws Exception;// 1 = pin disponible 0= pin no disponible
 
	public BuscaPinResponse BuscaPin(String ipUser, BuscaPinRequest request) throws Exception;
 
}
