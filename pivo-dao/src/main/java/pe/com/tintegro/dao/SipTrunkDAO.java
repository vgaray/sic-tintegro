package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.EditaSipTrunkRequest;
import pe.com.tintegro.dto.request.EliminaSipTrunkRequest;
import pe.com.tintegro.dto.request.InsertaSipTrunkRequest;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.EditaSipTrunkResponse;
import pe.com.tintegro.dto.response.EliminaSipTrunkResponse;
import pe.com.tintegro.dto.response.InsertaSipTrunkResponse;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;

public interface SipTrunkDAO
{

	public InsertaSipTrunkResponse insertaSipTrunk(String ip, InsertaSipTrunkRequest request) throws Exception;

	public EditaSipTrunkResponse editaSipTrunk(String ip, EditaSipTrunkRequest request) throws Exception;

	public EliminaSipTrunkResponse eliminaSipTrunk(String ip, EliminaSipTrunkRequest request) throws Exception;

	public ListaSipTrunkResponse listaSipTrunk(String ip, ListaSipTrunkRequest request) throws Exception;

}
