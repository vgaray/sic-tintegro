package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.ListaNegraDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.ListaNegra;
import pe.com.tintegro.dto.request.BuscarListaNegraRequest;
import pe.com.tintegro.dto.request.CambiaEstadoListaNegraRequest;
import pe.com.tintegro.dto.request.EliminarListaNegraRequest;
import pe.com.tintegro.dto.request.ActualizarListaNegraRequest;
import pe.com.tintegro.dto.request.InsertarListaNegraRequest;
import pe.com.tintegro.dto.request.ListarListaNegraRequest;
import pe.com.tintegro.dto.response.BuscarListaNegraResponse;
import pe.com.tintegro.dto.response.CambiaEstadoListaNegraResponse;
import pe.com.tintegro.dto.response.EliminarListaNegraResponse;
import pe.com.tintegro.dto.response.ActualizarListaNegraResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarListaNegraResponse;
import pe.com.tintegro.dto.response.ListarListaNegraResponse;

@Repository("listaNegraDAO")
public class ListaNegraDAOImpl implements ListaNegraDAO {

	@Override
	public InsertarListaNegraResponse insertarLista(String ip, InsertarListaNegraRequest request) throws Exception {
		InsertarListaNegraResponse response = new InsertarListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedureName = "asterisk.fn_insertar_lista_negra";
			Object[][] params = { 
					{ request.getNuTelefo(), String.class }, 
					{ request.getNoDescri(), String.class }, 
					{ request.isIlActivo(), Boolean.class }, 
					{ request.getCoTipllamSig(), String.class } };

			Map<String, String> mapColumnToAttribute = new HashMap<String, String>();
			mapColumnToAttribute.put("id_rasult", "idResult");
			mapColumnToAttribute.put("mensaje", "mensajeValidacion");

			Response<CRUDResponse> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttribute);

			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(responseObj.getData().get(0).getIdResult());
				response.setMensaje(responseObj.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ActualizarListaNegraResponse actualizarLista(String ip, ActualizarListaNegraRequest request) throws Exception {
		ActualizarListaNegraResponse response = new ActualizarListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_actualizar_lista_negra";
			Object[][] params = { 
					{ request.getNuTelefo(), String.class }, 
					{ request.getNoDescri(), String.class }, 
					{ request.isIlActivo(), Boolean.class }, 
					{ request.getCoTipllamSig(), String.class } };
			
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensajeValidacion");

			Response<CRUDResponse> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);
			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(responseObj.getData().get(0).getIdResult());
				response.setMensaje(responseObj.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarListaNegraResponse eliminarListaNegra(String ip, EliminarListaNegraRequest request) throws Exception {
		EliminarListaNegraResponse response = new EliminarListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_eliminar_lista_negra";
			Object[][] params = { { request.getNuTelefo(), String.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensajeValidacion");

			Response<CRUDResponse> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);

			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(responseObj.getData().get(0).getIdResult());
				response.setMensaje(responseObj.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarListaNegraResponse listarListaNegra(String ip, ListarListaNegraRequest request) throws Exception {
		ListarListaNegraResponse response = new ListarListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.sp_listar_lista_negra";

			Object[][] params = { { request.getNuTelefo(), String.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("nu_telefo", "nuTelefo");
			mapColumnToAttributte.put("no_descri", "noDescri");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("co_tipllam", "coTipllam");

			Response<ListaNegra> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, ListaNegra.class, mapColumnToAttributte);
			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje(Constantes.MSG_EXECUTE_COMMAND_SUCCESS);
				response.setListasNegras(responseObj.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public CambiaEstadoListaNegraResponse cambiaEstadoListaNegra(String ip, CambiaEstadoListaNegraRequest request) throws Exception {
		// TODO Auto-generated method stub
		CambiaEstadoListaNegraResponse response = new CambiaEstadoListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_actualizar_lista_negra_estado";

			Object[][] params = { 
					{ request.getNuTelefo(), String.class }, 
					{ request.getIlActivo(), Boolean.class } };

			Response<Integer> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);
			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje(Constantes.MSG_EXECUTE_COMMAND_SUCCESS);
				response.setResultado(responseObj.getData().get(0));
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public BuscarListaNegraResponse buscarListaNegra(String ip, BuscarListaNegraRequest request) throws Exception {
		BuscarListaNegraResponse response = new BuscarListaNegraResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_buscar_lista_negra";
			Object[][] params = { 
					{ request.getNuTelefo(), String.class }, 
					{ request.getIlActivo(), Boolean.class }, 
					{ request.getCoTipllam(), String.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("nu_telefo", "nuTelefo");
			mapColumnToAttributte.put("no_descri", "noDescri");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("co_tipllam", "coTipllam");

			Response<ListaNegra> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, ListaNegra.class, mapColumnToAttributte);
			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje(Constantes.MSG_EXECUTE_COMMAND_SUCCESS);
				response.setLsListaNegra(responseObj.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}
}