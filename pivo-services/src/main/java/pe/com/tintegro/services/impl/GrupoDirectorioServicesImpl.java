package pe.com.tintegro.services.impl;

import java.io.File;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.GrupoDirectorioDAO;
import pe.com.tintegro.dominio.EntradaDirectorio;
import pe.com.tintegro.dominio.GrupoDirectorio;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.ActualizarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ActualizarGrupoDirectRequest;
import pe.com.tintegro.dto.request.EliminarEntradaDirectRequest;
import pe.com.tintegro.dto.request.EliminarGrupoDirectRequest;
import pe.com.tintegro.dto.request.InsertarEntradaDirectRequest;
import pe.com.tintegro.dto.request.InsertarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ListaInstanciaxIdRequest;
import pe.com.tintegro.dto.request.ListarEntradaDirectRequest;
import pe.com.tintegro.dto.request.ListarGrupoDirectRequest;
import pe.com.tintegro.dto.request.ValidarDirectorioRequest;
import pe.com.tintegro.dto.response.ActualizarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ActualizarGrupoDirectResponse;
import pe.com.tintegro.dto.response.EliminarEntradaDirectResponse;
import pe.com.tintegro.dto.response.EliminarGrupoDirectResponse;
import pe.com.tintegro.dto.response.InsertarEntradaDirectResponse;
import pe.com.tintegro.dto.response.InsertarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ListaInstanciaxIdResponse;
import pe.com.tintegro.dto.response.ListarEntradaDirectResponse;
import pe.com.tintegro.dto.response.ListarGrupoDirectResponse;
import pe.com.tintegro.dto.response.ValidarDirectorioResponse;
import pe.com.tintegro.services.GrupoDirectorioServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.EncriptaUtils;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@Service("grupoDirectorioServices")
@Transactional
public class GrupoDirectorioServicesImpl implements GrupoDirectorioServices {
	@Resource(name = "grupoDirectorioDAO")
	protected GrupoDirectorioDAO grupoDirectorioDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	InfraestructuraUtil infraestructuraUtil;

	@Override
	public ListarGrupoDirectResponse listarGrupoDirectorio(String codUsuario, String idInstancia, ListarGrupoDirectRequest request) throws Exception {
		ListarGrupoDirectResponse response = new ListarGrupoDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = grupoDirectorioDAO.listarGrupoDirectorio(ip, request);
		return response;
	}

	@Override
	public InsertarGrupoDirectResponse insertarGrupoDirectorio(String codUsuario, String idInstancia, InsertarGrupoDirectRequest request) throws Exception {
		InsertarGrupoDirectResponse response = new InsertarGrupoDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		response = grupoDirectorioDAO.insertarGrupoDirectorio(ip, request);
		GrupoDirectorio grupo = new GrupoDirectorio();
		grupo.setNoNombre(request.getNoNombre());
		generarArchivoGrupo(codUsuario, idInstancia, Util.ADD, vm, grupo);
		return response;
	}

	@Override
	public ActualizarGrupoDirectResponse actualizarGrupoDirectorio(String codUsuario, String idInstancia, ActualizarGrupoDirectRequest request) throws Exception {
		ActualizarGrupoDirectResponse response = new ActualizarGrupoDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		response = grupoDirectorioDAO.actualizarGrupoDirectorio(ip, request);
		GrupoDirectorio grupo = new GrupoDirectorio();
		grupo.setNoNombre(request.getNoNombre());
		generarArchivoGrupo(codUsuario, idInstancia, Util.UPDATE, vm, grupo);
		return response;
	}

	@Override
	public EliminarGrupoDirectResponse eliminarGrupoDirectorio(String codUsuario, String idInstancia, EliminarGrupoDirectRequest request) throws Exception {
		EliminarGrupoDirectResponse response = new EliminarGrupoDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		GrupoDirectorio grupo = new GrupoDirectorio();
		ListarGrupoDirectRequest requestGrupo = new ListarGrupoDirectRequest();
		requestGrupo.setIdGrupo(request.getIdGrupo());
		grupo.setNoNombre(grupoDirectorioDAO.listarGrupoDirectorio(ip, requestGrupo).getListado().get(0).getNoNombre());
		generarArchivoGrupo(codUsuario, idInstancia, Util.ELIMINAR, vm, grupo);
		response = grupoDirectorioDAO.eliminarGrupoDirectorio(ip, request);
		return response;
	}

	@Override
	public ListarEntradaDirectResponse listarEntradaDirectorio(String codUsuario, String idInstancia, ListarEntradaDirectRequest request) throws Exception {
		ListarEntradaDirectResponse response = new ListarEntradaDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = grupoDirectorioDAO.listarEntradaDirectorio(ip, request);
		return response;
	}

