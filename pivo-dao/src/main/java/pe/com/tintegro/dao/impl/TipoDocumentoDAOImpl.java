package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.TipoDocumentoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.TipoDocumento;
import pe.com.tintegro.dto.response.ListarTipoDocumentoResponse;

public class TipoDocumentoDAOImpl implements TipoDocumentoDAO {

	@Override
	public ListarTipoDocumentoResponse listarTipoDocumento(String ip) throws Exception {
		// TODO Auto-generated method stub
		ListarTipoDocumentoResponse response=new ListarTipoDocumentoResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ip);
		try {
			String storedProcedure = "sistema.fn_listar_tipo_doc";
			Object[][] params = {
					
					};
			Map<String, String> map = new HashMap<String, String>();
			map.put("id_tipdoc", "idTipodoc");
			map.put("no_tipo", "noTipo");
			Response<TipoDocumento> responseT = BaseDao.baseData(storedProcedure, params, db.con, TipoDocumento.class, map);
			if (responseT.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseT.getException();
			} else {
				response.setMensaje("OK");
				response.setLsTipoDocumento((ArrayList<pe.com.tintegro.dominio.TipoDocumento>) responseT.getData());
			}
		
		} finally {
			db.cerrar();
		}
		
		return response;
	}
}
