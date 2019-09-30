package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.GrupoDirectorioDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.EntradaDirectorio;
import pe.com.tintegro.dominio.GrupoDirectorio;
import pe.com.tintegro.dto.request.ActualizarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ActualizarGrupoDirectRequest;
import pe.com.tintegro.dto.request.EliminarEntradaDirectRequest;
import pe.com.tintegro.dto.request.EliminarGrupoDirectRequest;
import pe.com.tintegro.dto.request.InsertarEntradaDirectRequest;
import pe.com.tintegro.dto.request.InsertarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ListarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ValidarDirectorioRequest;
import pe.com.tintegro.dto.response.ActualizarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ActualizarGrupoDirectResponse;
import pe.com.tintegro.dto.response.EliminarEntradaDirectResponse;
import pe.com.tintegro.dto.response.EliminarGrupoDirectResponse;
import pe.com.tintegro.dto.response.InsertarEntradaDirectResponse;
import pe.com.tintegro.dto.response.InsertarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ListarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ValidarDirectorioResponse;

@Repository("grupoDirectorioDAO")
public class GrupoDirectorioDAOImpl implements GrupoDirectorioDAO {
	@Override
	public ListarGrupoDirectResponse listarGrupoDirectorio(String ip, ListarGrupoDirectRequest request) throws Exception {
		ListarGrupoDirectResponse response = new ListarGrupoDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_grupo_directorio";
			Object[][] params = { { request.getIdGrupo(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_grupo", "idGrupo");
			map.put("no_nombre", "noNombre");

			Response<GrupoDirectorio> responseA = BaseDao.baseData(storedProcedure, params, db.con, GrupoDirectorio.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<GrupoDirectorio>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarGrupoDirectResponse insertarGrupoDirectorio(String ip, InsertarGrupoDirectRequest request) throws Exception {
		InsertarGrupoDirectResponse response = new InsertarGrupoDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_grupo_directorio";
			Object[][] params = { { request.getNoNombre(), String.class } };
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
	public ActualizarGrupoDirectResponse actualizarGrupoDirectorio(String ip, ActualizarGrupoDirectRequest request) throws Exception {
		ActualizarGrupoDirectResponse response = new ActualizarGrupoDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_grupo_directorio";
			Object[][] params = { 
					{ request.getIdGrupo(), Integer.class }, 
					{ request.getNoNombre(), String.class } };

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
	public EliminarGrupoDirectResponse eliminarGrupoDirectorio(String ip, EliminarGrupoDirectRequest request) throws Exception {
		EliminarGrupoDirectResponse response = new EliminarGrupoDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_grupo_directorio";
			Object[][] params = { { request.getIdGrupo(), Integer.class } };
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

	@Override
	public ListarEntradaDirectResponse listarEntradaDirectorio(String ip, ListarEntradaDirectRequest request) throws Exception {
		ListarEntradaDirectResponse response = new ListarEntradaDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_entrada_grupo";
			Object[][] params = { 
					{ request.getIdEntrada(), Integer.class }, 
					{ request.getIdGrupo(), Integer.class }, 
					{ request.getpOpcion(), Integer.class } };
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_entrada", "idEntrada");
			map.put("nu_telefonico", "nuTelefonico");
			map.put("nu_anexo", "nuAnexo");
			map.put("no_nombre", "noNombre");
			map.put("no_prefijo", "noPrefijo");
			map.put("id_grupo", "idGrupo");
			map.put("no_descripcion", "noDescripcion");

			Response<EntradaDirectorio> responseA = BaseDao.baseData(storedProcedure, params, db.con, EntradaDirectorio.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListado((ArrayList<EntradaDirectorio>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarEntradaDirectResponse insertarEntradaDirectorio(String ip, InsertarEntradaDirectRequest request) throws Exception {
		InsertarEntradaDirectResponse response = new InsertarEntradaDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_entrada_grupo";
			Object[][] params = { 
					{ request.getNuTelefonico(), Integer.class }, 
					{ request.getNuAnexo(), String.class }, 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoPrefijo(), String.class }, 
					{ request.getIdGrupo(), Integer.class }, 
					{ request.getNoDescripcion(), String.class } };

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
	public ActualizarEntradaDirectResponse actualizarEntradaDirectorio(String ip, ActualizarEntradaDirectRequest request) throws Exception {
		ActualizarEntradaDirectResponse response = new ActualizarEntradaDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_entrada_grupo";
			Object[][] params = { 
					{ request.getIdEntrada(), Integer.class }, 
					{ request.getNuTelefonico(), Integer.class }, 
					{ request.getNuAnexo(), String.class }, 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoPrefijo(), String.class }, 
					{ request.getIdGrupo(), Integer.class },
					{ request.getNoDescripcion(), String.class } };

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
	public EliminarEntradaDirectResponse eliminarEntradaDirectorio(String ip, EliminarEntradaDirectRequest request) throws Exception {
		EliminarEntradaDirectResponse response = new EliminarEntradaDirectResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_entrada_grupo";
			Object[][] params = { { request.getIdEntrada(), Integer.class } };
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

	@Override
	public ValidarDirectorioResponse validarGrupoDirectorio(String ip, ValidarDirectorioRequest request) throws Exception {
		ValidarDirectorioResponse response = new ValidarDirectorioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_validar_directorio";
			Object[][] params = { { request.getNoNombre(), String.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje("OK");
				response.setExiste(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ValidarDirectorioResponse validarEntradaDirectorio(String ip, ValidarDirectorioRequest request) throws Exception {
		ValidarDirectorioResponse response = new ValidarDirectorioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_validar_entrada_directorio";
			Object[][] params = { 
					{ request.getNoNombre(), String.class }, 
					{ request.getIdGrupo(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje("OK");
				response.setExiste(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
