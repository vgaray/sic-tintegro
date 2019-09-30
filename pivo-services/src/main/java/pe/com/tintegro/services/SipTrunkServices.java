package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.SipTrunk;
import pe.com.tintegro.dto.request.EditaSipTrunkRequest;
import pe.com.tintegro.dto.request.EliminaSipTrunkRequest;
import pe.com.tintegro.dto.request.InsertaSipTrunkRequest;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.EditaSipTrunkResponse;
import pe.com.tintegro.dto.response.EliminaSipTrunkResponse;
import pe.com.tintegro.dto.response.InsertaSipTrunkResponse;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;

public interface SipTrunkServices
{
	public InsertaSipTrunkResponse insertaSipTrunk(String codUsuario, String idInstancia, InsertaSipTrunkRequest request) throws Exception;

	public EditaSipTrunkResponse editaSipTrunk(String codUsuario, String idInstancia, EditaSipTrunkRequest request) throws Exception;

	public EliminaSipTrunkResponse eliminaSipTrunk(String codUsuario, String idInstancia, EliminaSipTrunkRequest request) throws Exception;

	public ListaSipTrunkResponse listaSipTrunk(String codUsuario, String idInstancia, ListaSipTrunkRequest request) throws Exception;
	
	public String generarSipTrunkTxt(String codUsuario, String idInstancia )throws Exception;

	public String writeSipTrunk(List<SipTrunk> lstSipTrunk)throws Exception;
}
