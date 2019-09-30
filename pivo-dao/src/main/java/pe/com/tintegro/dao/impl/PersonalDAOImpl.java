package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.PersonalDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Personal;
import pe.com.tintegro.dto.request.ActualizarPersonalRequest;
import pe.com.tintegro.dto.request.EliminarPersonalRequest;
import pe.com.tintegro.dto.request.ListarPersonalRequest;
import pe.com.tintegro.dto.request.RegistrarPersonalRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.ListarPersonalResponse;

@Repository("personalDAO")
public class PersonalDAOImpl implements PersonalDAO {

	@Override
	public ListarPersonalResponse listarPersonal(String ip, ListarPersonalRequest request) throws Exception {
		// TODO Auto-generated method stub
		ListarPersonalResponse response = new ListarPersonalResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_listar_personal";
			Object[][] params = { 
						{ request.getpIdPersonal(), String.class },
						{ request.getpNuDocumento(), String.class },
						{ request.getpNoNombreApellido(), String.class }, 
						{ request.getpIdTipoDocumento(), Integer.class },
						{ request.getpIlActivo(), Boolean.class },
						{ request.getpTiFun(), Integer.class }
					};
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_personal", "idPersonal");
			map.put("no_personal", "noPersonal");
			map.put("no_ape_pat", "noApePat");
			map.put("no_ape_mat", "noApeMat");
			map.put("no_abreviatura", "noAbreviatura");
			map.put("nu_documento", "nuDocumento");
			map.put("no_direccion", "noDireccion");
			map.put("nu_telefono", "nuTelefono");
			map.put("nu_celular", "nuCelular");
			map.put("no_correo", "noCorreo");
			map.put("nu_cmvp", "nuCmvp");
			map.put("no_grupo_ocupacional", "noGrupoOcupacional");
			map.put("no_tipo_profesional", "noTipoProfesional");
			map.put("no_estado", "noEstado");
			map.put("id_tipo_documento", "idTipoDocumento");
			map.put("il_activo", "ilActivo");
			map.put("id_grupo_ocupacional", "idGrupoOcupacional");
			map.put("id_tipo_profesional", "idTipoProfesional");
			map.put("ca_profesional", "caProfesional");
			map.put("ca_no_profesional", "caNoProfesional");
			Response<Personal> responseT = BaseDao.baseData(storedProcedure, params, db.con, Personal.class, map);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsPersonal((ArrayList<Personal>) responseT.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public CRUDResponse eliminarPersonal(String ip, EliminarPersonalRequest request) throws Exception {
		// TODO Auto-generated method stub
		CRUDResponse response = new CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_eliminar_personal";
			Object[][] params = { 
						{ request.getpIdPersonal(), String.class }
					};
			Map<String,String> mapCol=new HashMap<String,String>();
			mapCol.put("id_result", "idResult");
			mapCol.put("no_mensaje", "mensajeValidacion");
			Response<CRUDResponse> responseT=BaseDao.baseData(storedProcedure, params, db.con,CRUDResponse.class, mapCol);
			if(responseT.getCodigo()!=Constantes.ESTADO_TRAMA_OK)
			{
				throw responseT.getException();
			}else
			{
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public CRUDResponse registrarPersonal(String ip, RegistrarPersonalRequest request) throws Exception {
		// TODO Auto-generated method stub
		CRUDResponse response= new  CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_registrar_personal";
			Object[][] params = { 
									{ request.getPersonal().getIdPersonal(), String.class },
									{ request.getPersonal().getNoPersonal(), String.class },
									{ request.getPersonal().getNoApePat(), String.class },
									{ request.getPersonal().getNoApeMat(), String.class },
									{ request.getPersonal().getNuDocumento(), String.class },
									{ request.getPersonal().getNoDireccion(), String.class },
									{ request.getPersonal().getNuTelefono(), String.class },
									{ request.getPersonal().getNuCelular(), String.class },
									{ request.getPersonal().getNoCorreo(), String.class },
									{ request.getPersonal().getNuCmvp(), String.class },
									{ request.getPersonal().getIdTipoDocumento(), Integer.class },
									{ request.getPersonal().getIdGrupoOcupacional(), Integer.class },
								};
		
			Map<String,String> mapCol=new HashMap<String,String>();
			mapCol.put("id_result", "idResult");
			mapCol.put("no_mensaje", "mensajeValidacion");
			Response<CRUDResponse> responseT=BaseDao.baseData(storedProcedure, params, db.con,CRUDResponse.class, mapCol);
			if(responseT.getCodigo()!=Constantes.ESTADO_TRAMA_OK)
			{
				throw responseT.getException();
			}else
			{
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public CRUDResponse actualizarPersonal(String ip, ActualizarPersonalRequest request) throws Exception {
		CRUDResponse response= new  CRUDResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_actualizar_personal";
			Object[][] params = { 
									{ request.getPersonal().getIdPersonal(), String.class },
									{ request.getPersonal().getNoPersonal(), String.class },
									{ request.getPersonal().getNoApePat(), String.class },
									{ request.getPersonal().getNoApeMat(), String.class },
									{ request.getPersonal().getNuDocumento(), String.class },
									{ request.getPersonal().getNoDireccion(), String.class },
									{ request.getPersonal().getNuTelefono(), String.class },
									{ request.getPersonal().getNuCelular(), String.class },
									{ request.getPersonal().getNoCorreo(), String.class },
									{ request.getPersonal().getNuCmvp(), String.class },
									{ request.getPersonal().getIdTipoDocumento(), Integer.class },
									{ request.getPersonal().getIdGrupoOcupacional(), Integer.class },
									{ request.getPersonal().getIlActivo(), Boolean.class },
								};
			
			Map<String,String> mapCol=new HashMap<String,String>();
			mapCol.put("id_result", "idResult");
			mapCol.put("no_mensaje", "mensajeValidacion");
			Response<CRUDResponse> responseT=BaseDao.baseData(storedProcedure, params, db.con,CRUDResponse.class, mapCol);
			if(responseT.getCodigo()!=Constantes.ESTADO_TRAMA_OK)
			{
				throw responseT.getException();
			}else
			{
				response.setEstado(responseT.getData().get(0).getIdResult());
				response.setMensaje(responseT.getData().get(0).getMensajeValidacion());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

}
