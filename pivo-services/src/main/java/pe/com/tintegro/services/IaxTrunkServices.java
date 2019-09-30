package pe.com.tintegro.services;

import java.util.List;

import pe.com.tintegro.dominio.IaxTrunk;
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
import pe.com.tintegro.dto.response.ViewCodeIaxTrunkResponse;

public interface IaxTrunkServices
{
	public InsertaIaxTrunkResponse insertaIaxTrunk(String codUsuario, String idInstancia, InsertaIaxTrunkRequest request) throws Exception;

	public ActualizaIaxTrunkResponse actualizaIaxTrunk(String codUsuario, String idInstancia, ActualizaIaxTrunkRequest request) throws Exception;

	public EliminaIaxTrunkResponse eliminaIaxTrunk(String codUsuario, String idInstancia, EliminaIaxTrunkRequest request) throws Exception;

	public ListaIaxTrunkResponse listaIaxTrunk(String codUsuario, String idInstancia, ListaIaxTrunkRequest request) throws Exception;

	public String generarIaxTrunkTxt(String codUsuario, String idInstancia) throws Exception;

	public String writeSipTrunk(String codUsuario, String idInstancia, List<IaxTrunk> lstIaxTrunk) throws Exception;

	public ViewCodeIaxTrunkResponse viewCodeIaxTrunk(String codUsuario, String idInstancia, ListaIaxTrunkRequest request) throws Exception;
	
	public ListarCentralesNoDisponiblesResponse listaCentralesNoDisponibles(String codUsuario, String idInstancia, ListarCentralesNoDisponiblesRequest request) throws Exception;
	
	public int desincriptarIdInstancia(String idInstancia);

	public String generarExtensionIax(String codUsu,String idIns,String noIaxInterno,int anexo,int fijLocal,int fijNacional,int fijInter,int celNac,int celInter,int celRpm,String numeracion,String prefijos,int fromsntp)throws Exception;
	
	public String encriptarIdInstancia(int idInstancia);	
}
