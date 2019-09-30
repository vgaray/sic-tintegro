package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.IvrOpcionDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.IvrOpcion;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;

@Repository("ivrOpcionDAO")
public class IvrOpcionDAOImpl implements IvrOpcionDAO {
	@Override
	public InsertarIvrOpcionResponse insertarIvrResponse(String ipUser, InsertarIvrOpcionRequest request) throws Exception {
		InsertarIvrOpcionResponse response = new InsertarIvrOpcionResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_insertar_ivr_opcion";
			Object[][] params = { 
					{ request.getpIdPadre(), Integer.class }, 
					{ request.getpNoDescripcion(), String.class }, 
					{ request.getpNoAudio(), String.class }, 
					{ request.getpNuAnexo(), String.class }, 
					{ request.getpIdtipo(), Integer.class }, 
					{ request.getpNoValor(), String.class },
					{ request.getpNoNombre(), String.class }, 
					{ request.getpIdGrupo(), Integer.class }, 
					{ request.getpNoAnexoTiempo(), String.class }, 
					{ request.getpVuelveInicioTiempo(), Integer.class }, 
					{ request.getpVuelveInicioIncorrecto(), Integer.class },
					{ request.getpNoAnexoIncorrecto(), String.class }, 
					{ request.getpMarcaAnexo(), Integer.class }, 
					{ request.getpOperadora(), Integer.class }, 
					{ request.getpTiempoEspera(), Integer.class }, 
					{ request.isIlDisponible(), Boolean.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensaje");
			mapColumnToAttributte.put("id", "id");

			Response<InsertarIvrOpcionResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, InsertarIvrOpcionResponse.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje(responseT.getData().get(0).getMensaje());
				response.setIdResult(responseT.getData().get(0).getIdResult());
				response.setId(responseT.getData().get(0).getId());
			}
			response.setIdResult(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	public CRUDResponse eliminarIvrResponse(String ipUser, EliminarIvrOpcionRequest request) throws Exception {
		CRUDResponse response = new CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_eliminar_ivr_opcion";
			Object[][] params = { { request.getpIdIvrCop(), Integer.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensaje");

			Response<CRUDResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setIdResult(responseT.getData().indexOf(0));
			}
			response.setIdResult(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	public CRUDResponse editarIvrResponse(String ipUser, EditarIvrOpcionRequest request) throws Exception {
		CRUDResponse response = new CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_actualizar_ivr_opcion";
			Object[][] params = { 
					{ request.getpIdIvrCop(), Integer.class }, 
					{ request.getpIdPadre(), Integer.class }, 
					{ request.getpNoDescripcion(), String.class }, 
					{ request.getpNoAudio(), String.class }, 
					{ request.getpNuAnexo(), String.class }, 
					{ request.getpIdtipo(), Integer.class },
					{ request.getpNoValor(), String.class }, 
					{ request.getpNoNombre(), String.class }, 
					{ request.getpIdGrupo(), Integer.class }, 
					{ request.getpNoAnexoTiempo(), String.class }, 
					{ request.getpVuelveInicioTiempo(), Integer.class },
					{ request.getpVuelveInicioIncorrecto(), Integer.class }, 
					{ request.getpNoAnexoIncorrecto(), String.class }, 
					{ request.getpMarcaAnexo(), Integer.class }, 
					{ request.getpOperadora(), Integer.class }, 
					{ request.getpTiempoEspera(), Integer.class },
					{ request.isIlDisponible(), Boolean.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_rasult", "idResult");
			mapColumnToAttributte.put("mensaje", "mensaje");

			Response<CRUDResponse> responseT = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setIdResult(responseT.getData().indexOf(0));
			}
			response.setIdResult(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	public ListarIvrOpcionResponse listarIvrResponse(String ipUser, ListarIvrOpcionRequest request) throws Exception {
		ListarIvrOpcionResponse response = new ListarIvrOpcionResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_list_ivr_opcion";
			Object[][] params = {};
			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("id_ivr_cop", "idIvrCop");
			mapCol.put("id_padre", "pIdPadre");
			mapCol.put("no_descripcion", "pNoDescripcion");
			mapCol.put("no_audio", "pNoAudio");
			mapCol.put("nu_anexo", "pNuAnexo");
			mapCol.put("id_tipo", "pIdtipo");
			mapCol.put("no_valor", "pNoValor");
			mapCol.put("no_nombre", "pNoNombre");
			mapCol.put("id_grupo", "pIdGrupo");
			mapCol.put("no_anexo_tiempo", "pNoAnexoTiempo");
			mapCol.put("vuelve_inicio_tiempo", "pVuelveInicioTiempo");
			mapCol.put("vuelve_inicio_incorrecto", "pVuelveInicioIncorrecto");
			mapCol.put("no_anexo_incorrecto", "pNoAnexoIncorrecto");
			mapCol.put("marca_anexo", "pMarcaAnexo");
			mapCol.put("operadora", "pOperadora");
			mapCol.put("tiempo_espera", "pTiempoEspera");
			mapCol.put("ilDisponibilidad", "il_disponibilidad");

			Response<IvrOpcion> responseT = BaseDao.baseData(storedProcedureName, params, db.con, IvrOpcion.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				for (int i = 0; i < responseT.getData().size(); i++) {
					responseT.getData().get(i).setId(responseT.getData().get(i).getIdIvrCop());
					responseT.getData().get(i).setParent(responseT.getData().get(i).getpIdPadre());
					responseT.getData().get(i).setText(responseT.getData().get(i).getpNoNombre());
					if (responseT.getData().get(i).getpIdtipo() == 2) {
						responseT.getData().get(i).setType("anexo");
					}
					if (responseT.getData().get(i).getpIdtipo() == 1) {
						responseT.getData().get(i).setType("ivr");
					}
					if (responseT.getData().get(i).getpIdtipo() == 3) {
						responseT.getData().get(i).setType("ivrref");
					}
				}
				response.setListaIvrOpcion(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public CRUDResponse buscarIVRPorNombre(String ipUser, String indicioNombreIVR) throws Exception {
		CRUDResponse response = new CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try{
			String storedProcedureName = "asterisk.fn_buscar_opcion_ivr";
			Object[][] params = { { indicioNombreIVR, String.class } };
	
			Map<String, String> mapColumnToAttribute = new HashMap<String, String>();
			mapColumnToAttribute.put("id_rasult", "idResult");
			mapColumnToAttribute.put("mensaje", "mensajeValidacion");
	
			Response<CRUDResponse> responseDAO = BaseDao.baseData(storedProcedureName, params, db.con, CRUDResponse.class, mapColumnToAttribute);
			if (responseDAO.getCodigo() == Constantes.ESTADO_TRAMA_OK) {
				response = responseDAO.getData().get(0);
			} else {
				throw responseDAO.getException();
			}
		} finally {
			db.cerrar();
		}
		return response;
	}
}