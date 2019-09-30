package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.GrupoHorarioDAO;
import pe.com.tintegro.dto.request.EditaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.EliminaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.InsertaGrupoHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaPorIdGrupoHorarioRequest;
import pe.com.tintegro.dto.response.EditaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.EliminaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.InsertaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaGrupoHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdGrupoHorarioResponse;
import pe.com.tintegro.services.GrupoHorarioServices;
import pe.com.tintegro.services.InstanciaServices;

@Service("grupoHorarioServices")
@Transactional
public class GrupoHorarioServicesImpl implements GrupoHorarioServices {
	
	@Resource(name = "grupoHorarioDAO")
	protected GrupoHorarioDAO grupoHorarioDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public InsertaGrupoHorarioResponse insertaGrupoHorario(String codUsuario, String idInstancia, InsertaGrupoHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return grupoHorarioDAO.insertaGrupoHorario(ip, request);
	}

	@Override
	public EditaGrupoHorarioResponse editaGrupoHorario(String codUsuario, String idInstancia, EditaGrupoHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return grupoHorarioDAO.editaGrupoHorario(ip, request);

	}

	@Override
	public EliminaGrupoHorarioResponse eliminaGrupoHorario(String codUsuario, String idInstancia, EliminaGrupoHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return grupoHorarioDAO.eliminaGrupoHorario(ip, request);
	}

	@Override
	public ListaGrupoHorarioResponse listaGrupoHorario(String codUsuario, String idInstancia, ListaHorariosLibresRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return grupoHorarioDAO.listaGrupoHorario(ip, request);
	}

	@Override
	public ListaPorIdGrupoHorarioResponse listaPorIdGrupoHorario(String codUsuario, String idInstancia, ListaPorIdGrupoHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return grupoHorarioDAO.listaPorIdGrupoHorario(ip, request);
	}
}
