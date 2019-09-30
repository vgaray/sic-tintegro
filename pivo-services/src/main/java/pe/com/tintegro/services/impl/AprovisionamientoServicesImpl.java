package pe.com.tintegro.services.impl;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jcraft.jsch.JSchException;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipBuddie;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.services.AprovisionamientoServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.SSHManager;
import pe.com.tintegro.services.util.ServicesProperties;

@Service("aprovisionamientoServices")
@Transactional
public class AprovisionamientoServicesImpl implements AprovisionamientoServices {
	
	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private LinuxUtil linuxUtil;

	@Override
	public boolean generateProvisioning(String codUsuario, Integer puertoOpenVPN, SipBuddie sipBuddie, SipTelefono sipTelefono, InstanciaServerAsterisk vm) throws Exception {
		boolean provisioningFinished = false;
		try {
			String idCliente = linuxUtil.generateClientID(vm, sipBuddie);
			String linuxCommand = String.format("sh %s %s %s %s %s %s-%s %s %s %s %s", servicesProperties.getPathBashCrearAprovisionamiento(), vm.getIpAsterisk(), vm.getPuertoOpenVPN(), sipBuddie.getName(), idCliente, sipTelefono.getNomMarca(), sipTelefono.getNomModelo(), sipTelefono.getNomMac(),
					sipTelefono.getCallerId().indexOf(" ") != -1 ? String.format("\"%s\"", sipTelefono.getCallerId()) : sipTelefono.getCallerId(), sipTelefono.getClaveUsuario(), servicesProperties.getFileServerDominio());

			linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(), vm, linuxCommand);

			provisioningFinished = true;
		} catch (Exception e) {
			throw e;
		}
		return provisioningFinished;
	}

	@Override
	public boolean redirectFileConfigurationSip(String codUsuario, SipTelefono sipTelefono, String idInstancia) throws Exception {
		boolean fileConfigRedirected = false;

		CredencialesEquipo fileServer = new CredencialesEquipo();
		fileServer.setUser(servicesProperties.getFileServerUser());
		fileServer.setPassword(servicesProperties.getFileServerPassword());
		fileServer.setPort(servicesProperties.getFileServerPort());
		fileServer.setHost(servicesProperties.getFileServerHost());

		SSHManager sshManager;

		try {
			final int TIME_OUT_CONNECTION = 60000;

			sshManager = new SSHManager(fileServer.getUser(), fileServer.getPassword(), fileServer.getHost(), TIME_OUT_CONNECTION, fileServer.getPort());
			sshManager.connect();

			String nomMac = sipTelefono.getNomMac();
			String linuxCommand = String.format("ln -s %s/%s.cfg %s/%s/%s.cfg", servicesProperties.getPathFolderAprovisionamientoLocalServerFTP(), nomMac, servicesProperties.getPathFolderAprovisionamientoLocalServerHTTP(), idInstancia, nomMac);

			sshManager.sendCommand(linuxCommand);
			sshManager.close();
			fileConfigRedirected = true;
		} catch (JSchException | IOException e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return fileConfigRedirected;
	}

	@Override
	public boolean redirectKeysOpenVPN(String codUsuario, SipBuddie buddie, SipTelefono sipTelefono, boolean isProvisioning, InstanciaServerAsterisk vm, String idInstancia) throws Exception {
		boolean keysRedirected = false;

		try {
			String nameFileCompressed = isProvisioning ? String.format("openvpn-%s-%s.tar", linuxUtil.generateClientID(vm, buddie), buddie.getName()) : String.format("client-%s-%s.zip", linuxUtil.generateClientID(vm, buddie), buddie.getName());

			String linuxCommand = String.format("ln -s %s/%s %s/%s/%s", servicesProperties.getPathFolderAprovisionamientoLocalServerFTP(), nameFileCompressed, servicesProperties.getPathFolderAprovisionamientoLocalServerHTTP(), idInstancia, nameFileCompressed);

			linuxUtil.ejecutarComando(TipoServer.FILE_SERVER.getTipo(), null, linuxCommand);

			keysRedirected = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw e;
		}
		return keysRedirected;
	}
}