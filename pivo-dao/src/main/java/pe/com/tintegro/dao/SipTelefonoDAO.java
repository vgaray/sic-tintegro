package pe.com.tintegro.dao;

import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaMailBoxResponse;

public interface SipTelefonoDAO
{
	public ListaSipTelefonoResponse listaSipTelefono( String ip ) throws Exception;

	public BuscaSipBuddieIdResponse BuscaSipBuddie( String ip, BuscaSipBuddieIdRequest request ) throws Exception;
	
	/**
	 * Obtiene un objeto de la clase {@link SipTelefono} dado número de anexo.
	 * 
	 * @param codUsuario es el nombre de usuario con el que accede al sistema.
	 * @param idInstancia es el identificador de la instancia donde se quiere operar.
	 * @param numeroAnexo es el numero del anexo del que se quieren obtener todos sus atributos
	 * @return objeto de la clase {@link SipTelefono} con los atributos del anexo SIP.
	 * @throws Exception puede ocurrir en caso falle la conexión con la base de datos o halla una
	 * inconsistencia al momento de realizar un matching de los resultados de la consulta.
	 */
	public SipTelefono obtenerSipTelelefonoPorNumeroAnexo( String codUsuario, String ip, String numeroAnexo ) throws Exception;
	
	/**
	 * Obtiene los datos de la marca de un anexo determinado.
	 * 
	 * @param codUsuario es el nombre de usuario con el que accede al sistema.
	 * @param idInstancia es el identificador de la instancia sobre la que se quiere operar.
	 * @param nuAnexo es el número del anexo del que se desea obtener los datos de la marca.
	 * @return un objeto de la clase {@link MarcaTelefono}
	 * @throws Exception puede ocurrir cuando exista una falla en la conexión con el servidor de base de datos de la instancia
	 * en cuestión.
	 */
	public MarcaTelefono obtenerMarcaPorNumeroDeAnexo( String codUsuario, String ip, String nuAnexo ) throws Exception;
	
	public AutoCompletarSipTelefonoResponse AutoCompletarSipTelefono(String ip, AutoCompletarSipTelefonoRequest request) throws Exception;
	
	public ModeloTelefono obtenerModeloPorMarcaDeTelefono( String codUsuario, String ip, SipTelefono sipTelefono ) throws Exception;
	
	public ValidaMailBoxResponse validarMailBox(String codUsuario, String ip, ValidaMailBoxRequest request) throws Exception;
}
