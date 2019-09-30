package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.SipTrunkDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.SipTrunk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.EditaSipTrunkRequest;
import pe.com.tintegro.dto.request.EliminaSipTrunkRequest;
import pe.com.tintegro.dto.request.InsertaSipTrunkRequest;
import pe.com.tintegro.dto.request.ListaSipTrunkRequest;
import pe.com.tintegro.dto.response.EditaSipTrunkResponse;
import pe.com.tintegro.dto.response.EliminaSipTrunkResponse;
import pe.com.tintegro.dto.response.InsertaSipTrunkResponse;
import pe.com.tintegro.dto.response.ListaSipTrunkResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.SipTrunkServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.UtilFile;

@Service("sipTrunkServices")
@Transactional
public class SipTrunkServicesImpl implements SipTrunkServices {
	@Resource(name = "sipTrunkDAO")
	protected SipTrunkDAO sipTrunkDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;
	
	@Autowired
	private ServicesProperties servicesProperties;
	
	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Override
	public InsertaSipTrunkResponse insertaSipTrunk(String codUsuario, String idInstancia, InsertaSipTrunkRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		InsertaSipTrunkResponse response = sipTrunkDAO.insertaSipTrunk(ip, request);
		generarSipTrunkTxt(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EditaSipTrunkResponse editaSipTrunk(String codUsuario, String idInstancia, EditaSipTrunkRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		EditaSipTrunkResponse response = sipTrunkDAO.editaSipTrunk(ip, request);
		generarSipTrunkTxt(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminaSipTrunkResponse eliminaSipTrunk(String codUsuario, String idInstancia, EliminaSipTrunkRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		EliminaSipTrunkResponse response = sipTrunkDAO.eliminaSipTrunk(ip, request);
		generarSipTrunkTxt(codUsuario, idInstancia);
		return response;
	}

	@Override
	public ListaSipTrunkResponse listaSipTrunk(String codUsuario, String idInstancia, ListaSipTrunkRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return sipTrunkDAO.listaSipTrunk(ip, request);
	}

	@Override
	public String writeSipTrunk(List<SipTrunk> lstSipTrunk) {
		String contenido = "";
		try {
			ArrayList<String> nomCodec = null;
			ArrayList<String> nomPermit = null;
			for (SipTrunk sipTrunk : lstSipTrunk) {
				contenido += "[" + sipTrunk.getNomSaliente() + "]" + System.getProperty("line.separator");
				contenido += "type=" + sipTrunk.getTipoSaliente() + System.getProperty("line.separator");
				contenido += "trunk=yes" + System.getProperty("line.separator");
				contenido += "qualify=yes" + System.getProperty("line.separator");
				contenido += "trustrpid=yes" + System.getProperty("line.separator");
				contenido += "sendrpid=yes" + System.getProperty("line.separator");
				contenido += "canreinvite=no" + System.getProperty("line.separator");
				contenido += "host=" + sipTrunk.getHostSaliente() + System.getProperty("line.separator");
				contenido += "username=" + sipTrunk.getUsernameSaliente() + System.getProperty("line.separator");
				contenido += "callerid=" + sipTrunk.getOutboundCid() + " <" + sipTrunk.getOutboundCid() + ">" + System.getProperty("line.separator");
				contenido += "disallow=all" + System.getProperty("line.separator");
				nomCodec = new ArrayList<String>(Arrays.asList(sipTrunk.getNomCodecs().split(",")));
				for (int i = 0; i < nomCodec.size(); i++) {
					contenido += "allow=" + nomCodec.get(i) + System.getProperty("line.separator");
				}
				contenido += "dtmfmode=" + sipTrunk.getDtmf() + System.getProperty("line.separator");
				contenido += "deny=0.0.0.0/0.0.0.0" + System.getProperty("line.separator");
				nomPermit = new ArrayList<String>(Arrays.asList(sipTrunk.getNomPermits().split(",")));
				for (int i = 0; i < nomPermit.size(); i++) {
					contenido += "permit=" + nomPermit.get(i) + System.getProperty("line.separator");
				}
				if (sipTrunk.getRegistrar() != null || sipTrunk.getRegistrar() != "") {
					contenido += "register=" + sipTrunk.getRegistrar() + System.getProperty("line.separator");
				}
				contenido += System.getProperty("line.separator");
				contenido += "[" + sipTrunk.getNomEntrante() + "]" + System.getProperty("line.separator");
				contenido += "type=" + sipTrunk.getTipoEntrante() + System.getProperty("line.separator");
				contenido += "secret=" + sipTrunk.getSecretEntrante() + System.getProperty("line.separator");
				contenido += "context=" + sipTrunk.getContextEntrante() + System.getProperty("line.separator");
				contenido += System.getProperty("line.separator");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return contenido;
	}

	@Override
	public String generarSipTrunkTxt(String codUsuario, String idInstancia) throws Exception {
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);

		ListaSipTrunkResponse lstSipTrunkResponse = listaSipTrunk(codUsuario, idInstancia, new ListaSipTrunkRequest());

		String contenido = writeSipTrunk(lstSipTrunkResponse.getListaSipTrunk());
		File file = UtilFile.writeFile(contenido, servicesProperties.getFileNameSipTrunk());
		String fileExport = infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.INSTANCIA_ASTERISK.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), file.getPath(), servicesProperties.getPathFileSipTrunk());
		file.delete();
		System.out.println(fileExport);
		try {
			LinuxUtil.executeCommand(TipoServer.INSTANCIA_ASTERISK.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "asterisk -rx 'dialplan reload'");
		} catch (Exception e) {
			throw new Exception("Fallo en la escritura de de sip trunk");
		}
		return contenido;
	}
}