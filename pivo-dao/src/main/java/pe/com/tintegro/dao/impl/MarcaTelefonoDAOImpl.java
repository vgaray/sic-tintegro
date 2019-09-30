package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.MarcaTelefonoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dto.response.ListaMarcaTelefonoResponse;

@Repository("marcaTelefonoDAO")
public class MarcaTelefonoDAOImpl implements MarcaTelefonoDAO {

	@Override
	public ListaMarcaTelefonoResponse listaMarcaTelefono(String ip) throws Exception {
		ListaMarcaTelefonoResponse response = new ListaMarcaTelefonoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedureName = "asterisk.fn_lista_todo_marca";

			// Lista de parametros
			Object[][] params = {};

			Map<String, String> mapColumnToAttributte = new HashMap<String, String>();
			mapColumnToAttributte.put("id_marca", "marcaId");
			mapColumnToAttributte.put("no_marca", "nomMarca");
			mapColumnToAttributte.put("il_formato_mac", "ilFormatoMac");

			Response<MarcaTelefono> responseT = BaseDao.baseData(storedProcedureName, params, db.con, MarcaTelefono.class, mapColumnToAttributte);

			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setMarcaTelefonoList(responseT.getData());
			}
			response.setEstado(responseT.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}