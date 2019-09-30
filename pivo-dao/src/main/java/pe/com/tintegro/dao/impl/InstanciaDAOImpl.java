package pe.com.tintegro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pe.com.tintegro.dao.InstanciaDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dto.request.ActualizarInstanciaRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaNRequest;
import pe.com.tintegro.dto.request.InsertarInstanciaRequest;
import pe.com.tintegro.dto.request.ListaInstanciasPorEmpresaRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListaInstanciaRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxCasoRequest;
import pe.com.tintegro.dto.request.ListarInstanciaxIdClienteRequest;
import pe.com.tintegro.dto.response.ActualizarInstanciaResponse;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaNResponse;
import pe.com.tintegro.dto.response.InsertarInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaResponse;
import pe.com.tintegro.dto.response.ListaInstanciasPorEmpresaResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxCasoResponse;
import pe.com.tintegro.dto.response.ListarInstanciaxIdClienteResponse;
import pe.com.tintegro.mapper.InstanciaMapper;

@Repository("instanciaDAO")
public class InstanciaDAOImpl extends DAOTintegroImpl implements InstanciaDAO {
	@Override
	public List<InstanciaServerAsterisk> listarInstancia() {
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		List<InstanciaServerAsterisk> resultado = (List<InstanciaServerAsterisk>) mapper.listaInstancia();
		// System.out.println(resultado.size());
		// System.out.println(resultado.get(0).getIdInstancia());
		return resultado;
	}

	// @Override
	// public ListarInstanciaxCasoResponse listarInstanciaxvalor(
	// ListarInstanciaxCasoRequest obj) throws Exception {
	// List<ListarInstanciaxCasoRequest> result= new
	// ArrayList<ListarInstanciaxCasoRequest>();
	//
	// ListarInstanciaxCasoResponse response =new
	// ListarInstanciaxCasoResponse();
	//
	// InstanciaMapper mapper =
	// this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
	//
	// result=(List<ListarInstanciaxCasoRequest>)
	// mapper.listaInstanciaxValor(obj.getValor());
	// response.setListarInstaciaxCaso(result);
	//
	// return response;
	// }

	@Override
	public InsertarInstanciaResponse insertarInstancia(InsertarInstanciaRequest instancia) throws Exception {
		InsertarInstanciaResponse result = new InsertarInstanciaResponse();
		List<Integer> resultados = new ArrayList<Integer>();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		resultados = (List<Integer>) mapper.insertaInstancia(instancia.getIpRed(), instancia.getNroVLan(), instancia.getIpAsterisk(), 
				instancia.getIpMedian(), instancia.getMascara(), instancia.getIpRouter(), instancia.getDns1(), instancia.getDns2(), 
				instancia.getSubnet(), instancia.getBroadcast(), instancia.getPuertoAsteriskBashCertificadoExt(), instancia.getIdCliente(), 
				instancia.getIpAsteriskBash());
				result.setInserto(resultados);
		return result;
	}

	@Override
	public ListarInstanciaxCasoResponse listarInstanciaxCaso(ListarInstanciaxCasoRequest obj) throws Exception {
		List<ListarInstanciaxCasoRequest> rpta = new ArrayList<ListarInstanciaxCasoRequest>();
		ListarInstanciaxCasoResponse response = new ListarInstanciaxCasoResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		rpta = (List<ListarInstanciaxCasoRequest>) mapper.listaInstanciaxCaso(obj.getIdCliente(), obj.getEstadoE(), obj.getOcupadoE());
		response.setListarInstaciaxCaso(rpta);
		return response;
	}

	// _______________________________________________________________________________

	@Override
	public ListaInstanciaxIdResponse listarInstanciaxId(ListaInstanciaxIdRequest request) throws Exception {
		List<InstanciaServerAsterisk> rpta = new ArrayList<InstanciaServerAsterisk>();
		ListaInstanciaxIdResponse response = new ListaInstanciaxIdResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		rpta = (List<InstanciaServerAsterisk>) mapper.listaInstanciaxIdinstancia(request.getIdInstanciaDesc());
		response.setListarInstanciaxId(rpta);
		return response;
	}

	// ___________________________________________________

	@Override
	public ListarInstanciaxIdClienteResponse listarInstanciaxIdCliente(ListarInstanciaxIdClienteRequest obj) throws Exception {
		List<ListarInstanciaxIdClienteRequest> rpta = new ArrayList<ListarInstanciaxIdClienteRequest>();
		ListarInstanciaxIdClienteResponse response = new ListarInstanciaxIdClienteResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		rpta = (List<ListarInstanciaxIdClienteRequest>) mapper.listaInstanciaxIdCliente(obj.getIdCliente());
		response.setListarInstanciaxIdcliente(rpta);
		return response;
	}

