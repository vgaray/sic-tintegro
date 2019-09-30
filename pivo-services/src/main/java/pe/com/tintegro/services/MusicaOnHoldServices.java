package pe.com.tintegro.services;

import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;

public interface MusicaOnHoldServices
{
	public ListarMusicaOnHoldResponse listarMusicaOnHold(String codUsuario, String idInstancia, ListarMusicaOnHoldRequest request) throws Exception;

	public InsertarMusicaOnHoldResponse insertarMusicaOnHold(String codUsuario, String idInstancia, InsertarMusicaOnHoldRequest request) throws Exception;

	public ActualizarMusicaOnHoldResponse actualizarMusicaOnHold(String codUsuario, String idInstancia, ActualizarMusicaOnHoldRequest request) throws Exception;

	public EliminarMusicaOnHoldResponse eliminarMusicaOnHold(String codUsuario, String idInstancia, EliminarMusicaOnHoldRequest request) throws Exception;

}
