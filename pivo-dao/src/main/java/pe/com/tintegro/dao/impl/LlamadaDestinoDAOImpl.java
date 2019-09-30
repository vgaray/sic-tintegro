package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.LlamadaDestinoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.LlamadaDestino;
import pe.com.tintegro.dto.request.ListarLlamadaDestinoRequest;
import pe.com.tintegro.dto.response.ListarLlamadaDestinoResponse;

@Repository("llamadaDestinoDAO")
public class LlamadaDestinoDAOImpl implements LlamadaDestinoDAO {

	@Override
	public ListarLlamadaDestinoResponse listaLlamadaDestino(String ip, ListarLlamadaDestinoRequest request) throws Exception {
		ListarLlamadaDestinoResponse response = new ListarLlamadaDestinoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.fn_llamadas_por_destino";
			Object[][] params = { 
					{ request.getpIdArea(), Integer.class }, 
					{ request.getpIdCentcos(), Integer.class }, 
					{ request.getpFeIni(), String.class }, 
					{ request.getpHoIni(), String.class }, 
					{ request.getpFeFin(), String.class }, 
					{ request.getpHoFin(), String.class },
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("destino", "destino");
			mapCol.put("minutos", "minutos");
			mapCol.put("horas", "horas");
			mapCol.put("can_llamadas", "canLlamadas");
			mapCol.put("promedio", "promedio");
			mapCol.put("minimo_conver", "minimoConver");
			mapCol.put("maximo_conver", "maximoConver");

			Response<LlamadaDestino> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadaDestino.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLLamadasDestino(responseT.getData());
				for (int i = 0; i < response.getListaLLamadasDestino().size(); i++) {
					response.getListaLLamadasDestino().get(i).setIndice(i + 1);
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