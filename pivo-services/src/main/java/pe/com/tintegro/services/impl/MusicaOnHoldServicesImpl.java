package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.MusicaOnHoldDAO;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.MusicaOnHold;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.request.ActualizarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.EliminarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.InsertarMusicaOnHoldRequest;
import pe.com.tintegro.dto.request.ListarMusicaOnHoldRequest;
import pe.com.tintegro.dto.response.ActualizarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.EliminarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.InsertarMusicaOnHoldResponse;
import pe.com.tintegro.dto.response.ListarMusicaOnHoldResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.MusicaOnHoldServices;
import pe.com.tintegro.services.util.InfraestructuraUtil;
import pe.com.tintegro.services.util.LinuxUtil;
import pe.com.tintegro.services.util.ServicesProperties;

@Service("musicaOnHoldServices")
@Transactional
public class MusicaOnHoldServicesImpl implements MusicaOnHoldServices {
	
	@Resource(name = "musicaOnHoldDAO")
	protected MusicaOnHoldDAO musicaOnHoldDAO;
	
	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;
	
	@Autowired
	private InfraestructuraUtil infraestructuraUtil;
	
	@Autowired
	private ServicesProperties servicesProperties;

	@Override
	public ListarMusicaOnHoldResponse listarMusicaOnHold(String codUsuario, String idInstancia, ListarMusicaOnHoldRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return musicaOnHoldDAO.listarMusicaOnHold(ip, request);
	}

	@Override
	public InsertarMusicaOnHoldResponse insertarMusicaOnHold(String codUsuario, String idInstancia, InsertarMusicaOnHoldRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "mkdir " + servicesProperties.getPathFileAsteriskMusicSounds() + request.getpNoClase());
		return musicaOnHoldDAO.insertarMusicaOnHold(ip, request);
	}

	@Override
	public ActualizarMusicaOnHoldResponse actualizarMusicaOnHold(String codUsuario, String idInstancia, ActualizarMusicaOnHoldRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		MusicaOnHold musica = request.getMusica();
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "mv " + servicesProperties.getPathFileAsteriskMusicSounds() + musica.getNoClase() + " " + servicesProperties.getPathFileAsteriskMusicSounds() + request.getpNoClase());
		return musicaOnHoldDAO.actualizarMusicaOnHold(ip, request);
	}

	@Override
	public EliminarMusicaOnHoldResponse eliminarMusicaOnHold(String codUsuario, String idInstancia, EliminarMusicaOnHoldRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		MusicaOnHold musica = request.getMusica();
		InstanciaServerAsterisk vm = instanciaServices.buscarInstancia(codUsuario, idInstancia);
		LinuxUtil.executeCommand(TipoServer.REMOTE.getTipo(), infraestructuraUtil.instanciaACredencialesEquipo(vm), "rm -rf " + servicesProperties.getPathFileAsteriskMusicSounds() + musica.getNoClase());
		return musicaOnHoldDAO.eliminarMusicaOnHold(ip, request);
	}

}