	@Override
	public InsertarEntradaDirectResponse insertarEntradaDirectorio(String codUsuario, String idInstancia, InsertarEntradaDirectRequest request) throws Exception {
		InsertarEntradaDirectResponse response = new InsertarEntradaDirectResponse();

		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		response = grupoDirectorioDAO.insertarEntradaDirectorio(ip, request);

		EntradaDirectorio entrada = new EntradaDirectorio();
		entrada.setNuAnexo(request.getNuAnexo());
		entrada.setNoNombre(request.getNoNombre());

		ListarGrupoDirectRequest requestGrupo = new ListarGrupoDirectRequest();
		requestGrupo.setIdGrupo(request.getIdGrupo());

		ListarGrupoDirectResponse responseGrupo = new ListarGrupoDirectResponse();
		responseGrupo = listarGrupoDirectorio(codUsuario, idInstancia, requestGrupo);
		GrupoDirectorio grupo = new GrupoDirectorio();
		grupo.setNoNombre(responseGrupo.getListado().get(0).getNoNombre());

		generarArchivoEntrada(codUsuario, idInstancia, Util.ADD, vm, entrada, grupo);
		return response;
	}

	@Override
	public ActualizarEntradaDirectResponse actualizarEntradaDirectorio(String codUsuario, String idInstancia, ActualizarEntradaDirectRequest request) throws Exception {
		ActualizarEntradaDirectResponse response = new ActualizarEntradaDirectResponse();

		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		response = grupoDirectorioDAO.actualizarEntradaDirectorio(ip, request);

		EntradaDirectorio entrada = new EntradaDirectorio();
		entrada.setNuAnexo(request.getNuAnexo());
		entrada.setNoNombre(request.getNoNombre());

		ListarGrupoDirectRequest requestGrupo = new ListarGrupoDirectRequest();
		requestGrupo.setIdGrupo(request.getIdGrupo());

		listarGrupoDirectorio(codUsuario, idInstancia, requestGrupo);
		GrupoDirectorio grupo = new GrupoDirectorio();
		grupo.setNoNombre(request.getNoNombre());
		generarArchivoEntrada(codUsuario, idInstancia, Util.UPDATE, vm, entrada, grupo);
		return response;
	}

	@Override
	public EliminarEntradaDirectResponse eliminarEntradaDirectorio(String codUsuario, String idInstancia, EliminarEntradaDirectRequest request) throws Exception {
		EliminarEntradaDirectResponse response = new EliminarEntradaDirectResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);

		EntradaDirectorio entrada = new EntradaDirectorio();
		ListarEntradaDirectRequest requestEntrada = new ListarEntradaDirectRequest();

		requestEntrada.setIdEntrada(request.getIdEntrada());
		requestEntrada.setIdGrupo(request.getIdGrupo());
		entrada = grupoDirectorioDAO.listarEntradaDirectorio(ip, requestEntrada).getListado().get(0);

