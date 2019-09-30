package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.GenerarTxtIvrDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.GenerarTxtIvr;
import pe.com.tintegro.dto.request.GenerarTxtIvrReques;
import pe.com.tintegro.dto.response.GenerarTxtIvrResponse;

@Repository("generarTxtIvrDAO")
public class GenerarTxtIvrDAOImpl implements GenerarTxtIvrDAO {
	@Override
	public GenerarTxtIvrResponse listarGenerarTxtIvr(String ip, GenerarTxtIvrReques reques) throws Exception {
		GenerarTxtIvrResponse response = new GenerarTxtIvrResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_ivr_txt_horario";
			Object[][] params = {};

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("idgrupohor", "idGrupoHor");
			mapCol.put("nogrupohor", "noGurpoHor");
			mapCol.put("no_ivr", "noIVR");
			mapCol.put("idhorario", "idHorario");
			mapCol.put("hoinicio", "hoInicio");
			mapCol.put("hofin", "hoFin");
			mapCol.put("nodiasemanainicio", "noDiaSemanaInicio");
			mapCol.put("nodiasemanafin", "noDiaSemanaFin");
			mapCol.put("nodiamesinicio", "noDiaMesInicio");
			mapCol.put("nodiamesfin", "noDiaMesFin");
			mapCol.put("nomesinicio", "noMesInicio");
			mapCol.put("nomesfin", "noMesFin");
			mapCol.put("tihorario", "tiHorario");
			mapCol.put("noaudio", "noAudio");

			Response<GenerarTxtIvr> responseT = BaseDao.baseData(storedProcedureName, params, db.con, GenerarTxtIvr.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListGenerarTxtIvr(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
