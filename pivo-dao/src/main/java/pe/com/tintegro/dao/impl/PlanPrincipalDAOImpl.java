package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.PlanPrincipalDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.PlanPrincipal;
import pe.com.tintegro.dto.request.ActualizarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.EliminarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.InsertarPlanPrincipalRequest;
import pe.com.tintegro.dto.request.ListarContextoPorPlanRequest;
import pe.com.tintegro.dto.request.ListarPlanPrincipalRequest;
import pe.com.tintegro.dto.response.ActualizarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.EliminarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.InsertarPlanPrincipalResponse;
import pe.com.tintegro.dto.response.ListarContextoPorPlanResponse;
import pe.com.tintegro.dto.response.ListarPlanPrincipalResponse;

@Repository("planPrincipalDAO")
public class PlanPrincipalDAOImpl implements PlanPrincipalDAO {

	@Override
	public ListarPlanPrincipalResponse listarPlanPrincipal(String ip, ListarPlanPrincipalRequest request) throws Exception {
		ListarPlanPrincipalResponse response = new ListarPlanPrincipalResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_plan_marc_principal";
			Object[][] params = { { request.getIdPlanPrincipal(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_plan_entrante", "idPlanPrincipal");
			map.put("no_nombre", "noNombre");
			map.put("no_descripcion", "noDescripcion");

			Response<PlanPrincipal> responseA = BaseDao.baseData(storedProcedure, params, db.con, PlanPrincipal.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<PlanPrincipal>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarContextoPorPlanResponse listarContextoPorPlan(String ip, ListarContextoPorPlanRequest request) throws Exception {
		ListarContextoPorPlanResponse response = new ListarContextoPorPlanResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_contexto_por_plan_marcacion";
			Object[][] params = { { request.getIdPlanPrincipal(), Integer.class } };

			Response<String> responseA = BaseDao.baseData(storedProcedure, params, db.con, String.class, null);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				List<String> listado = new ArrayList<String>();
				for (String salientes : (ArrayList<String>) responseA.getData()) {
					if (salientes.contains("_2")) {
						listado.add(salientes);
					}
				}
				response.setListado(listado);
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarPlanPrincipalResponse insertarPlanPrincipal(String ip, InsertarPlanPrincipalRequest request) throws Exception {
		InsertarPlanPrincipalResponse response = new InsertarPlanPrincipalResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_plan_marc_principal";
			Object[][] params = { 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoDescripcion(), String.class }, 
					{ request.getContexto(), String.class } };

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
	public ActualizarPlanPrincipalResponse actualizarPlanPrincipal(String ip, ActualizarPlanPrincipalRequest request) throws Exception {
		ActualizarPlanPrincipalResponse response = new ActualizarPlanPrincipalResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_plan_marc_principal";
			Object[][] params = { 
					{ request.getIdPlanPrincipal(), Integer.class }, 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoDescripcion(), String.class }, 
					{ request.getContexto(), String.class } };

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
	public EliminarPlanPrincipalResponse eliminarPlanPrincipal(String ip, EliminarPlanPrincipalRequest request) throws Exception {
		EliminarPlanPrincipalResponse response = new EliminarPlanPrincipalResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_plan_marc_principal";
			Object[][] params = { { request.getIdPlanPrincipal(), Integer.class } };

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
