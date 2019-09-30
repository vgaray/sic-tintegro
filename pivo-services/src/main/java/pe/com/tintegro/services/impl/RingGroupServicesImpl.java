package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.RingGroupDAO;
import pe.com.tintegro.dominio.RingGroup;
import pe.com.tintegro.dto.request.ActualizarRingGroupRequest;
import pe.com.tintegro.dto.request.EliminarRingGroupRequest;
import pe.com.tintegro.dto.request.InsertarRingGroupRequest;
import pe.com.tintegro.dto.request.ListaRingGroupRequest;
import pe.com.tintegro.dto.request.ListarRingGroupxAnexoRequest;
import pe.com.tintegro.dto.request.ListarVerificacionRingGroupRequest;
import pe.com.tintegro.dto.response.ActualizarRingGroupResponse;
import pe.com.tintegro.dto.response.EliminarRingGroupResponse;
import pe.com.tintegro.dto.response.InsertarRingGroupResponse;
import pe.com.tintegro.dto.response.ListaRingGroupResponse;
import pe.com.tintegro.dto.response.ListarRingGroupxAnexoResponse;
import pe.com.tintegro.dto.response.ListarVerificacionRingGroupResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.RingGroupServices;

@Service("ringGroupServices")
@Transactional
public class RingGroupServicesImpl implements RingGroupServices {

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "ringGroupDAO")
	protected RingGroupDAO ringGroupDAO;

	@Override
	public ListaRingGroupResponse listaGroupServices(String codUsuario, String idInstancia, ListaRingGroupRequest request) throws Exception {
		ListaRingGroupResponse response = new ListaRingGroupResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = ringGroupDAO.listaRingGroupDAO(ip, request);
		List<RingGroup> showRingGroup = new ArrayList<RingGroup>();
		showRingGroup.clear();
		RingGroup ringGroupAux = new RingGroup();
		if (request.getIdGrupo() != null) {
			ringGroupAux = response.getListRingGroup().get(0);
			String numGrupoAux = Integer.toString(ringGroupAux.getNuGrupo());
			Integer numGrupoRep = Integer.parseInt(numGrupoAux.substring(1));
			ringGroupAux.setNuGrupo(numGrupoRep);
			showRingGroup.add(ringGroupAux);
			response.setListRingGroup(showRingGroup);
		}

		return response;
	}

	@Override
	public InsertarRingGroupResponse insertarRingGroupServices(String codUsuario, String idInstancia, InsertarRingGroupRequest request) throws Exception {
		InsertarRingGroupResponse response = new InsertarRingGroupResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		String numAux = "8" + Integer.toString(request.getNuGrupo());
		String nomAux = request.getNoGrupo().toLowerCase();
		ListaRingGroupRequest requestValida = new ListaRingGroupRequest();
		requestValida.setIdGrupo(null);
		ListaRingGroupResponse responseValida = ringGroupDAO.listaRingGroupDAO(ip, requestValida);
		List<Integer> nuSips = listaNuGrupos(responseValida);
		List<String> noSips = listaNoGrupo(responseValida);
		// -1 no existe caracter
		if (nuSips.indexOf(Integer.parseInt(numAux)) != -1 && noSips.indexOf(nomAux) == -1) {
			response.setEstado(0);
			response.setValResult(1);
			response.setMensaje("Este Numero de Grupo ya esta Registrado");
		} else if (noSips.indexOf(nomAux) != -1 && nuSips.indexOf(Integer.parseInt(numAux)) == -1) {
			response.setEstado(0);
			response.setValResult(2);
			response.setMensaje("Este Nombre de Grupo ya esta Registrado");
		} else if (noSips.indexOf(nomAux) != -1 && nuSips.indexOf(Integer.parseInt(numAux)) != -1) {
			response.setEstado(0);
			response.setValResult(3);
			response.setMensaje("Error en nombre y numero de grupo");
		} else {
			request.setNuGrupo(Integer.parseInt(numAux));
			request.setNuSipL((listaidSip(request.getNuSips())));

			response = ringGroupDAO.insertarRingGroupDAO(ip, request);
		}
		return response;
	}

	@Override
	public ActualizarRingGroupResponse actualizarRingGroupServices(String codUsuario, String idInstancia, ActualizarRingGroupRequest request) throws Exception {
		ActualizarRingGroupResponse response = new ActualizarRingGroupResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		String numAux = "8" + Integer.toString(request.getNuGrupo());
		ListaRingGroupRequest requestValida = new ListaRingGroupRequest();
		requestValida.setIdGrupo(null);
		request.setNuGrupo(Integer.parseInt(numAux));
		request.setIdSip(listaidSip(request.getNuSips()));
		request.setIlActivo(true);
		response = ringGroupDAO.actualizarRingGroupDAO(ip, request);
		return response;
	}

	public String listaidSip(List<String> idSips) {
		String nidSips = "";
		for (int i = 0; i < idSips.size(); i++) {
			nidSips += idSips.get(i) + (i == idSips.size() - 1 ? "" : ", ");
		}
		return nidSips;
	}

	public List<Integer> listaNuGrupos(ListaRingGroupResponse response) {
		List<Integer> nuSip = new ArrayList<Integer>();
		nuSip.clear();
		for (int i = 0; i < response.getListRingGroup().size(); i++) {
			Integer element = response.getListRingGroup().get(i).getNuGrupo();
			nuSip.add(element);
			element = 0;
		}
		return nuSip;
	}

	public List<String> listaNoGrupo(ListaRingGroupResponse response) {
		List<String> nuSip = new ArrayList<String>();
		nuSip.clear();
		for (int i = 0; i < response.getListRingGroup().size(); i++) {
			String element = response.getListRingGroup().get(i).getNoGrupo().toLowerCase();
			nuSip.add(element);
			element = null;
		}
		return nuSip;
	}

	@Override
	public EliminarRingGroupResponse eliminarRingGroupServices(String codUsuario, String idInstancia, EliminarRingGroupRequest request) throws Exception {
		EliminarRingGroupResponse response = new EliminarRingGroupResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = ringGroupDAO.eliminarRingGroupDAO(ip, request);
		return response;
	}

	@Override
	public ListarVerificacionRingGroupResponse verificacionRingGroup(String codUsuario, String idInstancia, ListarVerificacionRingGroupRequest request) throws Exception {
		ListarVerificacionRingGroupResponse response = new ListarVerificacionRingGroupResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = ringGroupDAO.verificacionRingGroupDAO(ip, request);
		return response;
	}

	@Override
	public ListarRingGroupxAnexoResponse filtroRingGroupServices(String codUsuario, String idInstancia, ListarRingGroupxAnexoRequest request) throws Exception {
		ListarRingGroupxAnexoResponse response = new ListarRingGroupxAnexoResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = ringGroupDAO.filtroRingGroupDAO(ip, request);
		return response;
	}
}
