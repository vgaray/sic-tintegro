package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;

public interface SipBuddieDAO
{
	public InsertaSipBuddieResponse insertaSipBuddie(String ipUser,
			InsertaSipBuddieRequest request) throws Exception;

	public EditaSipBuddieResponse editaSipBuddie(String ipUser,
			EditaSipBuddieRequest request) throws Exception;

	public EliminaSipBuddieResponse eliminaSipBuddie(String ipUser,
			EliminaSipBuddieRequest request) throws Exception;
}
