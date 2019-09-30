package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.RingGroupDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.RingGroup;
import pe.com.tintegro.dto.request.ActualizarRingGroupRequest;
import pe.com.tintegro.dto.request.EliminarRingGroupRequest;
import pe.com.tintegro.dto.request.InsertarRingGroupRequest;
import pe.com.tintegro.dto.request.ListaRingGroupRequest;
import pe.com.tintegro.dto.request.ListarRingGroupxAnexoRequest;
import pe.com.tintegro.dto.request.ListarVerificacionRingGroupRequest;
import pe.com.tintegro.dto.response.ActualizarRingGroupResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.EliminarRingGroupResponse;
import pe.com.tintegro.dto.response.InsertarRingGroupResponse;
import pe.com.tintegro.dto.response.ListaRingGroupResponse;
import pe.com.tintegro.dto.response.ListarRingGroupxAnexoResponse;
import pe.com.tintegro.dto.response.ListarVerificacionRingGroupResponse;

@Repository("ringGroupDAO")
public class RingGroupDAOImpl implements RingGroupDAO {
	@Override
	public ListaRingGroupResponse listaRingGroupDAO(String ip, ListaRingGroupRequest request) throws Exception {
		ListaRingGroupResponse response = new ListaRingGroupResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_listar_ring_group";
			Object[][] params = { { request.getIdGrupo(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rupo", "idGrupo");
			mapColumnToAttributte.put("no_grupo", "noGrupo");
			mapColumnToAttributte.put("nu_grupo", "nuGrupo");
			mapColumnToAttributte.put("nu_anexos", "nuAnexos");
			mapColumnToAttributte.put("cantidad_anexo", "cantidadAnexo");

			Response<RingGroup> responseT = BaseDao.baseData(storedProcedureName, params, db.con, RingGroup.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListRingGroup(responseT.getData());
				for (int i = 0; i < response.getListRingGroup().size(); i++) {
					response.getListRingGroup().get(i).setIndice(i + 1);
				}
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarRingGroupResponse insertarRingGroupDAO(String ip, InsertarRingGroupRequest request) throws Exception {
		InsertarRingGroupResponse response = new InsertarRingGroupResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_insertar_ring_group";
			// request.setIdSip(listaidSip(request.getIdSips()));
			Object[][] params = { 
					{ request.getNoGrupo(), String.class }, 
					{ request.getNuGrupo(), Integer.class }, 
					{ request.getNuSipL(), String.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensajeValidacion");

			Response<CRUDResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ActualizarRingGroupResponse actualizarRingGroupDAO(String ip, ActualizarRingGroupRequest request) throws Exception {
		ActualizarRingGroupResponse response = new ActualizarRingGroupResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_actualizar_ring_group";
			Object[][] params = { 
					{ request.getIdGrupo(), Integer.class }, 
					{ request.getNoGrupo(), String.class }, 
					{ request.getNuGrupo(), Integer.class }, 
					{ request.getIlActivo(), Boolean.class }, 
					{ request.getIdSip(), String.class } };

			Response<Integer> responseT = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setIdRasultEstado(responseT.getData().get(0));
				response.setMensaje(MensajeError.OK);
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarRingGroupResponse eliminarRingGroupDAO(String ip, EliminarRingGroupRequest request) throws Exception {
		EliminarRingGroupResponse response = new EliminarRingGroupResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_eliminar_ring_group";
			// request.setIdSip(listaidSip(request.getIdSips()));
			Object[][] params = { { request.getpIdGrupo(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensajeValidacion");

			Response<CRUDResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarVerificacionRingGroupResponse verificacionRingGroupDAO(String ip, ListarVerificacionRingGroupRequest request) throws Exception {
		ListarVerificacionRingGroupResponse response = new ListarVerificacionRingGroupResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_verificar_ring_group";
			Object[][] params = { 
					{ request.getpNoGrupo(), String.class }, 
					{ request.getpNuGrupo(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rasult", "idRasult");
			mapColumnToAttributte.put("mensaje", "mensaje");

			Response<RingGroup> responseT = BaseDao.baseData(storedProcedureName, params, db.con, RingGroup.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListRingGroup(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarRingGroupxAnexoResponse filtroRingGroupDAO(String ip, ListarRingGroupxAnexoRequest request) throws Exception {
		ListarRingGroupxAnexoResponse response = new ListarRingGroupxAnexoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_filtrar_ring_group_anexo";
			Object[][] params = { { request.getpAnexos(), String.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rupo", "idGrupo");
			mapColumnToAttributte.put("no_grupo", "noGrupo");
			mapColumnToAttributte.put("nu_grupo", "nuGrupo");
			mapColumnToAttributte.put("nu_anexos", "nuAnexos");
			mapColumnToAttributte.put("cantidad_anexo", "cantidadAnexo");

			Response<RingGroup> responseT = BaseDao.baseData(storedProcedureName, params, db.con, RingGroup.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListRingGroup(responseT.getData());

				for (int i = 0; i < response.getListRingGroup().size(); i++) {
					response.getListRingGroup().get(i).setIndice(i + 1);
				}
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
			db.cerrar();
		}
		return response;
	}
}
