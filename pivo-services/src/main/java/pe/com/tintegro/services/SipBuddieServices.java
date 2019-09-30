package pe.com.tintegro.services;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.ConfigAnnexRequest;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.GeneraClaveAnexoSipRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.response.ConfigAnnexResponse;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;

public interface SipBuddieServices
{	
		
	/**
	 * Registro de un anexo en el sistema.
	 * Consiste en el registro del anexo tanto en la base de datos,
	 * como en la generación de sus respectivos archivos de configuración
	 * en el servidor de archivos y el servidor asterisk(la instancia propiamente).
	 * 
	 * @param codUsuario el nombre de usuario con el que accede al sistema.
	 * @param idInstancia es el identificador de la instancia sobre la que se quiere operar.
	 * @param request objeto de la clase {@link InsertaSipBuddieRequest} que contiene los campos a registrar en la base de datos.
	 * @param esCargaInicial flag que indica si el anexo se está insertando después de la primera configuración inicial de 
	 * la instancia.
	 * @return objeto de la clase {@link InsertaSipBuddieResponse} que contiene un flag que confirma el estado de la inserción;
	 * 1: exitoso, 0: fallido.
	 * @throws Exception
	 */
	public InsertaSipBuddieResponse insertarSipBuddie(String codUsuario,String idInstancia, InsertaSipBuddieRequest request) throws Exception;

	public EditaSipBuddieResponse editarSipBuddie(String codUsuario,String idInstancia, EditaSipBuddieRequest request, boolean esCarga) throws Exception;

	public EliminaSipBuddieResponse eliminaSipBuddie(String codUsuario,String idInstancia, EliminaSipBuddieRequest request) throws Exception;
	
	/**
	 * Generación del identificador del anexo.
	 *  
	 * @param codUsuario es el nombre de usuario con el que accede al sistema.
	 * @param idInstancia es el identificador de la instancia sobre la que se quiere operar.
	 * @param request objeto de la clase {@link GeneraClaveAnexoSipRequest}
	 * @return una cadena con valores aleatorios.
	 * @throws Exception
	 */
	public String generateAnnexID( String codUsuario,String idInstancia, GeneraClaveAnexoSipRequest request ) throws Exception;

	public void crudAnnexInAsterisk( String codUsuario,String idInstancia, int tipoOperacion, SipBuddie buddie,ListaInstanciaRequest requestIns,Boolean needProvisioning ) throws Exception;

	/**
	 * Obtención de la referencia a las credenciales de los anexos.
	 * En caso de ser un anexo aprovisionado se devolverá solo el link 
	 * del servidor donde se encuentre sus archivos, dependiendo de su modelo.
	 * En caso de ser un anexo no aprovisionado se devolverá solo una cadena 
	 * en base 64 que contendrá el archivo comprimido de las credenciales
	 * del softphone.
	 * 
	 * @param codUsuario el nombre de usuario para acceder al sistema.
	 * @param idInstancia es el identificador de la instancia al que pertence el anexo.
	 * @param request trae los datos principales del anexo para poder obtener sus credenciales.
	 * @return un objeto {@link ConfigAnnexResponse} que tiene como atributos el link del servidor 
	 * para obtener las credenciales y una cadena que guardará el archivo comprimido en base 64.
	 * Dependiendo de si el anexo es aprovisionado o no, solo uno de estos campos será diferente de 
	 * null en la respuesta.
	 * @throws Exception
	 */
	public ConfigAnnexResponse getCredentials( String codUsuario, String idInstancia, ConfigAnnexRequest request ) throws Exception;
	
	/**
	 * 
	 * @param codUsuario
	 * @param vm
	 * @param sipBuddie
	 * @param sipTelefono
	 * @param needProvisioning
	 * @throws Exception
	 */
	public void generateKeys( String codUsuario, InstanciaServerAsterisk vm, SipBuddie sipBuddie, SipTelefono sipTelefono, boolean needProvisioning ) throws Exception;
	
	/**
	 * 
	 * @param codUsuario
	 * @param idInstancia
	 * @param vm TODO
	 * @param sipBuddie
	 * @param sipTelefono
	 * @param needProvisioning
	 * @throws Exception
	 */
	public void redirectKeysToFileServer( String codUsuario, String idInstancia, InstanciaServerAsterisk vm, SipBuddie sipBuddie, SipTelefono sipTelefono, boolean needProvisioning ) throws Exception;
	
	public String generateClientID( InstanciaServerAsterisk vm, SipBuddie sipBuddie );
		
	public void deleteKeysDirectory(String codUsuario, String idInstancia, String numAnexo, InstanciaServerAsterisk vm) throws Exception;
	
	public void generateCertificate( String codUsuario, String idInstancia, InstanciaServerAsterisk vm, SipBuddie sipBuddie ) throws Exception;
	
	public void packageCertificates( String codUsuario, String idInstancia, boolean needProvisioned, InstanciaServerAsterisk vm, SipBuddie sipBuddie, SipTelefono sipTelefono ) throws Exception;
	
	public boolean getStatusSIP( String codUsuario, String idInstancia, InstanciaServerAsterisk vm, SipBuddie buddie ) throws Exception;
	
	public void deleteKeysOnFileServer( String codUsuario, String idInstancia, boolean isProvisioned, InstanciaServerAsterisk vm, SipBuddie sipBuddie ) throws Exception;

	public void generateLibreta( String codUsuario, String idInstancia, Integer tipoOperacion, InstanciaServerAsterisk vm, SipBuddie sipBuddie ) throws Exception;

	public void bashProvisioning(Integer tipoProduct,boolean tlsSecurity,String marcaTelef,String MacTelef,
						    	 String anexo,String callerId,String passAnexo,String ipOpen,String timeZone,
						    	 String empNom,String hashDirEmp,String passLdap,InstanciaServerAsterisk vm) throws Exception;
	
	public void bastTlssRtp( String codUsuario, String idInstancia,  InstanciaServerAsterisk vm, String ipOpen,
							 String empNom,String passLdap,String anexo) throws Exception;
}
