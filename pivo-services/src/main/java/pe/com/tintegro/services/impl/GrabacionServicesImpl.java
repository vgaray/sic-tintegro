package pe.com.tintegro.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.GrabacionDAO;
import pe.com.tintegro.dominio.Grabacion;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.GrabacionRequest;
import pe.com.tintegro.dto.response.GrabacionResponse;
import pe.com.tintegro.services.GrabacionServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.infraestructura.CredencialesEquipo;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.SCPManager;
import pe.com.tintegro.services.util.ServicesProperties;
import pe.com.tintegro.services.util.Util;


@Service("grabacionServices")
@Transactional
public class GrabacionServicesImpl implements GrabacionServices {

	private SCPManager scpManager;
	@Resource(name = "grabacionDAO")
	protected GrabacionDAO grabacionDAO;
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;
	@Autowired
	private InfraestructuraUtil infraestructuraUtil;
	@Autowired
	private ServicesProperties servicesProperties;

	@Override
	public GrabacionResponse listarDesdeCarpeta(String codUsuario, String idInstancia, GrabacionRequest request, CredencialesEquipo machine, String folderPath, int typeFiles, String[] allowedExtensions) throws Exception {
		Grabacion ga = new Grabacion();
		GrabacionResponse response = new GrabacionResponse();
		List<Grabacion> lsArchivos = new ArrayList<Grabacion>();
		scpManager = new SCPManager(machine.getUser(), machine.getPassword(), machine.getHost(), SCPManager.TIME_OUT_DEFAULT, machine.getPort());
		scpManager.connect();
		System.out.println("Folder del Test:" + folderPath);
		String linuxCommand = String.format("( cd %s && %s )", folderPath, typeFiles == Util.FILES_AND_DIRECTORIES ? "ls" : typeFiles == Util.FILES ? "ls -F | grep -v '/$'" : "ls -F | grep '/$'");

		String listarArchivos = LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(), machine, String.format("%s", linuxCommand));

		scpManager.close();

		StringTokenizer tokenizer = new StringTokenizer(listarArchivos, "\n");

		String nameFile;

		do {
			nameFile = tokenizer.nextToken();
			ga.setNombreAudio("" + nameFile);
			ga.setFecha("por confirmar Fecha");
			ga.setHora("por confirmar Hora");
			ga.setTipo("" + request.getTipo());
			ga.setOrigen("origen" + request.getOrigen());
			ga.setDestino("destino" + request.getDestino());
			ga.setDuracion("Tamaño bytes:" + nameFile.length());
			lsArchivos.add(ga);
		} while (tokenizer.hasMoreTokens());

		response.setLsAudioA((ArrayList<Grabacion>) lsArchivos);
		return response;
	}

	@Override
	public GrabacionResponse listarGrabaciones(String codUsuario, String idInstancia, GrabacionRequest request) throws Exception {
		GrabacionResponse response = new GrabacionResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = grabacionDAO.listarGrabaciones(ip, request);
		return response;
	}

}
