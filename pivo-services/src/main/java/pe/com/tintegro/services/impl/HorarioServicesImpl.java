package pe.com.tintegro.services.impl;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.HorarioDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.Item;
import pe.com.tintegro.dominio.TipoServer;
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
import pe.com.tintegro.services.GenerarTxtIvrServices;
import pe.com.tintegro.services.HorarioServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;
import pe.com.tintegro.services.util.UtilFile;

@Service("horarioServices")
@Transactional
public class HorarioServicesImpl implements HorarioServices {
	
	@Resource(name = "horarioDAO")
	protected HorarioDAO horarioDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Autowired
	private InfraestructuraUtil infraestructuraUtil;

	@Autowired
	private ServicesProperties servicesProperties;

	@Autowired
	private GenerarTxtIvrServices generarTxtServices;

	@Override
	public InsertaHorarioResponse insertaHorario(String codUsuario, String idInstancia, InsertaHorarioRequest request) throws Exception {
		InsertaHorarioResponse response = new InsertaHorarioResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = horarioDAO.insertaHorario(ip, request);

		if (response.getEstado() == 1) {
			if (request.getBase64Audio() != null) {
				InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
				File fileSound = UtilFile.decodificarToFile(request.getBase64Audio(), request.getNomAudio());

				infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), fileSound.getAbsolutePath(), servicesProperties.getPathFileAsteriskIVRSounds());
				//infraestructuraUtil.copyFile( TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, infraestructuraUtil.getCredentialsConnectionMediaServer(), fileSound.getAbsolutePath(),	 servicesProperties.getPathFileMediaServerIvrSounds() );

				fileSound.delete();
			}
			generarTxtServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);
		}
		return response;
	}

	@Override
	public EditaHorarioResponse editaHorario(String codUsuario, String idInstancia, EditaHorarioRequest request) throws Exception {
		EditaHorarioResponse response = new EditaHorarioResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		if (request.getBase64Audio() != null) {
			InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
			File fileSound = UtilFile.decodificarToFile(request.getBase64Audio(), request.getNomAudio());

			infraestructuraUtil.copyFile(TipoServer.LOCAL.getTipo(), TipoServer.REMOTE.getTipo(), null, infraestructuraUtil.instanciaACredencialesEquipo(vm), fileSound.getAbsolutePath(), servicesProperties.getPathFileAsteriskIVRSounds());
			// infraestructuraUtil.copyFile( TipoServer.LOCAL.getTipo(),
			// TipoServer.REMOTE.getTipo(), null,
			// infraestructuraUtil.getCredentialsConnectionMediaServer(),
			// fileSound.getAbsolutePath(),
			// servicesProperties.getPathFileMediaServerIvrSounds() );

			fileSound.delete();
		}
		response = horarioDAO.editaHorario(ip, request);
		generarTxtServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);
		return response;
	}

	@Override
	public EliminaHorarioResponse eliminaHorario(String codUsuario, String idInstancia, EliminaHorarioRequest request) throws Exception {
		EliminaHorarioResponse response = new EliminaHorarioResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = horarioDAO.eliminaHorario(ip, request);
		generarTxtServices.generarArchivoIVREnServidorAsterisk(codUsuario, idInstancia);
		return response;
	}

	@Override
	public ListaHorarioResponse listaHorario(String codUsuario, String idInstancia, ListaHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return horarioDAO.listaHorario(ip, request);
	}

	@Override
	public ListaPorIdHorarioResponse listaPorIdHorario(String codUsuario, String idInstancia, ListaPorIdHorarioRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return horarioDAO.listaPorIdHorario(ip, request);
	}

	@Override
	public ListaAudiosPredeterminadosResponse listarHorariosPredeterminados(String codUsuario, String idInstancia) throws Exception {
		ListaAudiosPredeterminadosResponse response = new ListaAudiosPredeterminadosResponse();
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		List<String> files = infraestructuraUtil.listarDesdeCarpeta(infraestructuraUtil.instanciaACredencialesEquipo(vm), servicesProperties.getPathFileAsteriskIVRSounds(), Util.FILES, new String[] { ".mp3", ".wav" });
		response.setLsAudiosPredeterminados(files);
		return response;
	}

	@Override
	public ListaItemResponse listarHorariosLibres(String codUsuario, ListaHorariosLibresRequest request, String idInstancia) throws Exception {
		ListaItemResponse response = new ListaItemResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		List<Item> lsItems = horarioDAO.listarHorariosLibres(ip, request);
		response.setLsItems(lsItems);
		return response;
	}

	@Override
	public String obtieneAudioDeServidor(String codUsuario, String idInstancia, String nameAudioFile) throws Exception {
		String fileBase64 = null;
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		CredencialesEquipo machineSrc = infraestructuraUtil.instanciaACredencialesEquipo(vm);

		File file = new File("tempFile");
		String pathFile = Util.getCurrentPathDirectory();
		String srcPath = servicesProperties.getPathFileAsteriskIVRSounds() + "/" + nameAudioFile;
		infraestructuraUtil.copyFile(TipoServer.REMOTE.getTipo(), TipoServer.LOCAL.getTipo(), machineSrc, null, srcPath, pathFile);
		
		try {
			file = new File(pathFile + "/" + nameAudioFile);
			if (file != null) {
				fileBase64 = UtilFile.codificarToBase64(file);
			}
		} catch (Exception e) {
			throw new Exception("No se encuentra archivo " + nameAudioFile);
		}
		return fileBase64;
	}
}
