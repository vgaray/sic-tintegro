package pe.com.tintegro.dao.impl;

import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.TbPinDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.request.PinValidar;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;

@Repository("tbPinDAO")
public class TbPinDAOImpl implements TbPinDAO {

	@Override
	public FlagTbPinResponse modificarflagTbPin(String ipUser, FlagTbPinRequest request) throws Exception {
		// TODO Auto-generated method stub

		FlagTbPinResponse response = new FlagTbPinResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);

		try {
			String storedProcedureName = request.getEstado() == 1 ? "asterisk.sp_insertar_tbpin" : "asterisk.sp_del_tbpin";

			Object[][] params = { 
					{ request.getIdUsupin(), Integer.class }, 
					{ request.getIdClave(), Integer.class }, 
					{ request.getIdTiptel(), Integer.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setConfirma(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public BuscaPinResponse BuscaPin(String ipUser, BuscaPinRequest request) throws Exception {
		BuscaPinResponse response = new BuscaPinResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);
		try {
			String storedProcedureName = "asterisk.fn_pin_buscar";
			Object[][] params = { { request.getNumPin(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setIlExistePin(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}

	@Override
	public FlagTbPinResponse valivarPing(String ipUser, PinValidar request) throws Exception {
		FlagTbPinResponse response = new FlagTbPinResponse();
		PostgreSQL db = new PostgreSQL();
		db.conectar(ipUser);

		try {
			String storedProcedureName = "asterisk.fn_validar_nu_pin";

			Object[][] params = { { request.getNuPin(), String.class } };

			Response<Integer> responseInteger = BaseDao.baseData(storedProcedureName, params, db.con, Integer.class, null);

			if (responseInteger.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInteger.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setConfirma(responseInteger.getData().get(0));
			}
			response.setEstado(responseInteger.getCodigo());
		} finally {
			db.cerrar();
		}
		return response;
	}
}
