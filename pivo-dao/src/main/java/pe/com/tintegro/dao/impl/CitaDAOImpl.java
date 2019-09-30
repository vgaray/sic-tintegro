package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.CitaDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Cita;
import pe.com.tintegro.dto.request.ListarCitaRequest;
import pe.com.tintegro.dto.response.ListarCitaResponse;

@Repository("citaDAO")
public class CitaDAOImpl extends DAOTintegroImpl implements CitaDAO {

	@Override
	public ListarCitaResponse listaCita(String ip, ListarCitaRequest request) throws Exception {
		ListarCitaResponse response = new ListarCitaResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_listar_citas";
			Object[][] params = { { request.getpNuDocumento(), String.class },
					{ request.getpIdTipoDocumento(), Integer.class }, { request.getpIdEstado(), Integer.class },
					{ request.getpTiFun(), Integer.class } };

			Map<String, String> map = new HashMap<String, String>();
			map.put("id_cita", "idCita");
			map.put("no_cita", "noCita");
			map.put("no_descripcion", "noDescripcion");
			map.put("fe_reserva", "feReserva");
			map.put("fe_registro", "feRegistro");
			map.put("no_tipo_documento", "noTipoDocumento");
			map.put("nu_documento", "nuDocumento");
			map.put("id_usuario", "idUsuario");
			map.put("no_duenio", "noDuenio");
			map.put("id_mascota", "idMascota");
			map.put("no_mascota", "noMascota");
			map.put("no_especie", "noEspecie");
			map.put("no_raza", "noRaza");
			map.put("nu_telefono", "nuTelefono");
			map.put("no_correo", "noCorreo");
			map.put("nu_contacto", "nuContacto");
			map.put("no_actividad", "noActividad");
			map.put("ho_inicio", "hoInicio");
			map.put("ho_final", "hoFinal");
			map.put("no_turno", "noTurno");
			map.put("no_periodo", "noPeriodo");
			map.put("id_estado", "idEstado");
			map.put("nu_chip", "nuChip");
			map.put("no_estado", "noEstado");
			map.put("id_personal", "idPersonal");
			map.put("no_personal", "noPersonal");
			Response<Cita> responseT = BaseDao.baseData(storedProcedure, params, db.con, Cita.class, map);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaCita((ArrayList<Cita>) responseT.getData());
			}
		} finally {
			db.cerrar();
		}
		return response;
	}

}
