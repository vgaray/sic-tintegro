package pe.com.tintegro.services;

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

public interface SipTelefonoServices
{
	public ListaSipTelefonoResponse listaSipTelefono(String codUsuario, String idInstancia) throws Exception;

	public BuscaSipBuddieIdResponse buscaSipBuddieId(String codUsuario, String idInstancia, BuscaSipBuddieIdRequest request) throws Exception;

	/**
	 * Obtiene un objeto de la clase {@link SipTelefono} dado número de anexo.
	 * 
	 * @param codUsuario
	 *           es el nombre de usuario con el que accede al sistema.
	 * @param idInstancia
	 *           es el identificador de la instancia donde se quiere operar.
	 * @param numeroAnexo
	 *           es el numero del anexo del que se quieren obtener todos sus
	 *           atributos
	 * @return objeto de la clase {@link SipTelefono} con los atributos del anexo
	 *         SIP.
	 * @throws Exception
	 *            puede ocurrir en caso falle la búsqueda de la instancia a la que
	 *            pertenece el anexo debido a que no se logre la conexión con la
	 *            base de datos de la instancia; o que venga desde la capa de acceso
	 *            a datos ( DAO ).
	 */
	public SipTelefono obtenerSipTelelefonoPorNumeroAnexo(String codUsuario, String idInstancia, String numeroAnexo) throws Exception;

	/**
	 * Obtiene los datos de la marca de un anexo determinado.
	 * 
	 * @param codUsuario
	 *           es el nombre de usuario con el que accede al sistema.
	 * @param idInstancia
	 *           es el identificador de la instancia sobre la que se quiere operar.
	 * @param nuAnexo
	 *           es el número del anexo del que se desea obtener los datos de la
	 *           marca.
	 * @return un objeto de la clase {@link MarcaTelefono}
	 * @throws Exception
	 *            puede ocurrir cuando exista una falla en la capa de acceso a datos
	 *            ( DAO ).
	 */
	public MarcaTelefono obtenerMarcaPorNumeroDeAnexo(String codUsuario, String idInstancia, String nuAnexo) throws Exception;

	public AutoCompletarSipTelefonoResponse AutoCompletarSipTelefono(String codUsuario, String idInstancia, AutoCompletarSipTelefonoRequest request) throws Exception;
	
	public ModeloTelefono obtenerModeloPorMarcaDeTelefono(String codUsuario, String idInstancia, SipTelefono sipTelefono) throws Exception;
	
	public ValidaMailBoxResponse validarMailBox(String codUsuario, String idInstancia, ValidaMailBoxRequest request) throws Exception;
}
