package pe.com.tintegro.services.impl;

import java.io.File;
import javax.annotation.Resource;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.IvrOpcionDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.BuscarIVRPorNombreRequest;
import pe.com.tintegro.dto.request.EditarIvrOpcionRequest;
import pe.com.tintegro.dto.request.EliminarIvrOpcionRequest;
import pe.com.tintegro.dto.request.InsertarIvrOpcionRequest;
import pe.com.tintegro.dto.request.ListarIvrOpcionRequest;
import pe.com.tintegro.dto.response.CRUDResponse;
import pe.com.tintegro.dto.response.InsertarIvrOpcionResponse;
import pe.com.tintegro.dto.response.ListarIvrOpcionResponse;
import pe.com.tintegro.services.GenerarTxtIvrServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.IvrOpcionServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.ServicesProperties;

@Service("ivrOpcionServices")
@Transactional
public class IvrOpcionServicesImpl implements IvrOpcionServices {
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Resource(name = "ivrOpcionDAO")
	protected IvrOpcionDAO ivrOpcionDAO;

	@Autowired
	private GenerarTxtIvrServices generarFileIVRServices;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Autowired
	private ServicesProperties servicesProperties;

	@Override
	public InsertarIvrOpcionResponse insertarIvrResponse(String codUsuario, String idInstancia, InsertarIvrOpcionRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		InsertarIvrOpcionResponse response = ivrOpcionDAO.insertarIvrResponse(ip, request);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		generarFileIVRServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);

		if (request.getpNoAudioBase64() != null && !request.getpNoAudioBase64().equals("") && request.getpNoAudio() != null && !request.getpNoAudio().equals("")) {
			byte[] parseBase64Binary = Base64.decodeBase64(request.getpNoAudioBase64());
			File file = new File(request.getpNoAudio());
			FileUtils.writeByteArrayToFile(file, parseBase64Binary);
			CredencialesEquipo machineDest = infraestructuraUtil.instanciaACredencialesEquipo(vm);
			infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, machineDest, file.getPath(), servicesProperties.getPathFileAsteriskIVRSounds());
		}
		return response;
	}

	public CRUDResponse eliminarIvrResponse(String codUsuario, String idInstancia, EliminarIvrOpcionRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		CRUDResponse response = ivrOpcionDAO.eliminarIvrResponse(ip, request);
		generarFileIVRServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);
		return response;
	}

	public CRUDResponse editarIvrResponse(String codUsuario, String idInstancia, EditarIvrOpcionRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		CRUDResponse response = ivrOpcionDAO.editarIvrResponse(ip, request);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		generarFileIVRServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);
		if (request.getpNoAudioBase64() != null && !request.getpNoAudioBase64().equals("") && request.getpNoAudio() != null && !request.getpNoAudio().equals("")) {
			byte[] parseBase64Binary = Base64.decodeBase64(request.getpNoAudioBase64());
			File file = new File(request.getpNoAudio());
			FileUtils.writeByteArrayToFile(file, parseBase64Binary);
			CredencialesEquipo machineDest = infraestructuraUtil.instanciaACredencialesEquipo(vm);
			infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, machineDest, file.getPath(), servicesProperties.getPathFileAsteriskIVRSounds());
		}
		return response;
	}

	public ListarIvrOpcionResponse listarIvrResponse(String codUsuario, String idInstancia, ListarIvrOpcionRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		ListarIvrOpcionResponse response = ivrOpcionDAO.listarIvrResponse(ip, request);
		return response;
	}

	@Override
	public CRUDResponse buscarIVRPorNombre(String codUsuario, String idInstancia, BuscarIVRPorNombreRequest request) throws Exception {
		CRUDResponse response = new CRUDResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = ivrOpcionDAO.buscarIVRPorNombre(ip, request.getNoIVR());
		return response;
	}
}