		ListarGrupoDirectRequest requestGrupo = new ListarGrupoDirectRequest();
		requestGrupo.setIdGrupo(entrada.getIdGrupo());
		GrupoDirectorio grupo = new GrupoDirectorio();
		grupo.setNoNombre(listarGrupoDirectorio(codUsuario, idInstancia, requestGrupo).getListado().get(0).getNoNombre());
		generarArchivoEntrada(codUsuario, idInstancia, Util.ELIMINAR, vm, entrada, grupo);
		response = grupoDirectorioDAO.eliminarEntradaDirectorio(ip, request);
		return response;
	}

	@Override
	public void generarArchivoEntrada(String codUsuario, String idInstancia, Integer tipoOperacion, InstanciaServerAsterisk vm, EntradaDirectorio entrada, GrupoDirectorio grupo) throws Exception {
		try {
			ListaInstanciaxIdRequest request = new ListaInstanciaxIdRequest();
			request.setIdInstancia(idInstancia);

			ListaInstanciaxIdResponse response = instanciaServices.listarIntanciaxIdInstancia(codUsuario, request);
			String empresa = response.getListarInstanciaxId().get(0).getNoRazonSocial().trim().replace(" ", "-");
			String rutaArchivoLdif = servicesProperties.getPathFolderEmpresaLdif() + empresa + "/directorio-" + grupo.getNoNombre().trim().replace(" ", "-");
			String anexoLdif = entrada.getNuAnexo().trim().replace(" ", "-") + ".ldif";

			if (tipoOperacion == 1 || tipoOperacion == 2) {
				// contenido de archivo ldif de grupo
				String contenido = "";
				contenido += "dn: uid=" + entrada.getNoNombre().trim().replace(" ", "-") + ",ou=" + "directorio-" + grupo.getNoNombre().trim().replace(" ", "-") + ",dc=" + empresa + ",dc=com" + System.lineSeparator();
				contenido += "objectClass: inetorgperson" + System.lineSeparator();
				contenido += "uid: " + entrada.getNoNombre().trim().replace(" ", "-") + System.lineSeparator();
				contenido += "sn: " + entrada.getNoNombre().trim().replace(" ", "-") + System.lineSeparator();
				contenido += "cn: " + entrada.getNoNombre().trim().replace(" ", "-") + System.lineSeparator();
				contenido += "initials: a8" + System.lineSeparator();
				contenido += "givenName: " + entrada.getNoNombre().trim().replace(" ", "-") + System.lineSeparator();
				contenido += "homePhone: " + entrada.getNuAnexo() + System.lineSeparator();

				File file = UtilFile.writeFile(contenido, anexoLdif);
				String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), rutaArchivoLdif);
				file.delete();

				String linuxCommand = String.format("sh %s %s %s %s", servicesProperties.getBashPathGenerarLibreta(), response.getListarInstanciaxId().get(0).getNoPasswordLdap(), empresa, rutaArchivoLdif + "/" + anexoLdif);
				LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), linuxCommand);

			} else if (tipoOperacion == 3) {
				String deleteFileDirectory = String.format("rm %s", rutaArchivoLdif + "/" + anexoLdif);
				LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), deleteFileDirectory);
			}
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo");
		}
	}

	@Override
	public void generarArchivoGrupo(String codUsuario, String idInstancia, Integer tipoOperacion, InstanciaServerAsterisk vm, GrupoDirectorio grupo) throws Exception {
		try {
			ListaInstanciaxIdRequest request = new ListaInstanciaxIdRequest();
			request.setIdInstancia(idInstancia);

			ListaInstanciaxIdResponse response = instanciaServices.listarIntanciaxIdInstancia(codUsuario, request);
			String empresa = response.getListarInstanciaxId().get(0).getNoRazonSocial().trim().replace(" ", "-");
			String rutaArchivoLdif = servicesProperties.getPathFolderEmpresaLdif() + empresa;
			String archivoLdif = "directorio-" + grupo.getNoNombre().trim().replace(" ", "-");

			if (tipoOperacion == 1 || tipoOperacion == 2) {
				// creacion de carpeta para entradas de grupo
				LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "mkdir -p " + rutaArchivoLdif + "/directorio-" + grupo.getNoNombre().trim().replace(" ", "-") + "/");

				// contenido de archivo ldif de grupo
				String contenido = "";
				contenido += "dn: ou=" + archivoLdif + ",dc=" + empresa + ",dc=com" + System.lineSeparator();
				contenido += "ou: " + archivoLdif + System.lineSeparator();
				contenido += "objectClass: organizationalUnit" + System.lineSeparator();

				File file = UtilFile.writeFile(contenido, archivoLdif + ".ldif");
				String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), rutaArchivoLdif);
				file.delete();
				LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "expect /var/lib/asterisk/scripts/bash-openldap/ldapadd " + response.getListarInstanciaxId().get(0).getNoPasswordLdap() + " " + empresa
						+ " " + rutaArchivoLdif + "/" + archivoLdif + ".ldif");

			} else if (tipoOperacion == 3) {
				String deleteFileDirectory = String.format("rm -rf %s", rutaArchivoLdif + "/" + archivoLdif);
				LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), deleteFileDirectory);
				String deleteFileLdif = String.format("rm %s", rutaArchivoLdif + "/" + archivoLdif + ".ldif");
				LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), deleteFileLdif);
			}
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura del archivo");
		}
	}

	@Override
	public ValidarDirectorioResponse validarGrupoDirectorio(String codUsuario, String idInstancia, ValidarDirectorioRequest request) throws Exception {
		ValidarDirectorioResponse response = new ValidarDirectorioResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = grupoDirectorioDAO.validarGrupoDirectorio(ip, request);
		return response;
	}

	@Override
	public ValidarDirectorioResponse validarEntradaDirectorio(String codUsuario, String idInstancia, ValidarDirectorioRequest request) throws Exception {
		ValidarDirectorioResponse response = new ValidarDirectorioResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = grupoDirectorioDAO.validarEntradaDirectorio(ip, request);
		return response;
	}
}
