package pe.com.tintegro.dao;

import java.util.List;

import pe.com.tintegro.dominio.Item;
import pe.com.tintegro.dto.request.EditaHorarioRequest;
import pe.com.tintegro.dto.request.EliminaHorarioRequest;
import pe.com.tintegro.dto.request.InsertaHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaHorarioRequest;
import pe.com.tintegro.dto.request.ListaPorIdHorarioRequest;
import pe.com.tintegro.dto.response.EditaHorarioResponse;
import pe.com.tintegro.dto.response.EliminaHorarioResponse;
import pe.com.tintegro.dto.response.InsertaHorarioResponse;
import pe.com.tintegro.dto.response.ListaHorarioResponse;
import pe.com.tintegro.dto.response.ListaPorIdHorarioResponse;

public interface HorarioDAO
{
	public InsertaHorarioResponse insertaHorario(String ip, InsertaHorarioRequest request) throws Exception;

	public EditaHorarioResponse editaHorario(String ip, EditaHorarioRequest request) throws Exception;

	public EliminaHorarioResponse eliminaHorario(String ip, EliminaHorarioRequest request) throws Exception;

	public ListaHorarioResponse listaHorario(String ip, ListaHorarioRequest request) throws Exception;

	public ListaPorIdHorarioResponse listaPorIdHorario(String ip, ListaPorIdHorarioRequest request) throws Exception;
	
	public List< Item > listarHorariosLibres(String ip, ListaHorariosLibresRequest request) throws Exception;
}
