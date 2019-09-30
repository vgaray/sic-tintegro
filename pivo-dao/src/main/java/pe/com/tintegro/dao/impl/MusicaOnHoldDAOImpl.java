package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.MusicaOnHoldDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.MusicaOnHold;
import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;

@Repository("musicaOnHoldDAO")
public class MusicaOnHoldDAOImpl extends DAOTintegroImpl implements MusicaOnHoldDAO {

	@Override
	public ListarMusicaOnHoldResponse listarMusicaOnHold(String ip, ListarMusicaOnHoldRequest request) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ListarMusicaOnHoldResponse response = new ListarMusicaOnHoldResponse();
		try {
			String storedProcedureName = "asterisk.fn_listar_clase";
			Object[][] params = {};
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_clase", "idClase");
			mapColumnToAttributte.put("no_clase", "noClase");
			Response<MusicaOnHold> responseT = BaseDao.baseData(storedProcedureName, params, db.con, MusicaOnHold.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsMusicaOnHold((ArrayList<MusicaOnHold>) responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarMusicaOnHoldResponse insertarMusicaOnHold(String ip, InsertarMusicaOnHoldRequest request) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		InsertarMusicaOnHoldResponse response = new InsertarMusicaOnHoldResponse();
		try {
			String storedProcedureName = "asterisk.fn_insertar_musica";
			Object[][] params = { { request.getpNoClase(), String.class } };
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "idRasult");
			maps.put("mensaje", "mensaje");

			Response<InsertarMusicaOnHoldResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, InsertarMusicaOnHoldResponse.class, maps);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setIdRasult(responseT.getData().get(0).getIdRasult());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ActualizarMusicaOnHoldResponse actualizarMusicaOnHold(String ip, ActualizarMusicaOnHoldRequest request) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ActualizarMusicaOnHoldResponse response = new ActualizarMusicaOnHoldResponse();
		try {
			String storedProcedureName = "asterisk.fn_actualizar_musica";
			Object[][] params = { 
					{ request.getpIdClase(), Integer.class }, 
					{ request.getpNoClase(), String.class } };
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "idRasult");
			maps.put("mensaje", "mensaje");

			Response<ActualizarMusicaOnHoldResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, ActualizarMusicaOnHoldResponse.class, maps);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setIdRasult(responseT.getData().get(0).getIdRasult());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarMusicaOnHoldResponse eliminarMusicaOnHold(String ip, EliminarMusicaOnHoldRequest request) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		EliminarMusicaOnHoldResponse response = new EliminarMusicaOnHoldResponse();
		try {
			String storedProcedureName = "asterisk.fn_eliminar_musica";
			Object[][] params = { { request.getpIdClase(), Integer.class } };
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "idRasult");
			maps.put("mensaje", "mensaje");

			Response<EliminarMusicaOnHoldResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, EliminarMusicaOnHoldResponse.class, maps);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setIdRasult(responseT.getData().get(0).getIdRasult());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}