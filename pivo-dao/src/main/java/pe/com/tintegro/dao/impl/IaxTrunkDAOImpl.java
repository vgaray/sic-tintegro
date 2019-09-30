package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.connection.PostgreSQL;
import pe.com.tintegro.dao.BaseDao;
import pe.com.tintegro.dao.IaxTrunkDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dao.util.MensajeError;
import pe.com.tintegro.dao.util.Response;
import pe.com.tintegro.dominio.IaxTrunk;
import pe.com.tintegro.dto.request.ActualizaIaxTrunkRequest;
import pe.com.tintegro.dto.request.EliminaIaxTrunkRequest;
import pe.com.tintegro.dto.request.InsertaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListaIaxTrunkRequest;
import pe.com.tintegro.dto.request.ListarCentralesNoDisponiblesRequest;
import pe.com.tintegro.dto.response.ActualizaIaxTrunkResponse;
import pe.com.tintegro.dto.response.EliminaIaxTrunkResponse;
import pe.com.tintegro.dto.response.InsertaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListaIaxTrunkResponse;
import pe.com.tintegro.dto.response.ListarCentralesNoDisponiblesResponse;

@Repository("iaxTrunkDAO")
public class IaxTrunkDAOImpl implements IaxTrunkDAO {
	@Override
	public InsertaIaxTrunkResponse insertaIaxTrunk(String ip, InsertaIaxTrunkRequest request) throws Exception {
		InsertaIaxTrunkResponse response = new InsertaIaxTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_insertar_iax_trunk";
			Object[][] param = { 
					{ request.getNomIaxTrunk(), String.class }, 
					{ request.getTipoCentral(), String.class }, 
					{ request.getCentralInterna(), Integer.class }, 
					{ request.getIdCentralExterna(), Integer.class }, 
					{ request.getPuertoIax(), String.class },
					{ request.getLlamadasConcurrentes(), Integer.class }, 
					{ request.getPrefLlamadaSalientes(), String.class }, 
					{ request.getNumEmpresa(), String.class }, 
					{ request.getAnexoInterno(), Integer.class }, 
					{ request.getFijoLocal(), Integer.class },
					{ request.getFijoNacional(), Integer.class }, 
					{ request.getFijoInternacional(), Integer.class }, 
					{ request.getCelularNacional(), Integer.class }, 
					{ request.getCelularInternacional(), Integer.class }, 
					{ request.getCelularRpm(), Integer.class },
					{ request.getNomContext(), String.class }, 
					{ request.getSecret(), String.class }, 
					{ request.getIdentificador(), String.class },
					{ request.getFrompstn(),Integer.class}};

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<InsertaIaxTrunkResponse> responseInt = BaseDao.baseData(storedProcedure, param, pg.con, InsertaIaxTrunkResponse.class, maps);
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
	public ActualizaIaxTrunkResponse actualizaIaxTrunk(String ip, ActualizaIaxTrunkRequest request) throws Exception {
		ActualizaIaxTrunkResponse response = new ActualizaIaxTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_actualizar_iax_trunk";
			Object[][] param = { 
					{ request.getIdIaxTrunk(), Integer.class }, 
					{ request.getNomIaxTrunk(), String.class }, 
					{ request.getTipoCentral(), String.class }, 
					{ request.getCentralInterna(), Integer.class }, 
					{ request.getIdCentralExterna(), Integer.class },
					{ request.getPuertoIax(), String.class }, 
					{ request.getLlamadasConcurrentes(), Integer.class }, 
					{ request.getPrefLlamadaSalientes(), String.class }, 
					{ request.getNumEmpresa(), String.class }, 
					{ request.getAnexoInterno(), Integer.class },
					{ request.getFijoLocal(), Integer.class }, 
					{ request.getFijoNacional(), Integer.class }, 
					{ request.getFijoInternacional(), Integer.class }, 
					{ request.getCelularNacional(), Integer.class }, 
					{ request.getCelularInternacional(), Integer.class },
					{ request.getCelularRpm(), Integer.class }, 
					{ request.getNomContext(), String.class }, 
					{ request.getSecret(), String.class }, 
					{ request.getIdentificador(), String.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<ActualizaIaxTrunkResponse> responseInt = BaseDao.baseData(storedProcedure, param, pg.con, ActualizaIaxTrunkResponse.class, maps);
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
	public EliminaIaxTrunkResponse eliminaIaxTrunk(String ip, EliminaIaxTrunkRequest request) throws Exception {
		EliminaIaxTrunkResponse response = new EliminaIaxTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_eliminar_iax_trunk";
			Object[][] param = { { request.getIdIaxTrunk(), Integer.class } };

			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_rasult", "resultado");
			maps.put("mensaje", "nomMensaje");

			Response<EliminaIaxTrunkResponse> responseInt = BaseDao.baseData(storedProcedure, param, pg.con, EliminaIaxTrunkResponse.class, maps);
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
	public ListaIaxTrunkResponse listaIaxTrunk(String ip, ListaIaxTrunkRequest request) throws Exception {
		ListaIaxTrunkResponse response = new ListaIaxTrunkResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_iax_trunk";
			Object[][] param = { { request.getIdIaxTrunk(), Integer.class } };
			Map<String, String> maps = new HashMap<String, String>();
			maps.put("id_iax_trunk", "idIaxTrunk");
			maps.put("no_iax_trunk", "nomIaxTrunk");
			maps.put("tipo_central", "tipoCentral");
			maps.put("central_interna", "centralInterna");
			maps.put("id_empresa", "idCentralExterna");
			maps.put("puerto_iax", "puertoIax");
			maps.put("llamadas_concurrentes", "llamadasConcurrentes");
			maps.put("prefijo_llamadas_salientes", "prefLlamadaSalientes");
			maps.put("numercacion_empresa", "numEmpresa");
			maps.put("anexo_interno", "anexoInterno");
			maps.put("il_fijo_local", "fijoLocal");
			maps.put("il_fijo_nacional", "fijoNacional");
			maps.put("il_fijo_internacional", "fijoInternacional");
			maps.put("il_celular_nacional", "celularNacional");
			maps.put("il_celular_internacional", "celularInternacional");
			maps.put("il_celular_rpm", "celularRpm");
			maps.put("no_contexto", "nomContext");
			maps.put("secret", "secret");
			maps.put("identificador", "identificador");
			maps.put("il_frompstn", "frompstn");
			Response<IaxTrunk> responseIax = BaseDao.baseData(storedProcedure, param, pg.con, IaxTrunk.class, maps);
			if (responseIax.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseIax.getException();
			} else {
				response.setMensaje(MensajeError.OK);
				response.setListaIaxTrunk(responseIax.getData());
			}
			response.setEstado(responseIax.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}

	@Override
	public ListarCentralesNoDisponiblesResponse listaCentralesNoDisponibles(String ip, ListarCentralesNoDisponiblesRequest request) throws Exception {
		ListarCentralesNoDisponiblesResponse response = new ListarCentralesNoDisponiblesResponse();
		PostgreSQL pg = new PostgreSQL();
		pg.conectar(ip);
		try {
			String storedProcedure = "asterisk.fn_listar_centrales_no_disponibles";
			Object[][] param = { { request.getTipoCentral(), String.class } };

			Response<Integer> responseIax = BaseDao.baseData(storedProcedure, param, pg.con, Integer.class, null);
			if (responseIax.getCodigo() != Constantes.ESTADO_TRAMA_OK) {
				throw responseIax.getException();
			} else {
				ArrayList<String> responseIaxS = new ArrayList<String>();
				response.setMensaje(MensajeError.OK);
				for (int i = 0; i < responseIax.getData().size(); i++) {
					responseIaxS.add(responseIax.getData().get(i).toString());
				}
				response.setListado(responseIaxS);
			}
			response.setEstado(responseIax.getCodigo());
		} finally {
			pg.cerrar();
		}
		return response;
	}
}
