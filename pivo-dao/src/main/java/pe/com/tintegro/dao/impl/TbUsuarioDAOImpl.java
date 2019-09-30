package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.TbUsuarioDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.TbUsuario;
import pe.com.tintegro.dominio.LlamadaUsuario;
import pe.com.tintegro.dto.request.ActualizarUsuarioRequest;
import pe.com.tintegro.dto.request.BuscarTbUsuarioRequest;
import pe.com.tintegro.dto.request.EliminarUsuarioRequest;
import pe.com.tintegro.dto.request.FlagTbUsuarioRequest;
import pe.com.tintegro.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.dto.request.ListaLlamadaUsuarioRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioPaginadoRequest;
import pe.com.tintegro.dto.request.ListaTbUsuarioxNombreRequest;
import pe.com.tintegro.dto.request.ListarUsuarioxIdRequest;
import pe.com.tintegro.dto.response.ActualizarUsuarioResponse;
import pe.com.tintegro.dto.response.BuscarTbUsuarioResponse;
import pe.com.tintegro.dto.response.EliminarUsuarioResponse;
import pe.com.tintegro.dto.response.FlagUsuarioResponse;
import pe.com.tintegro.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.dto.response.ListaLlamadaUsuarioResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioPaginadoResponse;
import pe.com.tintegro.dto.response.ListaTbUsuarioResponse;
import pe.com.tintegro.dto.response.ListarTbUsuarioxNombreResponse;
import pe.com.tintegro.dto.response.ListarUsuarioResponse;
import pe.com.tintegro.dto.response.ListarUsuarioxIdResponse;

@Repository("tbUsuarioDAO")
public class TbUsuarioDAOImpl implements TbUsuarioDAO {

