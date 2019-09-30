package pe.com.tintegro.services;

import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dto.request.EjecutarBashRequest;
import pe.com.tintegro.dto.response.EjecutarBashResponse;

public interface ConfiguracionInicialAsteriskServices
{
	public EjecutarBashResponse iniciarBashesAsterisk(String codUsuario, String idInstancia) throws Exception;
	
	public String importBashesToAsteriskServer( String codUser, String idInstance, EjecutarBashRequest request ) throws Exception;
	
	public String crearDbBash(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;

	public String serverVpn(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;

	public String faxServer(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;

	public String fileAsterisk(String codUsuario, String idInstancia) throws Exception;
	
	public String bashSecurity(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;
	
	public String bashOpenLdap(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;
	
	public String tlsSecurity(String codUsuario, String idInstancia, EjecutarBashRequest request) throws Exception;
	
	/**
	 * Servicio que crear un espacio (carpeta) en el file server, para el almacenamiento de las credenciales de 
	 * los anexos SIP.
	 * 
	 * @param codUsuario es el código con el que se accede al sistema.
	 * @param idInstancia es el identificador (cadena) hasheado de la instancia.
	 * @param request TODO
	 * @return Salida de la terminal del servidor después de la ejecución del bashero. 
	 * @throws Exception en caso de errores se retorna a la siguiente capa.
	 */
	public String createProvisioningSpace(String codUsuario , String idInstancia , EjecutarBashRequest request ) throws Exception;
	
	public String verifyService( String codUsuario, int serviceID, InstanciaServerAsterisk vm ) throws Exception;
	public void bashCreateDirectoryFileServer(String idInstancia)throws Exception;
}
