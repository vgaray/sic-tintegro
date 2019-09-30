package pe.com.tintegro.dao.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.SipTelefonoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaMailBoxResponse;

@Repository("sipTelefonoDAO")
public class SipTelefonoDAOImpl implements SipTelefonoDAO {

	@Override
	public ListaSipTelefonoResponse listaSipTelefono(String ip) throws Exception {
		ListaSipTelefonoResponse response = new ListaSipTelefonoResponse();

		PostgreSQL db = new PostgreSQL();
		Connection connection = db.conectar(ip);

		try {
			String storedProcedureName = "asterisk.fn_lista_sip_telefono";

			// Lista de parametros
			Object[][] params = {};

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("name", "nomUsuario");
			mapColumnToAttributte.put("caller_id", "callerId");
			mapColumnToAttributte.put("device", "nomMarca");
			mapColumnToAttributte.put("email", "email");
			// mapColumnToAttributte.put( "no_marca", "nomMarca" );
			mapColumnToAttributte.put("no_modelo", "nomModelo");
			mapColumnToAttributte.put("nu_mac", "nomMac");

			Response<SipTelefono> responseT = BaseDao.baseData(storedProcedureName, params, connection, SipTelefono.class, mapColumnToAttributte);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setSipTelefonoList(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());

		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public BuscaSipBuddieIdResponse BuscaSipBuddie(String ip, BuscaSipBuddieIdRequest request) throws Exception {
		BuscaSipBuddieIdResponse response = new BuscaSipBuddieIdResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_busca_anexo_edita";
			// Lista de parametros
			Object[][] params = { { request.getNomUsuario(), String.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("name", "nomUsuario");
			mapColumnToAttributte.put("secret", "claveUsuario");
			mapColumnToAttributte.put("callerid", "callerId");
			mapColumnToAttributte.put("mailbox", "mailbox");
			mapColumnToAttributte.put("email", "email");
			mapColumnToAttributte.put("id_marca", "marcaId");
			mapColumnToAttributte.put("id_modelo", "modeloId");
			mapColumnToAttributte.put("no_marca", "nomMarca");
			mapColumnToAttributte.put("no_modelo", "nomModelo");
			mapColumnToAttributte.put("no_mac", "nomMac");
			mapColumnToAttributte.put("no_ip_dominio", "nomIpDominio");
			mapColumnToAttributte.put("no_ruta", "nomRuta");
			Response<SipTelefono> responseT = BaseDao.baseData(storedProcedureName, params, db.con, SipTelefono.class, mapColumnToAttributte);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setSipTelefonoList(responseT.getData());
				response.setExisteEx(responseT.getData().size() > 0 ? true : false);
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public SipTelefono obtenerSipTelelefonoPorNumeroAnexo(String codUsuario, String ip, String numeroAnexo) throws Exception {
		SipTelefono sipTelefono = new SipTelefono();
		PostgreSQL postgreSQL = new PostgreSQL();
		postgreSQL.conectar(ip);
		try{
			String storedProcedureName = "asterisk.fn_obtener_sip_telefono_por_numero_anexo";
	
			// Lista de parametros
			Object[][] params = { { numeroAnexo, String.class } };
	
			/**
			 * Mapeo de los resultados de la consulta con los atributos de la clase
			 * SipTelefono
			 */
			Map<String, String> mapColumnToAttribute = new HashMap<String, String>();
			mapColumnToAttribute.put("name", "nomUsuario");
			mapColumnToAttribute.put("id_marca", "marcaId");
			mapColumnToAttribute.put("id_modelo", "modeloId");
			mapColumnToAttribute.put("no_mac", "nomMac");
			mapColumnToAttribute.put("no_ip_dominio", "nomIpDominio");
			mapColumnToAttribute.put("no_ruta", "nomRuta");
	
			Response<SipTelefono> responseBaseDao = BaseDao.baseData(storedProcedureName, params, postgreSQL.con, SipTelefono.class, mapColumnToAttribute);
			sipTelefono = responseBaseDao.getData().get(0);
		}
		finally {
			postgreSQL.cerrar();
		}
		return sipTelefono;
	}

	@Override
	public MarcaTelefono obtenerMarcaPorNumeroDeAnexo(String codUsuario, String ip, String nuAnexo) throws Exception {
		MarcaTelefono marca = new MarcaTelefono();
		PostgreSQL postgreSQL = new PostgreSQL();
		postgreSQL.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_obtener_marca_por_numero_anexo";
	
			Object[][] params = { { nuAnexo, String.class } };
	
			Map<String, String> mapColumnToAttribute = new HashMap<String, String>();
			mapColumnToAttribute.put("id_marca", "marcaId");
			mapColumnToAttribute.put("no_marca", "nomMarca");
			mapColumnToAttribute.put("il_formato_mac", "ilFormatoMac");
			mapColumnToAttribute.put("il_need_mac_for_provisioning", "ilNeedMACForProvisioning");
			mapColumnToAttribute.put("no_extension_for_provisioning", "noExtensionForProvisioning");
	
			Response<MarcaTelefono> reponseBaseDAO = BaseDao.baseData(storedProcedureName, params, postgreSQL.con, MarcaTelefono.class, mapColumnToAttribute);
	
			if (!reponseBaseDAO.getData().isEmpty())
				marca = reponseBaseDAO.getData().get(0);
			else {
				marca.setMarcaId(0);
				marca.setNomMarca("");
			}
		} 
		finally {
			postgreSQL.cerrar();
		}
		return marca;
	}

	public AutoCompletarSipTelefonoResponse AutoCompletarSipTelefono(String ip, AutoCompletarSipTelefonoRequest request) throws Exception {
		AutoCompletarSipTelefonoResponse response = new AutoCompletarSipTelefonoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_lista_anexos";
			Object[][] params = { { request.getpNuAnexo(), String.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			Response<String> responseT = BaseDao.baseData(storedProcedureName, params, db.con, String.class, mapColumnToAttributte);
			response.setListaAnexos(responseT.getData());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ModeloTelefono obtenerModeloPorMarcaDeTelefono(String codUsuario, String ip, SipTelefono sipTelefono) throws Exception {
		ModeloTelefono modelo = new ModeloTelefono();
		PostgreSQL postgreSQL = new PostgreSQL();
		postgreSQL.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_obtener_modelo_por_marca_de_telefono";
	
			Object[][] params = { 
					{ sipTelefono.getNomUsuario(), String.class }, 
					{ sipTelefono.getMarcaId(), Integer.class } };
	
			Map<String, String> mapColumnToAttribute = new HashMap<String, String>();
	
			Response<ModeloTelefono> responseDAO = BaseDao.baseData(storedProcedureName, params, postgreSQL.con, ModeloTelefono.class, mapColumnToAttribute);
	
			if (!responseDAO.getData().isEmpty())
				modelo = responseDAO.getData().get(0);
			else {
				modelo.setMarcaId(0);
				modelo.setModeloId(0);
				modelo.setNomModelo("");
			}
		}
		finally {
			postgreSQL.cerrar();	
		}
		return modelo;
	}

	@Override
	public ValidaMailBoxResponse validarMailBox(String codUsuario, String ip, ValidaMailBoxRequest request) throws Exception {
		ValidaMailBoxResponse response = new ValidaMailBoxResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_validar_mailbox";
			Object[][] params = { { request.getMailBox(), String.class } };

			Map<String, String> map = new HashMap<String, String>();
			map.put("id_rasult", "id");
			map.put("mensaje", "name");

			Response<SipBuddie> responseT = BaseDao.baseData(storedProcedureName, params, db.con, SipBuddie.class, map);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setExiste(responseT.getData().get(0).getId());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}
}