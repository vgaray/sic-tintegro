package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.LlamadaGeneralDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.LlamadaGeneral;
import pe.com.tintegro.dto.request.ListaLlamadaGeneralRequest;
import pe.com.tintegro.dto.response.ListaLlamadaGeneralResponse;


@Repository("llamadaGeneralDAO")
public class LlamadaGeneralDAOImpl implements LlamadaGeneralDAO {

	@Override
	public ListaLlamadaGeneralResponse listaReportellamadaGeneral(String ip, ListaLlamadaGeneralRequest request) throws Exception {
		ListaLlamadaGeneralResponse response = new ListaLlamadaGeneralResponse();

		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_general_new";
			Object[][] params = { 
					{ request.getpNoSrc(), String.class }, 
					{ request.getpNoDst(), String.class }, 
					{ request.getpNoDis(), String.class }, 
					{ request.getpFeIni(), String.class }, 
					{ request.getpFeFin(), String.class }, 
					{ request.getpHorai(), String.class },
					{ request.getpHoraf(), String.class }, 
					{ request.getpTipLlamada(), Integer.class }, 
					{ request.getpRanInitie(), Integer.class }, 
					{ request.getpRanFintie(), Integer.class }, 
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("src", "src");
			mapCol.put("dst", "dst");
			mapCol.put("clid", "clid");
			mapCol.put("fe_llamad", "feLlamado");
			mapCol.put("ho_llamad", "hoLlamad");
			mapCol.put("ca_duraci", "caDuraci");
			mapCol.put("ca_bilsec", "caBilsec");
			mapCol.put("ca_duracimin", "caDuracimin");
			mapCol.put("ca_bilsecmin", "caBilsecmin");
			mapCol.put("va_dispos", "vaDispos");

			Response<LlamadaGeneral> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadaGeneral.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadaGeneralList(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} 
		finally {
				db.cerrar();
		}
		return response;
	}

	@Override
	public ListaLlamadaGeneralResponse listallamadaGeneral(String ip, ListaLlamadaGeneralRequest request) throws Exception {
		ListaLlamadaGeneralResponse response = new ListaLlamadaGeneralResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "reportes.llamada_general_report";
			Object[][] params = { 
					{ request.getpNoSrc(), String.class }, 
					{ request.getpNoDst(), String.class }, 
					{ request.getpNoDis(), String.class }, 
					{ request.getpFeIni(), String.class }, 
					{ request.getpFeFin(), String.class }, 
					{ request.getpHorai(), String.class },
					{ request.getpHoraf(), String.class }, 
					{ request.getpTipLlamada(), Integer.class }, 
					{ request.getpRanInitie(), Integer.class }, 
					{ request.getpRanFintie(), Integer.class }, 
					{ request.getNumPagina(), Integer.class }, 
					{ request.getCantidadxPag(), Integer.class },
					{ request.getpIdOrden(), Integer.class } };

			Map<String, String> mapCol = new HashMap<String, String>();
			mapCol.put("src", "src");
			mapCol.put("dst", "dst");
			mapCol.put("clid", "clid");
			mapCol.put("fe_llamad", "feLlamado");
			mapCol.put("ho_llamad", "hoLlamad");
			mapCol.put("ca_duraci", "caDuraci");
			mapCol.put("ca_bilsec", "caBilsec");
			mapCol.put("ca_duracimin", "caDuracimin");
			mapCol.put("ca_bilsecmin", "caBilsecmin");
			mapCol.put("va_dispos", "vaDispos");
			mapCol.put("nu_total_reg", "total");

			Response<LlamadaGeneral> responseT = BaseDao.baseData(storedProcedureName, params, db.con, LlamadaGeneral.class, mapCol);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setListaLlamadaGeneralList(responseT.getData());
				for (int i = 0; i < response.getListaLlamadaGeneralList().size(); i++) {
					response.getListaLlamadaGeneralList().get(i).setIndice(i + 1);
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