package pe.com.tintegro.services;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListaUsuarioEstandarRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.CargaEstadoConfigInstanciaResponse;
import pe.com.tintegro.dto.response.EvaluarInstanciaResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListaUsuarioEstandarResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxCasoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;

public interface InstanciaServices
{
	public InsertarInstanciaNResponse insertarInstanciaN(String codUsuario,InsertarInstanciaNRequest request)throws Exception;
	
	public String determinarIp(String idInstancia) throws Exception;

	public InstanciaServerAsterisk buscarInstancia(String codUsuario, String idInstancia) throws Exception;

	public ListaInstanciaxIdResponse listarIntanciaxIdInstancia(String codUsuario, ListaInstanciaxIdRequest request) throws Exception;

	public ListarInstanciaxIdClienteResponse listarIntanciaxIdCliente(String codUsuario, ListarInstanciaxIdClienteRequest request) throws Exception;

	public ListarInstanciaxCasoResponse listarIntanciaxCaso(String CodUsuario, ListarInstanciaxCasoRequest request) throws Exception;

	public InsertarInstanciaResponse insertarInstancia(String CodUsuario, InsertarInstanciaRequest obj) throws Exception;

	public ListaInstanciaResponse listaInstancia(String codUsuario, ListaInstanciaRequest request) throws Exception;

	public EvaluarInstanciaResponse evaluarInstancia(String codUsuario) throws Exception;

	public Boolean createFolderByInstanceInFileServer(String codUser, String idInstance);

	public int desincriptarIdInstancia(String idInstancia);

	public String encriptarIdInstancia(int idInstancia);

	public ActualizarInstanciaResponse actualizarInstancia(String CodUsuario, ActualizarInstanciaRequest request) throws Exception;

	public CRUDResponse notifyExecuteBashConfigInitial(String codUsuario, int idBash, String idInstance, Integer typeNotification) throws Exception;

	public CargaEstadoConfigInstanciaResponse loadStatusConfigInitialInstance(String codUser, String idInstance) throws Exception;

	public CRUDResponse updateInstanceStatus(Integer idEstadoInstancia, String codUser, String idInstance) throws Exception;

	public ListaInstanciasPorEmpresaResponse listaInstanciasPorEmpresa(String codUsuario, ListaInstanciasPorEmpresaRequest request) throws Exception;
	
}
