package pe.com.tintegro.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.SipTrunkDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.SipTrunk;
import pe.com.tintegro.dto.request.EditaSipTrunkRequest;
import pe.com.tintegro.dto.request.EliminaSipTrunkRequest;
import pe.com.tintegro.dto.request.InsertaSipTrunkRequest;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.EditaSipTrunkResponse;
import pe.com.tintegro.dto.response.EliminaSipTrunkResponse;
import pe.com.tintegro.dto.response.InsertaSipTrunkResponse;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;

@Repository("sipTrunkDAO")
public class SipTrunkDAOImpl implements SipTrunkDAO {

	@Override
	public InsertaSipTrunkResponse insertaSipTrunk(String ip, InsertaSipTrunkRequest request) throws Exception {
		// TODO Auto-generated method stub
		InsertaSipTrunkResponse response = new InsertaSipTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String procedure = "asterisk.fn_insertar_sip_trunk";
			Object[][] param = { 
					{ request.getNomSipTrunk(), String.class }, 
					{ request.getOutboundCid(), String.class }, 
					{ request.getNomSaliente(), String.class }, 
					{ request.getTipoSaliente(), String.class }, 
					{ request.getHostSaliente(), String.class },
					{ request.getUsernameSaliente(), String.class }, 
					{ request.getSecretSaliente(), String.class }, 
					{ request.getDtmf(), String.class }, 
					{ request.getContextSaliente(), String.class }, 
					{ request.getRegistrar(), String.class }, 
					{ request.getNomEntrante(), String.class },
					{ request.getTipoEntrante(), String.class }, 
					{ request.getSecretEntrante(), String.class }, 
					{ request.getContextEntrante(), String.class }, 
					{ request.getIdsCodec(), String.class }, 
					{ request.getValoresPermit(), String.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<InsertaSipTrunkResponse> responseInt = BaseDao.baseData(procedure, param, pg.con, InsertaSipTrunkResponse.class, maps);
			if (responseInt.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInt.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInt.getData().get(0).getResultado());
				response.setNomMensaje(responseInt.getData().get(0).getNomMensaje());
			}
			response.setEstado(responseInt.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public EditaSipTrunkResponse editaSipTrunk(String ip, EditaSipTrunkRequest request) throws Exception {
		// TODO Auto-generated method stub
		EditaSipTrunkResponse response = new EditaSipTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String procedure = "asterisk.fn_actualizar_sip_trunk";
			Object[][] param = { 
					{ request.getIdSipTrunk(), Integer.class }, 
					{ request.getNomSipTrunk(), String.class }, 
					{ request.getOutboundCid(), String.class }, 
					{ request.getNomSaliente(), String.class }, 
					{ request.getTipoSaliente(), String.class }, 
					{ request.getHostSaliente(), String.class },
					{ request.getUsernameSaliente(), String.class }, 
					{ request.getSecretSaliente(), String.class }, 
					{ request.getDtmf(), String.class }, 
					{ request.getContextSaliente(), String.class }, 
					{ request.getRegistrar(), String.class }, 
					{ request.getNomEntrante(), String.class },
					{ request.getTipoEntrante(), String.class }, 
					{ request.getSecretEntrante(), String.class }, 
					{ request.getContextEntrante(), String.class }, 
					{ request.getIdsCodec(), String.class }, 
					{ request.getValoresPermit(), String.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<EditaSipTrunkResponse> responseInt = BaseDao.baseData(procedure, param, pg.con, EditaSipTrunkResponse.class, maps);
			if (responseInt.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInt.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInt.getData().get(0).getResultado());
				response.setNomMensaje(responseInt.getData().get(0).getNomMensaje());
			}
			response.setEstado(responseInt.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public EliminaSipTrunkResponse eliminaSipTrunk(String ip, EliminaSipTrunkRequest request) throws Exception {
		// TODO Auto-generated method stub
		EliminaSipTrunkResponse response = new EliminaSipTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String procedure = "asterisk.fn_eliminar_sip_trunk";
			Object[][] param = { { request.getIdSipTrunk(), Integer.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<EliminaSipTrunkResponse> responseInt = BaseDao.baseData(procedure, param, pg.con, EliminaSipTrunkResponse.class, maps);
			if (responseInt.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseInt.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setResultado(responseInt.getData().get(0).getResultado());
				response.setNomMensaje(responseInt.getData().get(0).getNomMensaje());
			}
			response.setEstado(responseInt.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public ListaSipTrunkResponse listaSipTrunk(String ip, ListaSipTrunkRequest request) throws Exception {
		// TODO Auto-generated method stub
		ListaSipTrunkResponse response = new ListaSipTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String procedure = "asterisk.fn_lista_sip_trunk";
			Object[][] params = { { request.getIdSipTrunk(), Integer.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_sip_trunk", "idSipTrunk");
			maps.put("no_sip_trunk", "nomSipTrunk");
			maps.put("outbound_cid", "outboundCid");
			maps.put("no_saliente", "nomSaliente");
			maps.put("tipo_saliente", "tipoSaliente");
			maps.put("host_saliente", "hostSaliente");
			maps.put("username_saliente", "usernameSaliente");
			maps.put("secret_saliente", "secretSaliente");
			maps.put("dtmf", "dtmf");
			maps.put("context_saliente", "contextSaliente");
			maps.put("registrar", "registrar");
			maps.put("no_entrante", "nomEntrante");
			maps.put("tipo_entrante", "tipoEntrante");
			maps.put("secret_entrante", "secretEntrante");
			maps.put("context_entrante", "contextEntrante");
			maps.put("no_doceds", "nomCodecs");
			maps.put("no_permits", "nomPermits");

			Response<SipTrunk> responseSip = BaseDao.baseData(procedure, params, pg.con, SipTrunk.class, maps);
			if (responseSip.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseSip.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaSipTrunk(responseSip.getData());
			}
			response.setEstado(responseSip.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}
}
