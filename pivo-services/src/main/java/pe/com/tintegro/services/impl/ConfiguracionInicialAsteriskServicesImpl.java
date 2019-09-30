package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.IpServerDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.Bash;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.IpServer;
import pe.com.tintegro.dominio.StatusBash;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.EjecutarBashRequest;
import pe.com.tintegro.dto.request.ListarIpServerRequest;
import pe.com.tintegro.dto.response.EjecutarBashResponse;
import pe.com.tintegro.dto.response.ListarIpServerResponse;
import pe.com.tintegro.services.BashServices;
import pe.com.tintegro.services.ConfiguracionInicialAsteriskServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.EncriptaUtils;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.util.ConstantesDAO;

@Service("configuracionInicialAsteriskServices")
@Transactional
public class ConfiguracionInicialAsteriskServicesImpl implements
		ConfiguracionInicialAsteriskServices {

	@Autowired
	InstanciaServices instanciaServices;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private LinuxUtil linuxUtil;

	@Autowired
	private BashServices bashServices;
	

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;
	@Resource(name = "ipServerDAO")
	protected IpServerDAO ipserverDAO;
	private static String MSG_ERROR_LOAD_INSTANCE = "Ocurrió un error al cargar la instancia.";
	private StatusBash statusBash;

	@Override
	public EjecutarBashResponse iniciarBashesAsterisk(String codUsuario,
			String idInstancia) throws Exception {
		EjecutarBashResponse response = new EjecutarBashResponse();
		try {
			crearDbBash(codUsuario, idInstancia, null);
			serverVpn(codUsuario, idInstancia, null);
			faxServer(codUsuario, idInstancia, null);
			fileAsterisk(codUsuario, idInstancia);
		} catch (Exception e) {
			response.setSalida(e.getMessage());
		}
		return response;
	}

	@Override
	public String importBashesToAsteriskServer(String codUser,
			String idInstance, EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		Bash bash = bashServices.loadBashById(codUser, statusBash.getIdBash());
		try {
			if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
				InstanciaServerAsterisk instanciaAsk = null;

				try {
					instanciaAsk = instanciaServices.buscarInstancia(codUser,
							idInstance);
				} catch (Exception e) {
					throw new Exception(MSG_ERROR_LOAD_INSTANCE);
				}
//				System.out.println("pass "+servicesProperties.getFileServerPassword());
//				System.out.println("des pass "+EncriptaUtils.desencriptar(servicesProperties.getFileServerPassword()));
				String comando = String.format("php %s %s %s",
						bash.getNoRuta(),
						servicesProperties.getFileServerDominio(),
						servicesProperties.getFileServerPassword());

				System.out.println(TipoServer.INSTANCIA_ASTERISK.getTipo());
				System.out.println(instanciaAsk);
				System.out.println(comando);

				linuxUtil.ejecutarComando(
						TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk,
						comando);
				salida = verifyService(codUser, Util.IMPORT_SCRIPTS_CONFIG,
						instanciaAsk);
				System.out.println("Salida " + salida);
				if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
					instanciaServices.notifyExecuteBashConfigInitial(codUser,
							bash.getIdBash(), idInstance,
							Constantes.EXECUTE_COMAND_SUCESS);
					if (bash.isIlUltimo()) {
						instanciaServices.updateInstanceStatus(
								ConstantesDAO.INSTANCIA_CONFIGURADA, codUser,
								idInstance);
					}
					return salida;
				} else {
					instanciaServices.notifyExecuteBashConfigInitial(codUser,
							bash.getIdBash(), idInstance,
							Constantes.EXECUTE_COMAND_ERROR);
					throw new Exception(salida);
				}
			} else {
				throw new Exception(Constantes.MSG_OPERATION_DENIED);
			}
		} catch (Exception e) {
			instanciaServices.notifyExecuteBashConfigInitial(codUser,
					bash.getIdBash(), idInstance,
					Constantes.EXECUTE_COMAND_ERROR);
			throw e;
		}
	}

	@Override
	public String crearDbBash(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
			InstanciaServerAsterisk instanciaAsk = null;
			try {
				instanciaAsk = instanciaServices.buscarInstancia(codUsuario,
						idInstancia);
			} catch (Exception e) {
				throw new Exception(MSG_ERROR_LOAD_INSTANCE);
			}
			Bash bash = bashServices.loadBashById(codUsuario,
					statusBash.getIdBash());
			String comando = "sh " + bash.getNoRuta();
			System.out.println("COMANDO EN EJECUCIÓN:"+comando);
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					instanciaAsk, comando);
			salida = verifyService(codUsuario, Util.DATABASE_SERVICE,
					instanciaAsk);
			if (bash.isIlUltimo()) {
				instanciaServices.updateInstanceStatus(
						ConstantesDAO.INSTANCIA_CONFIGURADA, codUsuario,
						idInstancia);
			}
		/*	if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_SUCESS);
				if (bash.isIlUltimo()) {
					instanciaServices.updateInstanceStatus(
							ConstantesDAO.INSTANCIA_CONFIGURADA, codUsuario,
							idInstancia);
				}
				return salida;
			} else {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_ERROR);
				throw new Exception(salida);
			}*/
			return salida;
		} else {
			throw new Exception(Constantes.MSG_OPERATION_DENIED);
		}
	}

	@Override
	public String serverVpn(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
			InstanciaServerAsterisk instanciaAsk = null;
			try {
				instanciaAsk = instanciaServices.buscarInstancia(codUsuario,
						idInstancia);
			} catch (Exception e) {
				throw new Exception(MSG_ERROR_LOAD_INSTANCE);
			}
			Bash bash = bashServices.loadBashById(codUsuario,
					statusBash.getIdBash());
			String comando = "sh " + bash.getNoRuta() + " "
					+ instanciaAsk.getSimPais() + " "
					+ instanciaAsk.getSimProvincia() + " "
					+ instanciaAsk.getFullProvincia().replace(" ", "-") + " "
					+ instanciaAsk.getNoOrgani().replace(" ", "-") + " "
					+ instanciaAsk.getEmail() + " "
					+ instanciaAsk.getPuertoOpenVPN();
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					instanciaAsk, comando);
			salida = verifyService(codUsuario, Util.OPEN_VPN_SERVICE,
					instanciaAsk);
			if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_SUCESS);
				if (bash.isIlUltimo()) {
					instanciaServices.updateInstanceStatus(
							ConstantesDAO.INSTANCIA_CONFIGURADA, codUsuario,
							idInstancia);
				}
				return salida;
			} else {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_ERROR);
				throw new Exception(salida);
			}
		} else {
			throw new Exception(Constantes.MSG_OPERATION_DENIED);
		}
	}

	@Override
	public String faxServer(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
			bashCreateDirectoryFileServer(idInstancia);
			InstanciaServerAsterisk instanciaAsk = null;
			try {
				instanciaAsk = instanciaServices.buscarInstancia(codUsuario,
						idInstancia);
				
			} catch (Exception e) {
				throw new Exception(MSG_ERROR_LOAD_INSTANCE);
			}
			Bash bash = bashServices.loadBashById(codUsuario,
					statusBash.getIdBash());
			String comando = "sh " + bash.getNoRuta();
			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(),
					instanciaAsk, comando);
			salida = verifyService(codUsuario, Util.FAX_SERVICE, instanciaAsk);
			if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_SUCESS);
				if (bash.isIlUltimo()) {
					instanciaServices.updateInstanceStatus(
							ConstantesDAO.INSTANCIA_CONFIGURADA, codUsuario,
							idInstancia);
				}
				return salida;
			} else {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_ERROR);
				throw new Exception(salida);
			}
		} else {
			throw new Exception(Constantes.MSG_OPERATION_DENIED);
		}
		}

	@Override
	public String fileAsterisk(String codUsuario, String idInstancia)
			throws Exception {
		InstanciaServerAsterisk instanciaAsk = null;
		try {
			instanciaAsk = instanciaServices.buscarInstancia(codUsuario,
					idInstancia);
		} catch (Exception e) {
			throw new Exception(MSG_ERROR_LOAD_INSTANCE);
		}
		String comando = "sh "
				+ servicesProperties.getPathBashFilesAsteriskBatch();
		String salida = linuxUtil.ejecutarComando(
				TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk, comando);
		if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
			return salida;
		} else {
			throw new Exception(salida);
		}
	}

	@Override
	public String verifyService(String codUsuario, int serviceID,
			InstanciaServerAsterisk vm) throws Exception {
		String output = null;
		System.out.println("serviceID: " + serviceID);
		String linuxCommand = String.format("sh %s %s",
				servicesProperties.getPathBashVerifyService(), serviceID);
		output = linuxUtil.ejecutarComando(
				TipoServer.INSTANCIA_ASTERISK.getTipo(), vm, linuxCommand);
		// La consola de linux me devuelve una salida con un salto de línea al
		// final
		if (output.equals(String.format("%s\n",
				Constantes.MSG_EXECUTE_COMMAND_SUCCESS)))
			output = Constantes.MSG_EXECUTE_COMMAND_SUCCESS;
		return output;
	}

	@Override
	public String createProvisioningSpace(String codUsuario,
			String idInstancia, EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
			Bash bash = bashServices.loadBashById(codUsuario,
					statusBash.getIdBash());
			String comando = String.format("sh %s %s", bash.getNoRuta(),
					idInstancia);
			salida = LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(),
					infraestructuraUtil.getCredentialsConnectionFileServer(),
					comando);

			if (salida.indexOf(Constantes.MSG_EXECUTE_COMMAND_SUCCESS) != -1) {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_SUCESS);

				/**
				 * Este servicio se llama cuando corresponde a la última
				 * configuración de la instancia.
				 */
				if (bash.isIlUltimo()) {
					instanciaServices.updateInstanceStatus(
							ConstantesDAO.INSTANCIA_CONFIGURADA, codUsuario,
							idInstancia);
				}
				return salida;
			} else {
				instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
						bash.getIdBash(), idInstancia,
						Constantes.EXECUTE_COMAND_ERROR);
				System.out.println("Salida: " + salida);
				throw new Exception(salida);
			}
		} else {
			throw new Exception(Constantes.MSG_OPERATION_DENIED);
		}
	}

	@Override
	public String bashSecurity(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		Bash bash = bashServices.loadBashById(codUsuario,
				statusBash.getIdBash());
		try {
			if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
				InstanciaServerAsterisk instanciaAsk = null;

				try {
					instanciaAsk = instanciaServices.buscarInstancia(
							codUsuario, idInstancia);
				} catch (Exception e) {
					throw new Exception(MSG_ERROR_LOAD_INSTANCE);
				}
				String comando = "";
				switch (instanciaAsk.getTipoInstancia()) {
				case 1://cloud
					comando=String.format("php %s %s %s %s",
							bash.getNoRuta(),"OPENVPN",
							instanciaAsk.getIpAsterisk(),
							instanciaAsk.getPuertoOpenVPN());
					break;
				case 2://Inhouse
					comando=String.format("php %s %s %s %s",
							bash.getNoRuta(), instanciaAsk.getTipoInstancia(),
							instanciaAsk.getIpAsterisk(),
							instanciaAsk.getPuertoOpenVPN());
					break;
				case 3://Hibrido
					comando=String.format("php %s %s %s %s",
							bash.getNoRuta(), instanciaAsk.getTipoInstancia(),
							instanciaAsk.getIpAsterisk(),
							instanciaAsk.getPuertoOpenVPN());
					break;

				default:
					break;
				}
				linuxUtil.ejecutarComando(
						TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk,
						comando);
				salida = verifyService(codUsuario, Util.IMPORT_SECURITY,
						instanciaAsk);

				if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_SUCESS);
					if (bash.isIlUltimo()) {
						instanciaServices.updateInstanceStatus(
								ConstantesDAO.INSTANCIA_CONFIGURADA,
								codUsuario, idInstancia);
					}
					return salida;
				} else {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_ERROR);
					throw new Exception(salida);
				}
			} else {
				throw new Exception(Constantes.MSG_OPERATION_DENIED);
			}
		} catch (Exception e) {
			instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
					bash.getIdBash(), idInstancia,
					Constantes.EXECUTE_COMAND_ERROR);
			throw e;
		}
	}

	@Override
	public String bashOpenLdap(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		String salida = null;
		statusBash = request.getStatusBash();
		Bash bash = bashServices.loadBashById(codUsuario,
				statusBash.getIdBash());
		try {
			if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
				InstanciaServerAsterisk instanciaAsk = null;

				try {
					instanciaAsk = instanciaServices.buscarInstancia(
							codUsuario, idInstancia);
				} catch (Exception e) {
					throw new Exception(MSG_ERROR_LOAD_INSTANCE);
				}
				String comando = String.format("sh %s %s %s", bash.getNoRuta(),
						instanciaAsk.getNoOrgani().replace(" ", "-"),instanciaAsk.getNoPasswordLdap());

				linuxUtil.ejecutarComando(
						TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk,
						comando);
				salida = verifyService(codUsuario, Util.IMPORT_OPENLDAP,
						instanciaAsk);

				if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_SUCESS);
					if (bash.isIlUltimo()) {
						instanciaServices.updateInstanceStatus(
								ConstantesDAO.INSTANCIA_CONFIGURADA,
								codUsuario, idInstancia);
					}
					return salida;
				} else {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_ERROR);
					throw new Exception(salida);
				}
			} else {
				throw new Exception(Constantes.MSG_OPERATION_DENIED);
			}
		} catch (Exception e) {
			instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
					bash.getIdBash(), idInstancia,
					Constantes.EXECUTE_COMAND_ERROR);
			throw e;
		}
	}

	@Override
	public String tlsSecurity(String codUsuario, String idInstancia,
			EjecutarBashRequest request) throws Exception {
		ListarIpServerRequest requestIp = new ListarIpServerRequest();
		ListarIpServerResponse responseIp=new ListarIpServerResponse();
		String salida = null;
		String ip = "";
		statusBash = request.getStatusBash();
		Bash bash = bashServices.loadBashById(codUsuario,
				statusBash.getIdBash());
		try {
			if (statusBash.getIlNext() && statusBash.getNuStatusBash() != 2) {
				InstanciaServerAsterisk instanciaAsk = null;

				try {
					instanciaAsk = instanciaServices.buscarInstancia(
							codUsuario, idInstancia);
				} catch (Exception e) {
					throw new Exception(MSG_ERROR_LOAD_INSTANCE);
				}
				switch (instanciaAsk.getTipoInstancia()) {

				case 1: {
					//ipserver cloud
					requestIp.setpIdTipodetalle(1);
					responseIp=ipserverDAO.listaipserver(requestIp);
					for (IpServer general : responseIp.getIpServerLis()) {
						ip=general.getNoIpServer();
				}
				}
					break;
				case 2: {
					//ipserver inhouse
					requestIp.setpIdTipodetalle(2);
					responseIp=ipserverDAO.listaipserver(requestIp);
					for (IpServer general : responseIp.getIpServerLis()) {
						ip=general.getNoIpServer();
				}
				}
					break;
				case 3: {
					//ipserver hibrido
					requestIp.setpIdTipodetalle(3);
					responseIp=ipserverDAO.listaipserver(requestIp);
					for (IpServer general : responseIp.getIpServerLis()) {
						ip=general.getNoIpServer();
				}
				}
					break;
				default:
					break;
				}
				String comando = String.format("python %s %s %s %s %s",
						bash.getNoRuta(),"-s",ip, instanciaAsk.getNoOrgani().replace(" ", "-"),
						instanciaAsk.getNoPasswordLdap());
				linuxUtil.ejecutarComando(
						TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk,
						comando);
				salida = verifyService(codUsuario, Util.IMPORT_TLSSECURITY,
						instanciaAsk);

				if (salida.equals(Constantes.MSG_EXECUTE_COMMAND_SUCCESS)) {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_SUCESS);
					if (bash.isIlUltimo()) {
						instanciaServices.updateInstanceStatus(
								ConstantesDAO.INSTANCIA_CONFIGURADA,
								codUsuario, idInstancia);
					}
					return salida;
				} else {
					instanciaServices.notifyExecuteBashConfigInitial(
							codUsuario, bash.getIdBash(), idInstancia,
							Constantes.EXECUTE_COMAND_ERROR);
					throw new Exception(salida);
				}
			} else {
				throw new Exception(Constantes.MSG_OPERATION_DENIED);
			}
		} catch (Exception e) {
			instanciaServices.notifyExecuteBashConfigInitial(codUsuario,
					bash.getIdBash(), idInstancia,
					Constantes.EXECUTE_COMAND_ERROR);
			throw e;
		}
	}

	@Override
	public void bashCreateDirectoryFileServer(String idInstancia) throws Exception {
		String provisioning = String.format(
				"sh %s %s",
				servicesProperties.getPathBashCreateDirectoryFileServer(),idInstancia);
		LinuxUtil.executeCommand(
				TipoServer.FILE_SERVER.getTipo(),
				infraestructuraUtil.getCredentialsConnectionFileServer(),
				provisioning);	
		
	}
}
