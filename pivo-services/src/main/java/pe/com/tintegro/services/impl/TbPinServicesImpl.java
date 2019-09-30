package pe.com.tintegro.services.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.TbPinDAO;
import pe.com.tintegro.dto.request.BuscaPinRequest;
import pe.com.tintegro.dto.request.FlagTbPinRequest;
import pe.com.tintegro.dto.request.PinValidar;
import pe.com.tintegro.dto.response.BuscaPinResponse;
import pe.com.tintegro.dto.response.FlagTbPinResponse;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.TbPinServices;

@Service("tbPinServices")
@Transactional
public class TbPinServicesImpl implements TbPinServices {

	@Resource(name = "tbPinDAO")
	protected TbPinDAO tbPinDAO;

	@Resource(name = "instanciaServices")
	protected InstanciaServices instanciaServices;

	@Override
	public FlagTbPinResponse modificarFlagTbPin(String codUsuario, String idInstancia, FlagTbPinRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbPinDAO.modificarflagTbPin(ip, request);
	}

	@Override
	public FlagTbPinResponse pinValidar(String codUsuario, String idInstancia, PinValidar request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbPinDAO.valivarPing(ip, request);
	}

	public BuscaPinResponse buscaPin(String codUsuario, String idInstancia, BuscaPinRequest request) throws Exception {
		String ip = instanciaServices.determinarIp(idInstancia);
		return tbPinDAO.BuscaPin(ip, request);
	}
}