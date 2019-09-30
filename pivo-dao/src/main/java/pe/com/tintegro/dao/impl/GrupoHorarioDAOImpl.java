package pe.com.tintegro.dao.impl;

import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.GrupoHorarioDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.GrupoHorario;
import pe.com.tintegro.dto.request.EditaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.EliminaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.InsertaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaPorIdGrupoHorarioRequest;
import pe.com.tintegro.dto.response.EditaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.EliminaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.InsertaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdGrupoHorarioResponse;

@Repository("grupoHorarioDAO")
public class GrupoHorarioDAOImpl implements GrupoHorarioDAO {

	@Override
	public InsertaGrupoHorarioResponse insertaGrupoHorario(String ip, InsertaGrupoHorarioRequest request) throws Exception {
		InsertaGrupoHorarioResponse response = new InsertaGrupoHorarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_grupo_horaio";
			Object[][] params = { { request.getNomGrupoHor(), String.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EditaGrupoHorarioResponse editaGrupoHorario(String ip, EditaGrupoHorarioRequest request) throws Exception {
		EditaGrupoHorarioResponse response = new EditaGrupoHorarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_grupo_horaio";
			Object[][] params = { { request.getIdGrupoHor(), Integer.class }, { request.getNomGrupoHor(), String.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminaGrupoHorarioResponse eliminaGrupoHorario(String ip, EliminaGrupoHorarioRequest request) throws Exception {
		EliminaGrupoHorarioResponse response = new EliminaGrupoHorarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_grupo_horaio";
			Object[][] params = { { request.getIdGrupoHor(), Integer.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListaGrupoHorarioResponse listaGrupoHorario(String ip, ListaHorariosLibresRequest request) throws Exception {
		ListaGrupoHorarioResponse response = new ListaGrupoHorarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_grupo_horario";
			Object[][] params = {};
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_grupo_hor", "idGrupoHor");
			map.put("no_gurpo_hor", "nomGrupoHor");
			Response<GrupoHorario> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, GrupoHorario.class, map);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaGrupoHorario(responseInteger.getData());
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListaPorIdGrupoHorarioResponse listaPorIdGrupoHorario(String ip, ListaPorIdGrupoHorarioRequest request) throws Exception {
		ListaPorIdGrupoHorarioResponse response = new ListaPorIdGrupoHorarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_grupo_horario_por_id_grupo_hor";
			Object[][] params = { { request.getIdGrupoHor(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_grupo_hor", "idGrupoHor");
			map.put("no_gurpo_hor", "nomGrupoHor");
			Response<GrupoHorario> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, GrupoHorario.class, map);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaPorIdGrupoHorario(responseInteger.getData());
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
