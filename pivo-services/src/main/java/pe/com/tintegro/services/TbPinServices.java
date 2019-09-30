package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.request.PinValidar;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;

public interface TbPinServices {

	public FlagTbPinResponse modificarFlagTbPin(String codUsuario,String idInstancia, FlagTbPinRequest request) throws Exception;
	
	public FlagTbPinResponse pinValidar(String codUsuario,String idInstancia, PinValidar request) throws Exception;
 
	public BuscaPinResponse buscaPin(String codUsuario,String idInstancia,BuscaPinRequest request) throws Exception;
 
}
