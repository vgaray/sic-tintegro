package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.PlanSalienteDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.PlanSaliente;
import pe.com.tintegro.dto.request.ActualizarPlanSalienteRequest;
import pe.com.tintegro.dto.request.EliminarPlanSalienteRequest;
import pe.com.tintegro.dto.request.InsertarPlanSalienteRequest;
import pe.com.tintegro.dto.request.ListarPlanSalienteRequest;
import pe.com.tintegro.dto.response.ActualizarPlanSalienteResponse;
import pe.com.tintegro.dto.response.EliminarPlanSalienteResponse;
import pe.com.tintegro.dto.response.InsertarPlanSalienteResponse;
import pe.com.tintegro.dto.response.ListarPlanSalienteResponse;

@Repository("planSalienteDAO")
public class PlanSalienteDAOImpl implements PlanSalienteDAO {

	@Override
	public ListarPlanSalienteResponse listarPlanSaliente(String ip, ListarPlanSalienteRequest requet) throws Exception {
		ListarPlanSalienteResponse response = new ListarPlanSalienteResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_plan_marc_saliente";
			Object[][] params = { { requet.getIdPlanSaliente(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_plan_saliente", "idPlanSaliente");
			map.put("no_nombre", "noNombre");
			map.put("il_lista_negra", "ilListaNegra");
			map.put("il_clave_usuario", "ilClaveUsuario");
			map.put("il_temporizado", "iltemporizado");
			map.put("il_horario_llamada", "ilHorarioLlamada");
			map.put("ho_temporizado", "hoTemporizado");
			map.put("fe_inicio", "feInicio");
			map.put("fe_fin", "feFin");
			map.put("ho_inicio", "hoInicio");
			map.put("ho_fin", "hoFin");
			map.put("no_prefijo", "noPrefijo");
			map.put("no_patron", "noPatron");
			map.put("nu_quitar_prefijo", "nuQuitarPrefijo");
			map.put("nu_quitar_sufijo", "nuQuitarSufijo");
			map.put("no_sufijo", "noSufijo");
			map.put("no_troncal", "noTroncal");
			map.put("no_descripcion", "noDescripcion");
			map.put("nu_tipo", "nuTipo");
			map.put("id_troncal", "idTroncal");

			Response<PlanSaliente> responseA = BaseDao.baseData(storedProcedure, params, db.con, PlanSaliente.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<PlanSaliente>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarPlanSalienteResponse insertarPlanSaliente(String ip, InsertarPlanSalienteRequest requet) throws Exception {
		InsertarPlanSalienteResponse response = new InsertarPlanSalienteResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_plan_marc_saliente";
			Object[][] params = { 
					{ requet.getNoNombre(), String.class }, 
					{ requet.getIlListaNegra(), Integer.class }, 
					{ requet.getIlClaveUsuario(), Integer.class }, 
					{ requet.getIltemporizado(), Integer.class }, 
					{ requet.getIlHorarioLlamada(), Integer.class },
					{ requet.getHoTemporizado(), Integer.class }, 
					{ requet.getFeInicio(), String.class }, 
					{ requet.getFeFin(), String.class }, 
					{ requet.getHoInicio(), String.class }, 
					{ requet.getHoFin(), String.class }, 
					{ requet.getNoPrefijo(), String.class },
					{ requet.getNoPatron(), String.class }, 
					{ requet.getNuQuitarPrefijo(), Integer.class }, 
					{ requet.getNuQuitarSufijo(), Integer.class }, 
					{ requet.getNoSufijo(), String.class }, 
					{ requet.getNoTroncal(), String.class }, 
					{ requet.getNoDescripcion(), String.class },
					{ requet.getNuTipo(), Integer.class } };

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
	public ActualizarPlanSalienteResponse actualizarPlanSaliente(String ip, ActualizarPlanSalienteRequest requet) throws Exception {
		ActualizarPlanSalienteResponse response = new ActualizarPlanSalienteResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_plan_marc_saliente";
			Object[][] params = { 
					{ requet.getIdPlanSaliente(), Integer.class }, 
					{ requet.getNoNombre(), String.class }, 
					{ requet.getIlListaNegra(), Integer.class }, 
					{ requet.getIlClaveUsuario(), Integer.class }, 
					{ requet.getIltemporizado(), Integer.class },
					{ requet.getIlHorarioLlamada(), Integer.class }, 
					{ requet.getHoTemporizado(), Integer.class }, 
					{ requet.getFeInicio(), String.class }, 
					{ requet.getFeFin(), String.class }, 
					{ requet.getHoInicio(), String.class }, 
					{ requet.getHoFin(), String.class },
					{ requet.getNoPrefijo(), String.class }, 
					{ requet.getNoPatron(), String.class }, 
					{ requet.getNuQuitarPrefijo(), Integer.class }, 
					{ requet.getNuQuitarSufijo(), Integer.class }, 
					{ requet.getNoSufijo(), String.class }, 
					{ requet.getNoTroncal(), String.class },
					{ requet.getNoDescripcion(), String.class }, 
					{ requet.getNuTipo(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedure, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setActualizado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarPlanSalienteResponse eliminarPlanSaliente(String ip, EliminarPlanSalienteRequest request) throws Exception {
		EliminarPlanSalienteResponse response = new EliminarPlanSalienteResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_plan_marc_saliente";
			Object[][] params = { { request.getIdPlanSaliente(), Integer.class } };

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