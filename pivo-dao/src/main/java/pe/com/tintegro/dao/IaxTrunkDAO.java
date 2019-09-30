package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizaIaxTrunkRequest;
import pe.com.tintegro.dto.request.EliminaIaxTrunkRequest;
import pe.com.tintegro.dto.request.InsertaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListarCentralesNoDisponiblesRequest;
import pe.com.tintegro.dto.response.ActualizaIaxTrunkResponse;
import pe.com.tintegro.dto.response.EliminaIaxTrunkResponse;
import pe.com.tintegro.dto.response.InsertaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListarCentralesNoDisponiblesResponse;

public interface IaxTrunkDAO
{
	public InsertaIaxTrunkResponse insertaIaxTrunk(String ip, InsertaIaxTrunkRequest request) throws Exception;

	public ActualizaIaxTrunkResponse actualizaIaxTrunk(String ip, ActualizaIaxTrunkRequest request) throws Exception;

	public EliminaIaxTrunkResponse eliminaIaxTrunk(String ip, EliminaIaxTrunkRequest request) throws Exception;

	public ListaIaxTrunkResponse listaIaxTrunk(String ip, ListaIaxTrunkRequest request) throws Exception;
	
	public ListarCentralesNoDisponiblesResponse listaCentralesNoDisponibles(String ip, ListarCentralesNoDisponiblesRequest request) throws Exception;
}
