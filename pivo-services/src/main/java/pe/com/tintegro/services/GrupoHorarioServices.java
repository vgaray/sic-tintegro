package pe.com.tintegro.services;

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

public interface GrupoHorarioServices
{

	public InsertaGrupoHorarioResponse insertaGrupoHorario(String codUsuario, String idInstancia, InsertaGrupoHorarioRequest request) throws Exception;

	public EditaGrupoHorarioResponse editaGrupoHorario(String codUsuario, String idInstancia, EditaGrupoHorarioRequest request) throws Exception;

	public EliminaGrupoHorarioResponse eliminaGrupoHorario(String codUsuario, String idInstancia, EliminaGrupoHorarioRequest request) throws Exception;

	public ListaGrupoHorarioResponse listaGrupoHorario(String codUsuario, String idInstancia, ListaHorariosLibresRequest request) throws Exception;

	public ListaPorIdGrupoHorarioResponse listaPorIdGrupoHorario(String codUsuario, String idInstancia, ListaPorIdGrupoHorarioRequest request) throws Exception;
}
