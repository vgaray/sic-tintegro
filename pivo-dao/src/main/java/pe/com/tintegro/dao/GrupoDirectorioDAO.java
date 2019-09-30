package pe.com.tintegro.dao;

import pe.com.tintegro.dto.request.ActualizarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ActualizarGrupoDirectRequest;
import pe.com.tintegro.dto.request.EliminarEntradaDirectRequest;
import pe.com.tintegro.dto.request.EliminarGrupoDirectRequest;
import pe.com.tintegro.dto.request.InsertarEntradaDirectRequest;
import pe.com.tintegro.dto.request.InsertarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ListarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ValidarDirectorioRequest;
import pe.com.tintegro.dto.response.ActualizarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ActualizarGrupoDirectResponse;
import pe.com.tintegro.dto.response.EliminarEntradaDirectResponse;
import pe.com.tintegro.dto.response.EliminarGrupoDirectResponse;
import pe.com.tintegro.dto.response.InsertarEntradaDirectResponse;
import pe.com.tintegro.dto.response.InsertarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ListarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ValidarDirectorioResponse;

public interface GrupoDirectorioDAO 
{
	// Grupo de Directorio
	public ListarGrupoDirectResponse listarGrupoDirectorio(String  ip,ListarGrupoDirectRequest request)throws Exception;
	public InsertarGrupoDirectResponse insertarGrupoDirectorio(String  ip,InsertarGrupoDirectRequest request)throws Exception;
	public ActualizarGrupoDirectResponse actualizarGrupoDirectorio(String  ip,ActualizarGrupoDirectRequest request)throws Exception;
	public EliminarGrupoDirectResponse eliminarGrupoDirectorio(String  ip,EliminarGrupoDirectRequest request)throws Exception;
	public ValidarDirectorioResponse validarGrupoDirectorio(String ip,ValidarDirectorioRequest request)throws Exception;
	
	// Entrada de Directorio	
	public ListarEntradaDirectResponse listarEntradaDirectorio(String  ip,ListarEntradaDirectRequest request)throws Exception;
	public InsertarEntradaDirectResponse insertarEntradaDirectorio(String  ip,InsertarEntradaDirectRequest request)throws Exception;
	public ActualizarEntradaDirectResponse actualizarEntradaDirectorio(String  ip,ActualizarEntradaDirectRequest request)throws Exception;
	public EliminarEntradaDirectResponse eliminarEntradaDirectorio(String  ip,EliminarEntradaDirectRequest request)throws Exception;
	public ValidarDirectorioResponse validarEntradaDirectorio(String ip,ValidarDirectorioRequest request)throws Exception;
	
}	
