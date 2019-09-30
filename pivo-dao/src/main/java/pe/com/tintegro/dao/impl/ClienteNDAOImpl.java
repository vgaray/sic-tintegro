package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.ClienteNDAO;
import pe.com.tintegro.dominio.ClienteN;
import pe.com.tintegro.dto.request.ActualizarClienteNRequest;
import pe.com.tintegro.dto.request.EliminarClienteNRequest;
import pe.com.tintegro.dto.request.ListarClienteNRequest;
import pe.com.tintegro.dto.request.RegistrarClienteNRequest;
import pe.com.tintegro.dto.response.ActualizarClienteNResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.EliminarClienteNResponse;
import pe.com.tintegro.dto.response.ListarClienteNResponse;
import pe.com.tintegro.dto.response.RegistrarClienteNResponse;
import pe.com.tintegro.mapper.ClienteNMapper;

@Repository("clienteNDAO")
public class ClienteNDAOImpl extends DAOTintegroImpl implements ClienteNDAO {

	@Override
	public ActualizarClienteNResponse actualizarClienteN(ActualizarClienteNRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		ActualizarClienteNResponse response = new ActualizarClienteNResponse();
		ClienteNMapper mapper = this.getSqlSessionSic().getMapper(ClienteNMapper.class);
		result = (List<CRUDResponse>) mapper.actualizarClienteN(request.getClienteN().getIdCliente(), 
																request.getClienteN().getNoRazonSocial(), 
																request.getClienteN().getNuDocIde(), 
																request.getClienteN().getDirecc(), 
																request.getClienteN().getTelef(), 
																request.getClienteN().getCorreoEle(), 
																request.getClienteN().getPersonRef(), 
																request.getClienteN().isEstado(), 
																request.getClienteN().getIdTipdoc(), 
																request.getClienteN().getNuDocumentoPref(), 
																request.getClienteN().getIdTipdocPref(), 
																request.getClienteN().getNuCelularPref(), 
																request.getClienteN().getTelef());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public EliminarClienteNResponse eliminarClienteN(EliminarClienteNRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		EliminarClienteNResponse response = new EliminarClienteNResponse();
		ClienteNMapper mapper = this.getSqlSessionSic().getMapper(ClienteNMapper.class);
		result = (List<CRUDResponse>) mapper.eliminarClienteN(request.getpIdCliente());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public RegistrarClienteNResponse registrarClienteN(RegistrarClienteNRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		RegistrarClienteNResponse response = new RegistrarClienteNResponse();
		ClienteNMapper mapper = this.getSqlSessionSic().getMapper(ClienteNMapper.class);
		result = (List<CRUDResponse>) mapper.registrarClienteN(	request.getClienteN().getNoRazonSocial(), 
																request.getClienteN().getNuDocIde(), 
																request.getClienteN().getDirecc(), 
																request.getClienteN().getTelef(), 
																request.getClienteN().getCorreoEle(), 
																request.getClienteN().getPersonRef(), 
																request.getClienteN().isEstado(), 
																request.getClienteN().getIdTipdoc(), 
																request.getClienteN().getNuDocumentoPref(), 
																request.getClienteN().getIdTipdocPref(),
																request.getClienteN().getNuCelularPref(),
																request.getClienteN().getTelef());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}

	@Override
	public ListarClienteNResponse listarClienteN(ListarClienteNRequest request) throws Exception {
		List<ClienteN> result = new ArrayList<ClienteN>();
		ListarClienteNResponse response = new ListarClienteNResponse();
		ClienteNMapper mapper = this.getSqlSessionSic().getMapper(ClienteNMapper.class);
		result = (List<ClienteN>) mapper.listarClienteN(request.getpIdCliente(), 
														request.getpNoRazon(), 
														request.getpNudocide(), 
														request.ispEstado(), 
														request.getpNuPagina(), 
														request.getpNuRegMostras());
		response.setEstado(1);
		response.setMensaje("ok");
		response.setLsClientesN(result);
		return response;
	}
}
