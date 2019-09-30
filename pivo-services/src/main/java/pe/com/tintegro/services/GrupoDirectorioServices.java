package pe.com.tintegro.services;

import pe.com.tintegro.dominio.EntradaDirectorio;
import pe.com.tintegro.dominio.GrupoDirectorio;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
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

public interface GrupoDirectorioServices
{
	//Grupo de Directorios
	public ListarGrupoDirectResponse listarGrupoDirectorio(String codUsuario,String idInstancia,ListarGrupoDirectRequest request)throws Exception;
	public InsertarGrupoDirectResponse insertarGrupoDirectorio(String codUsuario,String idInstancia,InsertarGrupoDirectRequest request)throws Exception;
	public ActualizarGrupoDirectResponse actualizarGrupoDirectorio(String codUsuario,String idInstancia,ActualizarGrupoDirectRequest request)throws Exception;
	public EliminarGrupoDirectResponse eliminarGrupoDirectorio(String codUsuario,String idInstancia,EliminarGrupoDirectRequest request)throws Exception;
	public void generarArchivoGrupo(String codUsuario,String idInstancia, Integer tipoOperacion,InstanciaServerAsterisk vm,GrupoDirectorio grupo)throws Exception;
	public ValidarDirectorioResponse validarGrupoDirectorio(String codUsuario,String idInstancia,ValidarDirectorioRequest request)throws Exception;
	
	
	//Entrada de Directorio
	public ListarEntradaDirectResponse listarEntradaDirectorio(String codUsuario,String idInstancia,ListarEntradaDirectRequest request)throws Exception;
	public InsertarEntradaDirectResponse insertarEntradaDirectorio(String codUsuario,String idInstancia,InsertarEntradaDirectRequest request)throws Exception;
	public ActualizarEntradaDirectResponse actualizarEntradaDirectorio(String codUsuario,String idInstancia,ActualizarEntradaDirectRequest request)throws Exception;
	public EliminarEntradaDirectResponse eliminarEntradaDirectorio(String codUsuario,String idInstancia,EliminarEntradaDirectRequest request)throws Exception;
	public void generarArchivoEntrada(String codUsuario,String idInstancia, Integer tipoOperacion,InstanciaServerAsterisk vm,EntradaDirectorio entrada,GrupoDirectorio grupo)throws Exception;
	public ValidarDirectorioResponse validarEntradaDirectorio(String codUsuario,String idInstancia,ValidarDirectorioRequest request)throws Exception;
}
