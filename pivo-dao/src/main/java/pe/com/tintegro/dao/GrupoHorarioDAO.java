package pe.com.tintegro.dao;

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

public interface GrupoHorarioDAO
{
	public InsertaGrupoHorarioResponse insertaGrupoHorario(String ip, InsertaGrupoHorarioRequest request) throws Exception;

	public EditaGrupoHorarioResponse editaGrupoHorario(String ip, EditaGrupoHorarioRequest request) throws Exception;

	public EliminaGrupoHorarioResponse eliminaGrupoHorario(String ip, EliminaGrupoHorarioRequest request) throws Exception;

	public ListaGrupoHorarioResponse listaGrupoHorario(String ip, ListaHorariosLibresRequest request) throws Exception;

	public ListaPorIdGrupoHorarioResponse listaPorIdGrupoHorario(String ip, ListaPorIdGrupoHorarioRequest request) throws Exception;
}
