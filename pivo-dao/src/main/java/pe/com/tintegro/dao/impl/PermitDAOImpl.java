package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.PermitDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.Permit;
import pe.com.tintegro.dto.request.ListaPermitRequest;
import pe.com.tintegro.dto.response.ListaPermitResponse;

@Repository("permitDAO")
public class PermitDAOImpl implements PermitDAO {

	@Override
	public ListaPermitResponse listaPermit(String ip, ListaPermitRequest request) throws Exception {
		// TODO Auto-generated method stub
		ListaPermitResponse response = new ListaPermitResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String procedure = "asterisk.fn_lista_permit";
			Object[][] param = { { request.getIdSipTrunk(), Integer.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_permit", "idPermit");
			maps.put("id_sip_trunk", "idSipTrunk");
			maps.put("valor", "valor");

			Response<Permit> responseCodec = BaseDao.baseData(procedure, param, pg.con, Permit.class, maps);
			if (responseCodec.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseCodec.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaPermit(responseCodec.getData());
			}
			response.setEstado(responseCodec.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}
}