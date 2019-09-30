package pe.com.tintegro.dao.impl;

import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.SipBuddieDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dto.request.EditaSipBuddieRequest;
import pe.com.tintegro.dto.request.EliminaSipBuddieRequest;
import pe.com.tintegro.dto.request.InsertaSipBuddieRequest;
import pe.com.tintegro.dto.response.EditaSipBuddieResponse;
import pe.com.tintegro.dto.response.EliminaSipBuddieResponse;
import pe.com.tintegro.dto.response.InsertaSipBuddieResponse;

@Repository("sipBuddieDAO")
public class SipBuddieDAOImpl implements SipBuddieDAO {
	@Override
	public InsertaSipBuddieResponse insertaSipBuddie(String ipUser, InsertaSipBuddieRequest request) throws Exception {
		InsertaSipBuddieResponse response = new InsertaSipBuddieResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);

		try {
			String storedProcedureName = "asterisk.fn_inserta_anexo";

			Object[][] params = { 
					{ request.getNomUsuario(), String.class }, 
					{ request.getClaveUsuario(), String.class }, 
					{ request.getCallerId(), String.class }, 
					{ request.getBuzonBox(), String.class }, 
					{ request.getCorreoBox(), String.class }, 
					{ request.getMarcaId(), Integer.class },
					{ request.getModeloId(), Integer.class }, 
					{ request.getMac(), String.class }, 
					{ request.getIpDominio(), String.class }, 
					{ request.getRuta(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setInsertado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EditaSipBuddieResponse editaSipBuddie(String ipUser, EditaSipBuddieRequest request) throws Exception {
		EditaSipBuddieResponse response = new EditaSipBuddieResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_editar_anexo";

			Object[][] params = { 
					{ request.getNomUsuario(), String.class }, 
					{ request.getClaveUsuario(), String.class }, 
					{ request.getCallerId(), String.class }, 
					{ request.getBuzonBox(), String.class }, 
					{ request.getCorreoBox(), String.class }, 
					{ request.getMarcaId(), Integer.class },
					{ request.getModeloId(), Integer.class }, 
					{ request.getMac(), String.class }, 
					{ request.getIpDominio(), String.class }, 
					{ request.getRuta(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setEditado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminaSipBuddieResponse eliminaSipBuddie(String ipUser, EliminaSipBuddieRequest request) throws Exception {
		EliminaSipBuddieResponse response = new EliminaSipBuddieResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);

		try {
			String storedProcedureName = "asterisk.fn_eliminar_anexo";
			Object[][] params = { { request.getNomUsuario(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setEliminado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
