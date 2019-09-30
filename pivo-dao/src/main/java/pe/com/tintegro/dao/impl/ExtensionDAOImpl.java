package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.ExtensionDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dto.response.ListaExtensionResponse;

@Repository("extensionDAO")
public class ExtensionDAOImpl implements ExtensionDAO {

	@Override
	public ListaExtensionResponse listaExtension(String ip) throws Exception {
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		ListaExtensionResponse response = new ListaExtensionResponse();
		try { // Nombre del Stored Procedure
			String storedProcedureName = "asterisk.sp_list_extension";

			// Lista de parametros
			Object[][] params = {};

			// Map que relaciona nombre de columna retornada con atributo a la
			// que corresponde
			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();

			// mapColumnToAttributte.put( "CampoBD", "CampoProgra" );
			mapColumnToAttributte.put("id_sip", "idSip");
			mapColumnToAttributte.put("name", "nombre");
			mapColumnToAttributte.put("callerid", "callerId");

			Response<pe.com.tintegro.dominio.Extension> responseT = BaseDao.baseData(storedProcedureName, params, db.con, pe.com.tintegro.dominio.Extension.class, mapColumnToAttributte);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setExtensionList((ArrayList<pe.com.tintegro.dominio.Extension>) responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		}
		finally {
			db.cerrar();
		}
		return response;
	}
}