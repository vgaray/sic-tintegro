package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.RankingLlamadasDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.RankingLlamadas;
import pe.com.tintegro.dto.request.RankingLlamadasRequest;
import pe.com.tintegro.dto.response.RankingLlamadasResponse;

@Repository("rankingLlamadasDAO")
public class RankingLlamadasDAOImpl implements RankingLlamadasDAO {
	@Override
	public RankingLlamadasResponse listarReporteRankingLlamadas(String ipUser, RankingLlamadasRequest request) throws Exception {
		// aqui es del reporte
		RankingLlamadasResponse response = new RankingLlamadasResponse();

		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "reportes.llamada_usuario_top_new";

			Object[][] params = { 
					{ request.getFeIni(), String.class }, 
					{ request.getFeFin(), String.class }, 
					{ request.getHoraIni(), String.class }, 
					{ request.getHorafin(), String.class }, 
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_usuari", "idUsuario");
			mapColumnToAttributte.put("no_usuari", "noUsuario");
			mapColumnToAttributte.put("ca_llamad", "caLlamad");
			mapColumnToAttributte.put("ca_duraci", "caDuraci");
			mapColumnToAttributte.put("ca_duraprom", "caDuracProm");
			mapColumnToAttributte.put("ca_duracmin", "caDuracMin");
			mapColumnToAttributte.put("ca_duracmax", "caDuracMax");
			mapColumnToAttributte.put("nu_total_min", "nuTotalMin");
			// agregar
			Response<RankingLlamadas> responseT = BaseDao.baseData(storedProcedureName, params, db.con, RankingLlamadas.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListRanking(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}
		finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public RankingLlamadasResponse listarRankingLlamadas(String ip, RankingLlamadasRequest request) throws Exception {
		RankingLlamadasResponse response = new RankingLlamadasResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_usuario_top_report";
			Object[][] params = {
					{ request.getFeIni(), String.class }, 
					{ request.getFeFin(), String.class }, 
					{ request.getHoraIni(), String.class }, 
					{ request.getHorafin(), String.class }, 
					{ request.getNumPagina(), Integer.class }, 
					{ request.getCantidadxPag(), Integer.class }, 
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_usuari", "idUsuario");
			mapColumnToAttributte.put("no_usuari", "noUsuario");
			mapColumnToAttributte.put("ca_llamad", "caLlamad");
			mapColumnToAttributte.put("ca_duraci", "caDuraci");
			mapColumnToAttributte.put("ca_duraprom", "caDuracProm");
			mapColumnToAttributte.put("ca_duracmin", "caDuracMin");
			mapColumnToAttributte.put("ca_duracmax", "caDuracMax");
			mapColumnToAttributte.put("nu_total_min", "nuTotalMin");
			mapColumnToAttributte.put("nu_total_reg", "total");

			Response<RankingLlamadas> responseT = BaseDao.baseData(storedProcedureName, params, db.con, RankingLlamadas.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListRanking(responseT.getData());
				for (int i = 0; i < response.getListRanking().size(); i++) {
					response.getListRanking().get(i).setIndice(i + 1);
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
