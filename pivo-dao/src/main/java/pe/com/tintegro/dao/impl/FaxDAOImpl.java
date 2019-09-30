package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.FaxDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Fax;
import pe.com.tintegro.dto.request.EliminarFaxRequest;
import pe.com.tintegro.dto.request.InsertarFaxRequest;
import pe.com.tintegro.dto.request.ListarFaxRequest;
import pe.com.tintegro.dto.response.EliminarFaxResponse;
import pe.com.tintegro.dto.response.InsertarFaxResponse;
import pe.com.tintegro.dto.response.ListarFaxResponse;

@Repository("faxDAO")
public class FaxDAOImpl implements FaxDAO {

	@Override
	public InsertarFaxResponse insertarFax(String ip, InsertarFaxRequest request) throws Exception {
		InsertarFaxResponse response = new InsertarFaxResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_fax";
			Object[][] params = { 
					{ request.getIdFax(), Integer.class }, 
					{ request.getNoFaxVirtual(), String.class }, 
					{ request.getNoCorreoAsociado(), String.class }, 
					{ request.getUnCallerId(), Integer.class }, 
					{ request.getNoCallerId(), String.class }, 
					{ request.getPasswordFax(), String.class },
					{ request.getIdExtension(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
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
	public ListarFaxResponse listarFax(String ip, ListarFaxRequest request) throws Exception {
		ListarFaxResponse response = new ListarFaxResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_fax";
			Object[][] params = { { request.getIdFax(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_fax", "idFax");
			map.put("no_fax_virtual", "noFaxVirtual");
			map.put("no_correo_asociado", "noCorreoAsociado");
			map.put("un_caller_id", "unCallerId");
			map.put("no_caller_id", "noCallerId");
			map.put("password_fax", "passwordFax");
			map.put("id_extension", "idExtension");

			Response<Fax> responseA = BaseDao.baseData(storedProcedure, params, db.con, Fax.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<Fax>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarFaxResponse eliminarFax(String ip, EliminarFaxRequest request) throws Exception {
		EliminarFaxResponse response = new EliminarFaxResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_fax";
			Object[][] params = { { request.getIdFax(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
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
