package pe.com.tintegro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.tintegro.dao.BashDAO;
import pe.com.tintegro.dominio.Bash;
import pe.com.tintegro.dominio.InstanciaServerAsterisk;
import pe.com.tintegro.dominio.TipoServer;
import pe.com.tintegro.dto.response.EjecutarBashResponse;
import pe.com.tintegro.services.BashServices;
import pe.com.tintegro.services.InstanciaServices;
import pe.com.tintegro.services.util.LinuxUtil;

@Service("bashServices")
@Transactional
public class BashServicesImpl implements BashServices {
	@Autowired
	InstanciaServices instanciaServices;

	@Autowired
	private LinuxUtil linuxUtil;

	@Autowired
	private BashDAO bashDAO;

	@Override
	public EjecutarBashResponse ejecutarBash(String codUsuario, String idInstancia) throws Exception {
		EjecutarBashResponse response = new EjecutarBashResponse();
		InstanciaServerAsterisk instanciaAsk = instanciaServices.buscarInstancia(codUsuario, idInstancia);

		// String commando = "sh /usr/src/jar-bash.sh " +
		// instanciaAsk.getIpConfInicial() + " " +
		// instanciaAsk.getMaskSubRedConfInicial() + " "
		// +instanciaAsk.getPamConfInicial() + "";
		String commando = "";
		String salida = linuxUtil.ejecutarComando(TipoServer.INSTANCIA_ASTERISK.getTipo(), instanciaAsk, commando);
		response.setSalida(salida);
		return response;
	}

	@Override
	public Bash loadBashById(String codUsuario, Integer idBash) throws Exception {
		Bash bash = new Bash();
		bash = bashDAO.loadBashById(idBash);
		return bash;
	}
}
