package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.EditaHorarioRequest;
import pe.com.tintegro.dto.request.EliminaHorarioRequest;
import pe.com.tintegro.dto.request.InsertaHorarioRequest;
import pe.com.tintegro.dto.request.ListaHorariosLibresRequest;
import pe.com.tintegro.dto.request.ListaHorarioRequest;
import pe.com.tintegro.dto.request.ListaPorIdHorarioRequest;
import pe.com.tintegro.dto.response.EditaHorarioResponse;
import pe.com.tintegro.dto.response.EliminaHorarioResponse;
import pe.com.tintegro.dto.response.InsertaHorarioResponse;
import pe.com.tintegro.dto.response.ListaAudiosPredeterminadosResponse;
import pe.com.tintegro.dto.response.ListaHorarioResponse;
import pe.com.tintegro.dto.response.ListaItemResponse;
import pe.com.tintegro.dto.response.ListaPorIdHorarioResponse;

public interface HorarioServices
{
	public InsertaHorarioResponse insertaHorario(String codUsuario, String idInstancia, InsertaHorarioRequest request) throws Exception;

	public EditaHorarioResponse editaHorario(String codUsuario, String idInstancia, EditaHorarioRequest request) throws Exception;

	public EliminaHorarioResponse eliminaHorario(String codUsuario, String idInstancia, EliminaHorarioRequest request) throws Exception;

	public ListaHorarioResponse listaHorario(String codUsuario, String idInstancia, ListaHorarioRequest request) throws Exception;

	public ListaPorIdHorarioResponse listaPorIdHorario(String codUsuario, String idInstancia, ListaPorIdHorarioRequest request) throws Exception;

	public ListaAudiosPredeterminadosResponse listarHorariosPredeterminados( String codUsuario, String idInstancia ) throws Exception;
	
	public ListaItemResponse listarHorariosLibres( String codUsuario, ListaHorariosLibresRequest request, String idInstancia ) throws Exception;
	
	public String obtieneAudioDeServidor( String codUsuario, String idIntancia, String nameAudioFile ) throws Exception;  
}
