package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;

public interface MusicaOnHoldDAO
{
	public ListarMusicaOnHoldResponse listarMusicaOnHold(String ip, ListarMusicaOnHoldRequest request) throws Exception;

	public InsertarMusicaOnHoldResponse insertarMusicaOnHold(String ip, InsertarMusicaOnHoldRequest request) throws Exception;

	public ActualizarMusicaOnHoldResponse actualizarMusicaOnHold(String ip, ActualizarMusicaOnHoldRequest request) throws Exception;

	public EliminarMusicaOnHoldResponse eliminarMusicaOnHold(String ip, EliminarMusicaOnHoldRequest request) throws Exception;

}
