package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.HorarioDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Horario;
import pe.com.tintegro.dominio.Item;
import pe.com.tintegro.dto.request.EditaHorarioRequest;
import pe.com.tintegro.dto.request.EliminaHorarioRequest;
import pe.com.tintegro.dto.request.InsertaHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaHorarioRequest;
import pe.com.tintegro.dto.request.ListaPorIdHorarioRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.EditaHorarioResponse;
import pe.com.tintegro.dto.response.EliminaHorarioResponse;
import pe.com.tintegro.dto.response.InsertaHorarioResponse;
import pe.com.tintegro.dto.response.ListaHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdHorarioResponse;

@Repository("horarioDAO")
public class HorarioDAOImpl implements HorarioDAO {

	@Override
	public InsertaHorarioResponse insertaHorario(String ip, InsertaHorarioRequest request) throws Exception {
		InsertaHorarioResponse response = new InsertaHorarioResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_detalle_horaio";
			Object[][] params = { 
					{ request.getIdGrupoHor(), Integer.class }, 
					{ request.getHoInicio(), String.class }, 
					{ request.getHoFin(), String.class }, 
					{ request.getNomDiaSemanaInicio(), String.class }, 
					{ request.getNomDiaSemanaFin(), String.class },
					{ request.getNomDiaMesInicio(), String.class }, 
					{ request.getNomDiaMesFin(), String.class }, 
					{ request.getNomMesInicio(), String.class }, 
					{ request.getNomMesFin(), String.class }, 
					{ request.getTiHorario(), Integer.class }, 
					{ request.getNomAudio(), String.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id_rasult", "idResult");
			mapCol.put("mensaje", "mensajeValidacion");
			Response<CRUDResponse> responseT = BaseDao.baseData(storedProcedure, params, pg.con, CRUDResponse.class, mapCol);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public EditaHorarioResponse editaHorario(String ip, EditaHorarioRequest request) throws Exception {
		EditaHorarioResponse response = new EditaHorarioResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_detalle_horaio";
			Object[][] params = { 
					{ request.getIdHorario(), Integer.class }, 
					{ request.getIdGrupoHor(), Integer.class }, 
					{ request.getHoInicio(), String.class }, 
					{ request.getHoFin(), String.class }, 
					{ request.getNomDiaSemanaInicio(), String.class }, 
					{ request.getNomDiaSemanaFin(), String.class },
					{ request.getNomDiaMesInicio(), String.class }, 
					{ request.getNomDiaMesFin(), String.class }, 
					{ request.getNomMesInicio(), String.class }, 
					{ request.getNomMesFin(), String.class }, 
					{ request.getTiHorario(), Integer.class }, 
					{ request.getNomAudio(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, pg.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public EliminaHorarioResponse eliminaHorario(String ip, EliminaHorarioRequest request) throws Exception {
		EliminaHorarioResponse response = new EliminaHorarioResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_detalle_horaio";
			Object[][] params = { { request.getIdHorario(), Integer.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, pg.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public ListaHorarioResponse listaHorario(String ip, ListaHorarioRequest request) throws Exception {
		ListaHorarioResponse response = new ListaHorarioResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_horario";
			Object[][] params = { { request.getIdGrupoHor(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_horario", "idHorario");
			map.put("id_grupo_hor", "idGrupoHorario");
			map.put("ho_inicio", "hoInicio");
			map.put("ho_fin", "hoFin");
			map.put("no_dia_semana_inicio", "nomDiaSemanaInicio");
			map.put("no_dia_semana_fin", "nomDiaSemanaFin");
			map.put("no_dia_mes_inicio", "nomDiaMesInicio");
			map.put("no_dia_mes_fin", "nomDiaMesFin");
			map.put("no_mes_inicio", "nomMesInicio");
			map.put("no_mes_fin", "nomMesFin");
			map.put("ti_horario", "tipoHorario");
			map.put("no_audio", "nomAudio");

			Response<Horario> responseInteger = BaseDao.baseData(storedProcedure, params, pg.con, Horario.class, map);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaHorario(responseInteger.getData());
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public ListaPorIdHorarioResponse listaPorIdHorario(String ip, ListaPorIdHorarioRequest request) throws Exception {
		ListaPorIdHorarioResponse response = new ListaPorIdHorarioResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_horario_por_id_horario";
			Object[][] params = { { request.getIdHorario(), Integer.class } };

			Map<String, String> map = new HashMap<String, String>();
			map.put("id_horario", "idHorario");
			map.put("id_grupo_hor", "IdGrupoHorario");
			map.put("ho_inicio", "hoInicio");
			map.put("ho_fin", "hoFin");
			map.put("no_dia_semana_inicio", "nomDiaSemanaInicio");
			map.put("no_dia_semana_fin", "nomDiaSemanaFin");
			map.put("no_dia_mes_inicio", "nomDiaMesInicio");
			map.put("no_dia_mes_fin", "nomDiaMesFin");
			map.put("no_mes_inicio", "nomMesInicio");
			map.put("no_mes_fin", "nomMesFin");
			map.put("ti_horario", "tipoHorario");
			map.put("no_audio", "nomAudio");

			Response<Horario> responseInteger = BaseDao.baseData(storedProcedure, params, pg.con, Horario.class, map);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaPorIdHorario(responseInteger.getData());

			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public List<Item> listarHorariosLibres(String ip, ListaHorariosLibresRequest request) throws Exception {
		List<Item> lsItems = new ArrayList<Item>();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_lista_grupos_no_asignados_a_ivr";
			Object[][] params = { { request.getIdIvrOpcion(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_grupo_hor", "id");
			map.put("no_gurpo_hor", "value");
			Response<Item> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Item.class, map);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				lsItems = responseInteger.getData();
			}
		} finally {
			db.cerrar();
		}
		return lsItems;
	}
}
