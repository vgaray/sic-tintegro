package pe.com.tintegro.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.tintegro.dao.SipTelefonoDAO;
import pe.com.tintegro.dao.util.Constantes;
import pe.com.tintegro.dominio.MarcaTelefono;
import pe.com.tintegro.dominio.ModeloTelefono;
import pe.com.tintegro.dominio.SipTelefono;
import pe.com.tintegro.dto.request.AutoCompletarSipTelefonoRequest;
import pe.com.tintegro.dto.request.BuscaSipBuddieIdRequest;
import pe.com.tintegro.dto.request.ValidaMailBoxRequest;
import pe.com.tintegro.dto.response.AutoCompletarSipTelefonoResponse;
import pe.com.tintegro.dto.response.BuscaSipBuddieIdResponse;
import pe.com.tintegro.dto.response.ListaSipTelefonoResponse;
import pe.com.tintegro.dto.response.ValidaMailBoxResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.SipTelefonoServices;

@Service("sipTelefonoServices")
@Transactional
public class SipTelefonoServicesImpl implements SipTelefonoServices {
	@Resource(name = "sipTelefonoDAO")
	protected SipTelefonoDAO sipTelefonoDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public ListaSipTelefonoResponse listaSipTelefono(String codUsuario, String idInstancia) throws Exception {
		ListaSipTelefonoResponse response = new ListaSipTelefonoResponse();
		String ip = null;
		try {
			ip = instanciaServices.determinarIp(idInstancia);
		} catch (Exception e) {
			throw new Exception(Constantes.MSG_CONNECTION_INSTANCE_FAILED);
		}

		try {
			response = sipTelefonoDAO.listaSipTelefono(ip);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public BuscaSipBuddieIdResponse buscaSipBuddieId(String codUsuario, String idInstancia, BuscaSipBuddieIdRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return sipTelefonoDAO.BuscaSipBuddie(ip, request);
	}

	@Override
	public SipTelefono obtenerSipTelelefonoPorNumeroAnexo(String codUsuario, String idInstancia, String numeroAnexo) throws Exception {
		SipTelefono sipTelefono = new SipTelefono();
		String ip = instanciaServices.determinarIp(idInstancia);
		sipTelefono = sipTelefonoDAO.obtenerSipTelelefonoPorNumeroAnexo(codUsuario, ip, numeroAnexo);
		return sipTelefono;
	}

	@Override
	public MarcaTelefono obtenerMarcaPorNumeroDeAnexo(String codUsuario, String idInstancia, String nuAnexo) throws Exception {
		MarcaTelefono marcaTelefono = new MarcaTelefono();
		String ip = instanciaServices.determinarIp(idInstancia);
		marcaTelefono = sipTelefonoDAO.obtenerMarcaPorNumeroDeAnexo(codUsuario, ip, nuAnexo);
		return marcaTelefono;
	}

	@Override
	public AutoCompletarSipTelefonoResponse AutoCompletarSipTelefono(String codUsuario, String idInstancia, AutoCompletarSipTelefonoRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return sipTelefonoDAO.AutoCompletarSipTelefono(ip, request);
	}

	@Override
	public ModeloTelefono obtenerModeloPorMarcaDeTelefono(String codUsuario, String idInstancia, SipTelefono sipTelefono) throws Exception {
		ModeloTelefono modelo = new ModeloTelefono();
		String ip = instanciaServices.determinarIp(idInstancia);
		modelo = sipTelefonoDAO.obtenerModeloPorMarcaDeTelefono(codUsuario, ip, sipTelefono);
		return modelo;
	}

	@Override
	public ValidaMailBoxResponse validarMailBox(String codUsuario, String idInstancia, ValidaMailBoxRequest request) throws Exception {
		ValidaMailBoxResponse response = new ValidaMailBoxResponse();
		String ip = instanciaServices.determinarIp(idInstancia);
		response = sipTelefonoDAO.validarMailBox(codUsuario, ip, request);
		return response;
	}
}
