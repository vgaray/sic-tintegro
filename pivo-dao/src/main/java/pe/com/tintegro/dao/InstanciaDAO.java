package pe.com.tintegro.dao;

import java.util.List;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxCasoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;

public interface InstanciaDAO
{
	public InsertarInstanciaNResponse insertarInstanciaN(InsertarInstanciaNRequest request)throws Exception; 
	
	public List<InstanciaServerAsterisk> listarInstancia();

	public ListaInstanciaxIdResponse listarInstanciaxId(ListaInstanciaxIdRequest request) throws Exception;

	public ListarInstanciaxIdClienteResponse listarInstanciaxIdCliente(ListarInstanciaxIdClienteRequest obj) throws Exception;

	// public ListarInstanciaxCasoResponse
	// listarInstanciaxvalor(ListarInstanciaxCasoRequest obj)throws Exception;

	public InsertarInstanciaResponse insertarInstancia(InsertarInstanciaRequest instancia) throws Exception;

	// public AsignarInstanciaResponse asignarInstancia(AsignarInstanciaRequest
	// request )throws Exception;

	public ListarInstanciaxCasoResponse listarInstanciaxCaso(ListarInstanciaxCasoRequest obj) throws Exception;

	public ListaInstanciaResponse listarInstancia(ListaInstanciaRequest request) throws Exception;

	public ActualizarInstanciaResponse actualizarInstancia(ActualizarInstanciaRequest request) throws Exception;

	public CRUDResponse notifyExecuteBashConfigInitial(String codUsuario, int idBash, int idInstance, Integer typeNotification) throws Exception;

	public List<StatusBash> loadStatusConfigInitialInstance(String codUser, Integer idInstance) throws Exception;

	public CRUDResponse updateInstanceStatus(Integer idEstadoInstancia, String codUser, Integer idInstance) throws Exception;

	public ListaInstanciasPorEmpresaResponse listaInstanciasPorEmpresa(ListaInstanciasPorEmpresaRequest request) throws Exception;
}
