package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.GrabacionDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Grabacion;
import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;


@Repository("grabacionDAO")
public class GrabacionDAOImpl implements GrabacionDAO {
	
	@Override
	public GrabacionResponse listarGrabaciones(String ip, GrabacionRequest request) throws Exception {
		GrabacionResponse response = new GrabacionResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_listar_grabacion_agente";
			Object[][] params = { 
					{ request.getAgente(), Integer.class }, 
					{ request.getTipo(), String.class }, 
					{ request.getOrigen(), String.class },
					{ request.getDestino(), String.class }, 
					{ request.getFeInicon(), String.class }, 
					{ request.getFeFincon(), String.class },
					{ request.getpHorai(), String.class }, 
					{ request.getpHoraf(), String.class }, 
					{ request.getTipoFun(), Integer.class } };
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("nombre_audio", "nombreAudio");
			mapColumnToAttributte.put("tipo", "tipo");
			mapColumnToAttributte.put("origen", "origen");
			mapColumnToAttributte.put("destino", "destino");
			mapColumnToAttributte.put("fecha", "fecha");
			mapColumnToAttributte.put("hora", "hora");
			mapColumnToAttributte.put("duracion", "duracion");
			mapColumnToAttributte.put("nu_anexo", "nuAnexo");
			mapColumnToAttributte.put("unique_id", "uniqueId");

			Response<Grabacion> responseA = BaseDao.baseData(storedProcedureName, params, db.con, Grabacion.class, mapColumnToAttributte);
			if (responseA.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseA.getException();
			} else {
				response.setMensaje("OK");
				response.setLsAudioA(responseA.getData());
			}
			response.setEstado(responseA.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