	public ListaTbUsuarioResponse listarTbUsuario(String ip) throws Exception {
		// TODO Auto-generated method stub
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		ListaTbUsuarioResponse response = new ListaTbUsuarioResponse();

		try { // Nombre del Stored Procedure
			String storedProcedureName = "asterisk.sp_sel_usuario_pin";
			// Lista de parametros
			Object[][] params = {};
			// Map que relaciona nombre de columna retornada con atributo a la
			// que corresponde
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			// mapColumnToAttributte.put( "CampoBD", "CampoProgra" );
			mapColumnToAttributte.put("id_usuari", "idUsuari");
			mapColumnToAttributte.put("nombre", "noNombre");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("il_fijloca", "ilfijloca");
			mapColumnToAttributte.put("il_fijnaci", "ilfijnaci");
			mapColumnToAttributte.put("il_fijinte", "ilfijinte");
			mapColumnToAttributte.put("il_celnaci", "ilcelnaci");
			mapColumnToAttributte.put("il_celinte", "ilcelinte");
			mapColumnToAttributte.put("il_celrpm", "ilcelrpm");

			Response<TbUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, TbUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setTbUsuarioList((ArrayList<TbUsuario>) responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}

		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarTbUsuarioxNombreResponse listarTbUsuarioxNombre(String ip, ListaTbUsuarioxNombreRequest request) throws Exception {
		// TODO Auto-generated method stub
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ListarTbUsuarioxNombreResponse response = new ListarTbUsuarioxNombreResponse();

		try { // Nombre del Stored Procedure
			String storedProcedureName = "asterisk.sp_sel_x_usuario_pin";
			// Lista de parametros
			Object[][] params = { { request.getNombreUsuario(), String.class } };
			// Map que relaciona nombre de columna retornada con atributo a la
			// que corresponde
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			// mapColumnToAttributte.put( "CampoBD", "CampoProgra" );
			mapColumnToAttributte.put("id_usuari", "idUsuari");
			mapColumnToAttributte.put("nombre", "noNombre");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("il_fijloca", "ilfijloca");
			mapColumnToAttributte.put("il_fijnaci", "ilfijnaci");
			mapColumnToAttributte.put("il_fijinte", "ilfijinte");
			mapColumnToAttributte.put("il_celloca", "ilcelloca");
			mapColumnToAttributte.put("il_celnaci", "ilcelnaci");
			mapColumnToAttributte.put("il_celinte", "ilcelinte");

			Response<TbUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, TbUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setTbUsuarioListxNombre((ArrayList<TbUsuario>) responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}

		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public FlagUsuarioResponse modificarFlagTbUsuario(String ip, FlagTbUsuarioRequest request) throws Exception {
		FlagUsuarioResponse response = new FlagUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = request.getEstado() == 1 ? "asterisk.sp_act_usuario_pin" : "asterisk.sp_desact_usuario_pin";
			Object[][] params = { { request.getIdUsupin(), Integer.class } };
			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);
			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setActivado(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public InsertarUsuarioResponse insertarUsuario(String ip, InsertarUsuarioRequest request) throws Exception {
		InsertarUsuarioResponse response = new InsertarUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedureName = " asterisk.sp_ins_usuario_pin";

			Object[][] params = { 
					{ request.getNoApepat(), String.class }, 
					{ request.getNoApemat(), String.class }, 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoPuesto(), String.class }, 
					{ request.getNuPin(), String.class }, 
					{ request.getTiLlamad(), Integer.class },
					{ request.getIdEmpare(), Integer.class }, 
					{ request.getIdSip(), Integer.class }, 
					{ request.getIlfijloca(), Integer.class }, 
					{ request.getIlfijnaci(), Integer.class }, 
					{ request.getIlfijinte(), Integer.class }, 
					{ request.getIlcelNac(), Integer.class },
					{ request.getIlcelInt(), Integer.class }, 
					{ request.getIlcelRpm(), Integer.class }, };
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
	public ActualizarUsuarioResponse ActualizarUsuario(String ip, ActualizarUsuarioRequest request) throws Exception {

		ActualizarUsuarioResponse response = new ActualizarUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedureName = "asterisk.sp_upd_usuario_pin";

			Object[][] params = { 
					{ request.getIdUsuario(), Integer.class }, 
					{ request.getNoApepat(), String.class }, 
					{ request.getNoApemat(), String.class }, 
					{ request.getNoNombre(), String.class }, 
					{ request.getNoPuesto(), String.class }, 
					{ request.getNuPin(), String.class },
					{ request.getTiLlamad(), Integer.class }, 
					{ request.getIdEmpare(), Integer.class }, 
					{ request.getIdSip(), Integer.class }, 
					{ request.getIlfijloca(), Integer.class }, 
					{ request.getIlfijnaci(), Integer.class }, 
					{ request.getIlfijinte(), Integer.class },
					{ request.getIlcelNac(), Integer.class }, 
					{ request.getIlcelInt(), Integer.class }, 
					{ request.getIlcelRpm(), Integer.class }, };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

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
	public ListarUsuarioxIdResponse ListarUsuarioxId(String ip, ListarUsuarioxIdRequest request) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ListarUsuarioxIdResponse response = new ListarUsuarioxIdResponse();
		try { // Nombre del Stored Procedure
			String storedProcedureName = "asterisk.sp_consulta_x_usuario_id";
			// Lista de parametros
			Object[][] params = { { request.getIdUsuario(), Integer.class } };
			// Map que relaciona nombre de columna retornada con atributo a la
			// que corresponde
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			// mapColumnToAttributte.put( "CampoBD", "CampoProgra" );

			mapColumnToAttributte.put("id_usuari", "idUsuari");
			mapColumnToAttributte.put("no_apepat", "noApepat");
			mapColumnToAttributte.put("no_apemat", "noApemat");
			mapColumnToAttributte.put("no_nombre", "noNombre");
			mapColumnToAttributte.put("no_puesto", "noPuesto");
			mapColumnToAttributte.put("nu_pin", "nuPin");
			mapColumnToAttributte.put("ti_llamad", "tiLlamad");
			mapColumnToAttributte.put("estado_ti_llamad", "estadoTiLlamad");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("id_empare", "idEmpare");
			mapColumnToAttributte.put("no_area", "nomArea");
			mapColumnToAttributte.put("id_area", "idArea");
			mapColumnToAttributte.put("no_centro_costo", "nomCentroCosto");
			mapColumnToAttributte.put("id_sip", "idSip");
			mapColumnToAttributte.put("il_fijloca", "ilfijloca");
			mapColumnToAttributte.put("il_fijnaci", "ilfijnaci");
			mapColumnToAttributte.put("il_fijinte", "ilfijinte");
			mapColumnToAttributte.put("il_celnaci", "ilcelnaci");
			mapColumnToAttributte.put("il_celinte", "ilcelinte");
			mapColumnToAttributte.put("il_celrpm", "ilcelrpm");
			Response<TbUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, TbUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setTbUsuarioListaxId((ArrayList<TbUsuario>) responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}

		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public EliminarUsuarioResponse EliminarUsuario(String ip, EliminarUsuarioRequest request) throws Exception {
		// TODO Auto-generated method stub
		EliminarUsuarioResponse response = new EliminarUsuarioResponse();

		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedureName = "asterisk.sp_delete_usuario_pin";

			Object[][] params = { { request.getIdUsuari(), Integer.class } };

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

	// Los usados para listar y hacer reportes
	// aqui
	@Override
	public ListaLlamadaUsuarioResponse ListaReporteLlamadaUsuario(String ip, ListaLlamadaUsuarioRequest request) throws Exception {

		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ListaLlamadaUsuarioResponse response = new ListaLlamadaUsuarioResponse();
		try {

			String storedProcedureName = "reportes.llamada_usuario_new";

			Object[][] params = { 
					{ request.getIdUsuario(), Integer.class }, 
					{ request.getIdExtension(), Integer.class }, 
					{ request.getFeIni(), String.class }, 
					{ request.getFeFin(), String.class }, 
					{ request.getpHorai(), String.class }, 
					{ request.getpHoraf(), String.class },
					{ request.getpIdOrden(), Integer.class }, 
					{ request.getpIdAreaCentro(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("no_usuari", "noUsuario");
			mapColumnToAttributte.put("fe_llamad", "feLlamada");
			mapColumnToAttributte.put("ho_llamad", "hoLlamada");
			mapColumnToAttributte.put("dst", "dst");
			mapColumnToAttributte.put("ca_duraci", "caDuraci");
			mapColumnToAttributte.put("ca_duracmin", "caDuracmin");
			mapColumnToAttributte.put("va_dispos", "vaDispos");
			mapColumnToAttributte.put("src", "src");
			Response<LlamadaUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadaUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadaUsuario(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	// aqui
	@Override
	public ListaLlamadaUsuarioResponse ListaLlamadaUsuario(String ip, ListaLlamadaUsuarioRequest request) throws Exception {
		ListaLlamadaUsuarioResponse response = new ListaLlamadaUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_usuario_report";

			Object[][] params = { 
					{ request.getIdUsuario(), Integer.class }, 
					{ request.getIdExtension(), Integer.class }, 
					{ request.getFeIni(), String.class }, 
					{ request.getFeFin(), String.class }, 
					{ request.getpHorai(), String.class }, 
					{ request.getpHoraf(), String.class },
					{ request.getNumPagina(), Integer.class }, 
					{ request.getCantidadxPag(), Integer.class }, 
					{ request.getpIdAreaCentro(), Integer.class }, 
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("no_usuari", "noUsuario");
			mapColumnToAttributte.put("fe_llamad", "feLlamada");
			mapColumnToAttributte.put("ho_llamad", "hoLlamada");
			mapColumnToAttributte.put("dst", "dst");
			mapColumnToAttributte.put("ca_duraci", "caDuraci");
			mapColumnToAttributte.put("ca_duracmin", "caDuracmin");
			mapColumnToAttributte.put("va_dispos", "vaDispos");
			mapColumnToAttributte.put("src", "src");
			mapColumnToAttributte.put("nu_total_reg", "total");

			Response<LlamadaUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadaUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadaUsuario(responseT.getData());
				for (int i = 0; i < response.getListaLlamadaUsuario().size(); i++) {
					response.getListaLlamadaUsuario().get(i).setIndice(i + 1);
				}
			}
			response.setEstado(responseT.getCodigo());

		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListaTbUsuarioPaginadoResponse listaTbUsuarioPaginado(String ip, ListaTbUsuarioPaginadoRequest request) throws Exception {
		// TODO Auto-generated method stub
		ListaTbUsuarioPaginadoResponse response = new ListaTbUsuarioPaginadoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.sp_sel_usuario_pin_con_paginado";
			Object[][] params = { 
					{ request.getNumpagina(), Integer.class }, 
					{ request.getNumRegisMostrar(), Integer.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			mapColumnToAttributte.put("id_usuari", "idUsuari");
			mapColumnToAttributte.put("nombre", "noNombre");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("il_fijloca", "ilfijloca");
			mapColumnToAttributte.put("il_fijnaci", "ilfijnaci");
			mapColumnToAttributte.put("il_fijinte", "ilfijinte");
			mapColumnToAttributte.put("il_celnaci", "ilcelnaci");
			mapColumnToAttributte.put("il_celinte", "ilcelinte");
			mapColumnToAttributte.put("il_celrpm", "ilcelrpm");
			mapColumnToAttributte.put("nu_total_reg", "numTotalReg");

			Response<TbUsuario> responseT = BaseDao.baseData(storedProcedureName, params, db.con, TbUsuario.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setTbUsuarioList(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public BuscarTbUsuarioResponse buscarTbUsuario(String ip, BuscarTbUsuarioRequest request) throws Exception {
		BuscarTbUsuarioResponse response = new BuscarTbUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_buscar_usuario";
			Object[][] params = { { request.getNoNombre(), String.class }, };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_usuari", "idUsuari");
			mapColumnToAttributte.put("no_usuario", "noNombre");
			mapColumnToAttributte.put("il_activo", "ilActivo");
			mapColumnToAttributte.put("il_fijloca", "ilfijloca");
			mapColumnToAttributte.put("il_fijnaci", "ilfijnaci");
			mapColumnToAttributte.put("il_fijinte", "ilfijinte");
			mapColumnToAttributte.put("il_celnaci", "ilcelnaci");
			mapColumnToAttributte.put("il_celinte", "ilcelinte");
			mapColumnToAttributte.put("il_celrpm", "ilcelrpm");

			Response<TbUsuario> responseObj = BaseDao.baseData(storedProcedureName, params, db.con, TbUsuario.class, mapColumnToAttributte);
			if (responseObj.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseObj.getException();
			} else {
				response.setEstado(Constantes.ESTADO_TRAMA_OK);
				response.setMensaje(Constantes.MSG_EXECUTE_COMMAND_SUCCESS);
				response.setLsUsuario(responseObj.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public ListarUsuarioResponse listaUsuario(String ip) throws Exception {
		ListarUsuarioResponse response = new ListarUsuarioResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);

		try {
			String storedProcedure = "asterisk.fn_listar_usuario";
			Object[][] params = {};
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_usuari", "idUsuari");
			map.put("no_nombre", "noNombre");
			map.put("no_apepat", "noApepat");
			map.put("no_apemat", "noApemat");
			map.put("nu_pin", "nuPin");
			map.put("no_centro_costo", "nomCentroCosto");
			map.put("no_area", "nomArea");
			map.put("no_puesto", "noPuesto");

			Response<TbUsuario> responseA = BaseDao.baseData(storedProcedure, params, db.con, TbUsuario.class, map);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaUsuario((ArrayList<TbUsuario>) responseA.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}
}