	@Override
	public ListaInstanciaResponse listarInstancia(ListaInstanciaRequest request) throws Exception {
		ListaInstanciaResponse response = new ListaInstanciaResponse();
		List<InstanciaServerAsterisk> instancias = new ArrayList<InstanciaServerAsterisk>();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		instancias = (List<InstanciaServerAsterisk>) mapper.listarInstancia(request.getpIdTipdoc(), request.getpNuDocide(), 
				request.getpIdCliente(), request.getpIdPedido(), request.getpIdEstadoinstancia(), request.getpIdPlan(), 
				request.getpIdTipoEstadoPedido(), request.getpIdInstanciaxDesc(), request.getpIdUsuario(), request.getpNoLogin());
		response.setInstancias(instancias);
		return response;
	}

	@Override
	public ActualizarInstanciaResponse actualizarInstancia(ActualizarInstanciaRequest request) throws Exception {
		ActualizarInstanciaResponse response = new ActualizarInstanciaResponse();
		List<InstanciaServerAsterisk> instanciaActualizar = new ArrayList<InstanciaServerAsterisk>();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		instanciaActualizar = (List<InstanciaServerAsterisk>) mapper.actualizarInstancia(request.getIdInstanciaDesc(), request.getIpAsterisk(),
				request.getNomMascaraRedLan(), request.getNomMascaraOpenVpn(),request.getIpAsteriskBash(), request.getPuerto_ssh_asterisk(), 
				request.getPuertoOpenVPN(), request.getPamConfInicial(), request.getSimPais(), request.getSimProvincia(), request.getFullProvincia(), 
				request.getNoOrgani(), request.getEmail(), request.getIdModelo(),request.getIdMarca(), request.getNomInstancia(), request.getIlEstado()
				// request.getIdCliente(),
				// request.getIlEstado(),
				// request.getIlLibre(),
				// request.getInicial(),
				// request.getIdEstadoInstancia(),
				);

		response.setEstado(instanciaActualizar.get(0).getResult());
		response.setMensaje(instanciaActualizar.get(0).getMensaje());
		return response;
	}

	@Override
	public CRUDResponse notifyExecuteBashConfigInitial(String codUsuario, int idBash, int idInstance, Integer typeNotification) throws Exception {
		CRUDResponse response = new CRUDResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(InstanciaMapper.class);
		response = mapper.notifyExecuteBashConfigInitial(idBash, idInstance, typeNotification).get(0);
		return response;
	}

	@Override
	public List<StatusBash> loadStatusConfigInitialInstance(String codUser, Integer idInstance) throws Exception {
		List<StatusBash> lsStatusBash = null;
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(InstanciaMapper.class);
		lsStatusBash = mapper.loadStatusConfigInitialInstance(idInstance);
		return lsStatusBash;
	}

	@Override
	public CRUDResponse updateInstanceStatus(Integer idEstadoInstancia, String codUser, Integer idInstance) throws Exception {
		CRUDResponse response = new CRUDResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(InstanciaMapper.class);
		response = mapper.updateInstanceStatus(idInstance, idEstadoInstancia, codUser).get(0);
		return response;
	}

	@Override
	public ListaInstanciasPorEmpresaResponse listaInstanciasPorEmpresa(ListaInstanciasPorEmpresaRequest request) throws Exception {
		List<InstanciaServerAsterisk> rpta = new ArrayList<InstanciaServerAsterisk>();
		ListaInstanciasPorEmpresaResponse response = new ListaInstanciasPorEmpresaResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(pe.com.tintegro.mapper.InstanciaMapper.class);
		rpta = (List<InstanciaServerAsterisk>) mapper.listaInstanciasPorEmpresa(request.getIdInstanciaDesc());
		response.setListaInstanciaEmpresa(rpta);
		
		return response;
	}

	@Override
	public InsertarInstanciaNResponse insertarInstanciaN(InsertarInstanciaNRequest request) throws Exception {
		List<CRUDResponse> result = new ArrayList<CRUDResponse>();
		InsertarInstanciaNResponse response = new InsertarInstanciaNResponse();
		InstanciaMapper mapper = this.getSqlSessionSic().getMapper(InstanciaMapper.class);
		result = (List<CRUDResponse>) mapper.insertarInstanciaN(request.getInstanciaN().getIp_asterisk(), request.getInstanciaN().getNo_mascara_red_lan(),
				request.getInstanciaN().getNo_mascara_open_vpn(), request.getInstanciaN().getId_cliente(), request.getInstanciaN().isIl_estado(), request.getInstanciaN().isIl_libre(), 
				request.getInstanciaN().getPuerto_ssh_asterisk(), request.getInstanciaN().getPuerto_openvpn(), request.getInstanciaN().getSim_pais(), request.getInstanciaN().getSim_provincia(),
				request.getInstanciaN().getFull_provincia(), request.getInstanciaN().getNo_organi(), request.getInstanciaN().getNo_email(), request.getInstanciaN().getId_estadoinst(), 
				request.getInstanciaN().getNo_instancia(), request.getInstanciaN().getNo_password_ldap(), request.getInstanciaN().getInicial(), request.getInstanciaN().getId_detapedido(),
				request.getInstanciaN().isIl_seguridad());
		response.setEstado(result.get(0).getIdResult());
		response.setMensaje(result.get(0).getMensajeValidacion());
		return response;
	}
}
